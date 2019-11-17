package com.example.android.colors.cursoradapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.colors.cursoradapter.base.BaseCursorAdapter;
import com.example.android.colors.cursoradapter.base.BaseViewHolder;
import com.example.android.colors.cursoradapter.star.BaseCityViewHolder;
import com.example.android.colors.cursoradapter.star.TypeOneCityViewHolder;
import com.example.android.colors.cursoradapter.star.TypeThreeCityViewHolder;
import com.example.android.colors.cursoradapter.star.TypeTwoCityViewHolder;
import com.example.android.colors.cursoradapter.star.TypeUnknowViewHolder;

public class StarCursorAdapter extends BaseCursorAdapter<BaseCityViewHolder> {

    private final static String TAG = StarCursorAdapter.class.getSimpleName();

    private LayoutInflater cursorInflater;

    public StarCursorAdapter(Context context, Cursor c) {
        super(context, c);
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    protected void convert(BaseCityViewHolder holder, Cursor cursor) {
        holder.bindView(cursor);
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateDefViewHolder, type=" + viewType);

        switch (viewType) {
            case 1:
                return new TypeOneCityViewHolder(cursorInflater.inflate(R.layout.country_info_one, null));
            case 2:
                return new TypeTwoCityViewHolder(cursorInflater.inflate(R.layout.country_info_two, null));
            case 3:
                return new TypeThreeCityViewHolder(cursorInflater.inflate(R.layout.country_info_three, null));
            default:
                return new TypeUnknowViewHolder(cursorInflater.inflate(R.layout.country_info_unkonw, null));
        }
    }

    @Override
    protected int getDefItemViewType(int position) {
        Cursor cursor = getCursor();
        boolean b = cursor.moveToPosition(position);
        int columnIndex = cursor.getColumnIndex(CountriesDbAdapter.KEY_TYPE);
        String type = cursor.getString(columnIndex);

        Log.d(TAG, "getDefItemViewType,position=" + position + " , type=" + type);
        return Integer.valueOf(type);
    }
}
