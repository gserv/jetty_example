package com.github.gserv.example.jetty.entry;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by shiying on 2016/4/10.
 */
@Entity
@Table(name="T_DEMO_TABLE")
public class DemoTable implements Serializable {

    private Long id;

    private String name;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
