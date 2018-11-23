package com.stdio.hue.yoga.data.models;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
public class NameEntity extends BaseObservable implements Serializable {
    @SerializedName("en")
    private String nameEn;
    @SerializedName("vi")
    private String nameVi;
    @SerializedName("fr")
    private String nameFr;
    @SerializedName("cn")
    private String nameCn;

    public NameEntity() {
    }

    public NameEntity(String nameEn, String nameVi, String nameFr, String nameCn) {
        this.nameEn = nameEn;
        this.nameVi = nameVi;
        this.nameFr = nameFr;
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }
}
