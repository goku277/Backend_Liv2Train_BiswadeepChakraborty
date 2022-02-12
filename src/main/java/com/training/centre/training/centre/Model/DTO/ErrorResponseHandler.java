package com.training.centre.training.centre.Model.DTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
@Component
@ControllerAdvice
@JsonInclude(JsonInclude.Include.NON_NULL)

/**
 *  ErrorResponseHandler is a custom Exception Handling class
 *  Fields are errorCode, errorStatus, errorMessage
 *  to validate the instructed fields like CenterName, CenterCode,
 *  ContactEmail & ContactPhone
 */

public class ErrorResponseHandler extends RuntimeException {
    private int errorCode;
    private String errorStatus;
    private String errorMessage;

    public ErrorResponseHandler(int errorCode, String errorStatus, String errorMessage) {
        super(errorMessage,null, false, false);
        this.errorCode = errorCode;
        this.errorStatus = errorStatus;
        this.errorMessage = errorMessage;
    }
    public ErrorResponseHandler() {
    }
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorStatus() {
        return errorStatus;
    }
    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}