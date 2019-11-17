package com.example.android.colors.cursoradapter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import static android.widget.LinearLayout.HORIZONTAL;

public class MainActivity extends AppCompatActivity {


    private CountriesDbAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new CountriesDbAdapter(this);
        dbHelper.open();

        //Clean all data
        dbHelper.deleteAllCountries();
        //Add some data
        dbHelper.insertSomeCountries();

        //Generate ListView from SQLite Database
        displayListView();

    }

    private void displayListView() {
        Cursor cursor = dbHelper.fetchAllCountries();
//        MyCursorAdapter customAdapter = new MyCursorAdapter(MainActivity.this,
//                cursor, 0);

        StarCursorAdapter adapter = new StarCursorAdapter(this, cursor);
        RecyclerView listView = (RecyclerView) findViewById(R.id.listView1);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.addItemDecoration(new DividerItemDecoration(this, HORIZONTAL));
        listView.setAdapter(adapter);
    }
}
