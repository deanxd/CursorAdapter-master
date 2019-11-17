package com.example.android.colors.cursoradapter.adapter.holder;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;

import com.example.android.colors.cursoradapter.CountriesDbAdapter;
import com.example.android.colors.cursoradapter.R;

public class TypeOneViewHolder extends BaseViewHolder {

    private TextView continent;
    private TextView region;
    private TextView name;
    private TextView code;

    public TypeOneViewHolder(View vRoot) {
        super(vRoot);
        continent = (TextView) vRoot.findViewById(R.id.continent);
        region = (TextView) vRoot.findViewById(R.id.region);
        name = (TextView) vRoot.findViewById(R.id.name);
        code = (TextView) vRoot.findViewById(R.id.code);
    }

    @Override
    public void bindView(Context context, Cursor cursor) {
        String title = cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_CODE) );
        code.setText(title);
        name.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_NAME) ));
        region.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_CONTINENT) ));
        continent.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_REGION) ));
    }
}
