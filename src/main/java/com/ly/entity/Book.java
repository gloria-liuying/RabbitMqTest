package com.ly.entity;

import java.io.Serializable;

public class Book implements Serializable{

        private static final long serialVersionUID = 1234567890L;
        private String id;
        private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
