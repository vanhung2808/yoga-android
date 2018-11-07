package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.FocusDao;
import com.stdio.hue.yoga.data.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.data.models.Focus;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class FocusRepositoryImpl implements FocusRepository {
    private FocusDao focusDao;

    public FocusRepositoryImpl(FocusDao focusDao) {
        this.focusDao = focusDao;
    }

    @Override
    public void insertFocus(List<Focus> focus) {
        Completable.fromAction(() -> focusDao.insertAll(focus));

    }
}
