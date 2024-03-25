package br.com.revenda.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timestamp = new Date();
    private String status = "error";
    private int statusCode = 400;
    private String error;

    public ExceptionResponse(Date timestamp, String status, int statusCode, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.statusCode = statusCode;
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
