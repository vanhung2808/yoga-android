package com.stdio.hue.yoga.data.models.base;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.BR;
import com.stdio.hue.yoga.data.models.NameEntity;

import java.io.Serializable;

/**
 * Created by TranHuuPhuc on 10/24/18.
 */
public class BaseFilter extends BaseObservable implements Serializable, Parcelable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @Ignore
    private boolean checked;
    @ColumnInfo(name = "created_at")
    private String createdAt;
    @ColumnInfo(name = "updated_at")
    private String updatedAt;

    public BaseFilter() {
    }

    public BaseFilter(int id, String name, boolean checked) {
        this.id = id;
        this.name = name;
        this.checked = checked;
    }

    protected BaseFilter(Parcel in) {
        id = in.readInt();
        name = in.readString();
        checked = in.readByte() != 0;
        createdAt = in.readString();
        updatedAt = in.readString();
    }

    public static final Creator<BaseFilter> CREATOR = new Creator<BaseFilter>() {
        @Override
        public BaseFilter createFromParcel(Parcel in) {
            return new BaseFilter(in);
        }

        @Override
        public BaseFilter[] newArray(int size) {
            return new BaseFilter[size];
        }
    };

    @Bindable
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        notifyPropertyChanged(BR.createdAt);
    }

    @Bindable
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        notifyPropertyChanged(BR.updatedAt);
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        notifyPropertyChanged(BR.checked);
    }

    public NameEntity getNameEntity(Gson gson) {
        return gson.fromJson(name, NameEntity.class);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeByte((byte) (checked ? 1 : 0));
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
    }
}

