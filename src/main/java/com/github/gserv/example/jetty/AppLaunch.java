package com.github.gserv.example.jetty;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class AppLaunch {
	
	public static void main(String[] args) throws Exception {
		System.out.println("正在启动服务...");
		//
		configLogger();
		Logger logger = LoggerFactory.getLogger(AppLaunch.class);
		//
		try {
			//获取jetty配置文件
			Resource resource = new FileSystemResource("./configs/app-main.xml");
			//初始化spring容器
			AbstractApplicationContext appContext = new GenericXmlApplicationContext(new Resource[]{resource});
			appContext.registerShutdownHook();
			System.setProperty("org.eclipse.jetty.util.URI.charset", "UTF-8");
		    logger.info("开始启动服务");

		    Server server = appContext.getBean("server", Server.class);

		    server.start();

		    logger.info("服务已启动，" + server.getConnectors()[0]);
		    
		} catch (Exception ex) {
			System.out.println("服务启动失败！");
			ex.printStackTrace(System.out);
			System.exit(-1);
			throw ex;
		}
	}


	private static void configLogger() {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			context.reset();
			String v = "./configs/logback.xml";
			configurator.doConfigure(v);
		} catch (JoranException je) {
			je.printStackTrace();
		}
	}


}
