package com.example.demo.entity;

public class Task {
    private Integer id;
    private Integer type;
    private String cronExpression;

    public Task() {
    }

    public Task(Integer id, Integer type, String cronExpression) {
        this.id = id;
        this.type = type;
        this.cronExpression = cronExpression;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", type=" + type +
                ", cronExpression='" + cronExpression + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
