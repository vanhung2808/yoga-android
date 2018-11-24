package com.stdio.hue.yoga.modules.collections.models;

import android.databinding.BaseObservable;

import com.stdio.hue.yoga.data.models.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
public class FilterClasses extends BaseObservable implements Serializable {
    private List<Classes> classes;
    private String title;

    public FilterClasses() {
        classes = new ArrayList<>();
    }

    public FilterClasses(List<Classes> classes, String title) {
        this.classes = classes;
        this.title = title;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
