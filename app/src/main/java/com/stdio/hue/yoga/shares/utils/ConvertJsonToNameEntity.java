package com.stdio.hue.yoga.shares.utils;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.models.NameEntity;

/**
 * Created by TranHuuPhuc on 12/5/18.
 */
public class ConvertJsonToNameEntity {
    public static NameEntity getNameEntity(Gson gson, String json) {
        return gson.fromJson(json, NameEntity.class);
    }
}
