package com.example.itdstask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Failed to parse json returned from external api")
public class JsonParseException extends Exception {
}
