package com.stdio.hue.yoga.data.models.base;

import android.databinding.BaseObservable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/21/18.
 */
public class BaseResponse<T> extends BaseObservable implements Serializable {
    private T data;
    private List<Error> errors;
    private boolean hasError;

    public BaseResponse() {
        errors = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
}
