package com.halonsov.examples.exchangerate.controller.response;

import java.util.List;
import com.halonsov.examples.exchangerate.controller.response.enums.StatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GeneralResponse", description = "Entity containing generic response.")
public class GeneralResponse {
    /**
     * Execution status
     */
    @ApiModelProperty(name = "status", value = "execution status", required = true, example = "OK")
    protected StatusEnum status;

    /**
     * Execution error list
     */
    @ApiModelProperty(name = "errors", value = "execution error list", required = true)
    protected List<String> errors;

    public GeneralResponse() {
    }

    public GeneralResponse(StatusEnum status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public StatusEnum getStatus() {
        return this.status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
