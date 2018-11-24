package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Focus;
import com.stdio.hue.yoga.databases.daos.FocusDao;
import com.stdio.hue.yoga.databases.repositories.FocusRepository;

import java.util.List;

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
        for (Focus focusChild : focus) {
            focusDao.insertFocus(focusChild);
        }
    }

    @Override
    public List<Focus> getAllFocus() {
        return focusDao.getAll();
    }
}
