package com.example.android.colors.cursoradapter.star;

import android.database.Cursor;
import android.view.View;
import android.widget.TextView;

import com.example.android.colors.cursoradapter.CountriesDbAdapter;
import com.example.android.colors.cursoradapter.R;

public class TypeThreeCityViewHolder extends BaseCityViewHolder {

    private TextView continent;
    private TextView region;
    private TextView name;
    private TextView code;

    public TypeThreeCityViewHolder(View view) {
        super(view);
        continent = (TextView) view.findViewById(R.id.continent);
        region = (TextView) view.findViewById(R.id.region);
        name = (TextView) view.findViewById(R.id.name);
        code = (TextView) view.findViewById(R.id.code);
    }

    @Override
    public void bindView(Cursor cursor) {
        String title = cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_CODE) );
        code.setText(title);
        name.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_NAME) ));
        region.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_CONTINENT) ));
        continent.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_REGION) ));
    }
}
