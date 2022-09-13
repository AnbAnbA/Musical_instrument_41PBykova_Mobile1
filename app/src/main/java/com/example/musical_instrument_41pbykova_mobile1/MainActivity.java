package com.example.musical_instrument_41pbykova_mobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {
    Connection connection;
    String ConnectionResult ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GetTextFormSql(View v)
    {

    }


}