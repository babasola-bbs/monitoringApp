package com.checkly.watch.apiCheck;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiModel {

    private String status;
    private String code;
    private String message;
    private Object data;
}
