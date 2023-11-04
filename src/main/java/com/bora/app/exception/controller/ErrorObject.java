package com.bora.app.exception.controller;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;


@Data
@Builder
public class ErrorObject {

    private Integer statusCode;
    private String message;
    private LocalDate timeStamp;

}
