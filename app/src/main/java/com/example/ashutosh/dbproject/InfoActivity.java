package com.example.ashutosh.dbproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import static com.example.ashutosh.dbproject.MainActivity.firstQueryResult;
import static com.example.ashutosh.dbproject.MainActivity.fourthQueryResult;
import static com.example.ashutosh.dbproject.MainActivity.secondQueryResult;
import static com.example.ashutosh.dbproject.MainActivity.thirdQueryResult;

public class InfoActivity extends AppCompatActivity {

    TextView questionTV;
    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        questionTV = findViewById(R.id.que_tv);
        rv = findViewById(R.id.rv);

        int pos = getIntent().getIntExtra("pos",0);

        questionTV.setText(getIntent().getStringExtra("question"));
        if(pos==2)
        {
            EventAdapter adapter = new EventAdapter(InfoActivity.this,secondQueryResult);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(InfoActivity.this));
            rv.setFocusable(false);
        }
        else if(pos==4)
        {
            FourthAdapter adapter = new FourthAdapter(InfoActivity.this,fourthQueryResult);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(InfoActivity.this));
            rv.setFocusable(false);
        }
        else if(pos==1)
        {
            SingleAdapter adapter = new SingleAdapter(InfoActivity.this,firstQueryResult);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(InfoActivity.this));
            rv.setFocusable(false);
        }
        else if(pos==3)
        {
            SingleAdapter adapter = new SingleAdapter(InfoActivity.this,thirdQueryResult);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(InfoActivity.this));
            rv.setFocusable(false);
        }

    }
}
