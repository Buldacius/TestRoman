package api.ProjectOne.Spec.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorReg {
    private String error;

    public ErrorReg() {
    }

    public ErrorReg(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
