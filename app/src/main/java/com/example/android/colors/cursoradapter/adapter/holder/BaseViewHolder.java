package com.example.android.colors.cursoradapter.adapter.holder;

import android.content.Context;
import android.database.Cursor;
import android.view.View;

public abstract class BaseViewHolder {

    private View vRoot;

    public BaseViewHolder(View vRoot){
        this.vRoot = vRoot;
    }

    public abstract void bindView(Context context, Cursor cursor);
}
