package com.example.crud.Model;

import java.util.List;

public class responModel {
    int status;
    boolean error;
    String message;
    List<dataModel> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<dataModel> getData() {
        return data;
    }

    public void setData(List<dataModel> data) {
        this.data = data;
    }
}
