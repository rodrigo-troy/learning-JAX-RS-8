package com.rodrigotroy.learningjaxrs.domain;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 23-11-24
 * Time: 21:35
 */
@javax.xml.bind.annotation.XmlRootElement
public class OperationResponse {
    private Boolean isError;
    private String message;
    private Double result;

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Boolean isError;
        private String message;
        private Double result;

        public Builder withIsError(Boolean isError) {
            this.isError = isError;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withResult(Double result) {
            this.result = result;
            return this;
        }

        public OperationResponse build() {
            OperationResponse response = new OperationResponse();
            response.setIsError(isError);
            response.setMessage(message);
            response.setResult(result);
            return response;
        }
    }
}
