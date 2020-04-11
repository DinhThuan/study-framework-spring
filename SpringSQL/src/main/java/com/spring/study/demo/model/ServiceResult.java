package com.spring.study.demo.model;

import lombok.Data;

@Data
public class ServiceResult {
    private Status status = Status.SUCCESS;
    private String message;
    private Object data;
    private String code;

    public enum Status {
        SUCCESS, FAILED;
    }
}
