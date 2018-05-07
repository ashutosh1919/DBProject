package com.example.ashutosh.dbproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    public static List<String> firstQueryResult;
    public static List<Event> secondQueryResult;
    public static List<String> thirdQueryResult;
    public static List<FourthResult> fourthQueryResult;

    TextView firstTV,secondTV,thirdTV,fourthTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTV = findViewById(R.id.first_query_tv);
        secondTV = findViewById(R.id.second_query_tv);
        thirdTV = findViewById(R.id.third_query_tv);
        fourthTV = findViewById(R.id.fourth_query_tv);

        DBHelper database = new DBHelper(MainActivity.this);

        if(!isInserted())
        {
            database.insertUsers();
            database.insertStudents();
            database.insertEvents();
            database.insertPlaySports();
            database.insertDepartments();
            database.insertCulturals();
            database.insertAcademics();
            setInsertedInfo();
        }

        firstQueryResult = database.selectFirstQuery();
        secondQueryResult = database.selectSecondQuery();
        thirdQueryResult = database.selectThirdQuery();
        fourthQueryResult = database.selectFourthQuery();

        secondTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,InfoActivity.class);
                i.putExtra("pos",2);
                i.putExtra("question","Display the details of the events that are conducted in odd semesters.");
                startActivity(i);
            }
        });

        fourthTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,InfoActivity.class);
                i.putExtra("pos",4);
                i.putExtra("question","Display the roll no and full name of the students who have participated at least in one academic,cultural and sports event.");
                startActivity(i);
            }
        });

        firstTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,InfoActivity.class);
                i.putExtra("pos",1);
                i.putExtra("question","Display the first name of the students who have won medals in sports.");
                startActivity(i);
            }
        });

        thirdTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,InfoActivity.class);
                i.putExtra("pos",3);
                i.putExtra("question","Display the organizers that have organized only cultural events.");
                startActivity(i);
            }
        });

    }

    public boolean isInserted()
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String userDetailString = preferences.getString("insertinfo", "");
        if (!userDetailString.isEmpty() && userDetailString.equals("1")) {
            return true;
        } else {
            //return  new UserDetail(null);
            return false;
        }
    }

    public void setInsertedInfo()
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("insertinfo","1");
        editor.commit();
    }

}
