package com.example.android.colors.cursoradapter.adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.colors.cursoradapter.CountriesDbAdapter;
import com.example.android.colors.cursoradapter.R;
import com.example.android.colors.cursoradapter.adapter.holder.BaseViewHolder;
import com.example.android.colors.cursoradapter.adapter.holder.TypeOneViewHolder;
import com.example.android.colors.cursoradapter.adapter.holder.TypeThreeViewHolder;
import com.example.android.colors.cursoradapter.adapter.holder.TypeTwoViewHolder;
import com.example.android.colors.cursoradapter.adapter.holder.TypeUnknowViewHolder;

public class CursorAdapter extends android.widget.CursorAdapter {

    private final static String TAG = CursorAdapter.class.getSimpleName();
    private LayoutInflater mLayoutInflater;

    public CursorAdapter(Context context, Cursor c) {
        super(context, c, false);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        int type = getItemType(cursor);
        Log.d(TAG, "onCreateDefViewHolder, type=" + type);

        switch (type) {
            case 1:{
                View rootView = mLayoutInflater.inflate(R.layout.country_info_one, null);
                BaseViewHolder holder = new TypeOneViewHolder(rootView);
                rootView.setTag(holder);
                return rootView;
            }
            case 2:{
                View rootView = mLayoutInflater.inflate(R.layout.country_info_two, null);
                BaseViewHolder holder = new TypeTwoViewHolder(rootView);
                rootView.setTag(holder);
                return rootView;
            }
            case 3:{
                View rootView = mLayoutInflater.inflate(R.layout.country_info_three, null);
                BaseViewHolder holder = new TypeThreeViewHolder(rootView);
                rootView.setTag(holder);
                return rootView;
            }
            default:{
                View rootView = mLayoutInflater.inflate(R.layout.country_info_unkonw, null);
                BaseViewHolder holder = new TypeUnknowViewHolder(rootView);
                rootView.setTag(holder);
                return rootView;
            }
        }
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        BaseViewHolder holder = (BaseViewHolder) view.getTag();
        holder.bindView(context, cursor);
    }

    @Override
    public int getItemViewType(int position) {
        Cursor cursor = getCursor();
        boolean b = cursor.moveToPosition(position);
        int type = getItemType(cursor);
        Log.d(TAG, "getDefItemViewType,position=" + position + " , type=" + type);
        return type;
    }

    private int getItemType(Cursor cursor){
        int columnIndex = cursor.getColumnIndex(CountriesDbAdapter.KEY_TYPE);
        String type = cursor.getString(columnIndex);
        return Integer.valueOf(type);
    }
}
