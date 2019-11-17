package com.example.android.colors.cursoradapter.star;

import android.database.Cursor;
import android.view.View;

import com.example.android.colors.cursoradapter.base.BaseViewHolder;

public abstract class BaseCityViewHolder extends BaseViewHolder {

    public BaseCityViewHolder(View view) {
        super(view);
    }

    public abstract void bindView(Cursor cursor);
}
