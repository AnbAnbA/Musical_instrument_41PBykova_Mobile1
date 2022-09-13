package com.example.musical_instrument_41pbykova_mobile1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
        TableLayout MI = findViewById(R.id.tbMI);
        try {
            ConnectionHelper connectionHelper=new ConnectionHelper();
            connection=connectionHelper.connectionClass();
             MI.removeAllViews();
            TableRow trMI = new TableRow(MainActivity.this);
            TextView NameMI = new TextView(MainActivity.this);
            TextView ManufacturersMI = new TextView(MainActivity.this);
            TextView ManufacturerCountryMI = new TextView(MainActivity.this);
            TextView PriceMI = new TextView(MainActivity.this);
            NameMI.setText("Название музыкального инструмента");
            ManufacturersMI.setText("Производитель музыкального инструмента");
            ManufacturerCountryMI.setText("страна производителя");
            PriceMI.setText("Стоимость");
            trMI.addView(NameMI, new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));
            trMI.addView(ManufacturersMI, new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));
            trMI.addView(ManufacturerCountryMI, new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));
            trMI.addView(PriceMI, new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));
            MI.addView(trMI);

            if(connection!=null) {
                String query = "Select * From Musical_Instrument";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                 /*   TableRow tr = new TableRow(MainActivity.this);
                    TextView Name = new TextView(MainActivity.this);
                    TextView Manufacturers = new TextView(MainActivity.this);
                    TextView ManufacturerCountry = new TextView(MainActivity.this);
                    TextView Price = new TextView(MainActivity.this);*/

                    NameMI.setText(resultSet.getString(2));
                    ManufacturersMI.setText(resultSet.getString(3));
                    ManufacturerCountryMI.setText(resultSet.getString(4));
                    PriceMI.setText(resultSet.getString(5));
                }
            }
                else{
                    ConnectionResult="Check Connection";
                }
            }
            catch(Exception ex){
                Log.e(ConnectionResult, ex.getMessage());
            }
        }

    }


