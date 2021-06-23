package com.ll.stat.domain;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 14:20
 */

public class BaseEntity {
    private String name;
    private Double value;

    public BaseEntity() {
    }

    public BaseEntity(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
