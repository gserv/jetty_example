package com.github.gserv.example.jetty.dao;

import com.github.gserv.example.jetty.entry.DemoTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by shiying on 2016/4/10.
 */
public interface DemoTableDao extends PagingAndSortingRepository<DemoTable, Long> {

    @Query("select t from DemoTable t where t.name like %?1%")
    List<DemoTable> findByNameKey(String nameKey);

    // 自动解析为(HQL)：select t from DemoTable t where t.name = ?1
    DemoTable findByName(String name);

}
