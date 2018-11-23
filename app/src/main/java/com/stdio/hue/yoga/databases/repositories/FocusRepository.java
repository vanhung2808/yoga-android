package com.stdio.hue.yoga.databases.repositories;

import com.stdio.hue.yoga.data.models.Focus;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface FocusRepository {
    void insertFocus(List<Focus> focus);
}
