package com.example.diak.dolgozat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {


    private Button button_next, button_info, button_exit, button_change;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        init();
        listeners();

        SharedPreferences sharedPreferences = getSharedPreferences("MyData",Context.MODE_PRIVATE);
        textView.setEnabled(false);
        textView.setText(sharedPreferences.getString("name",null));

    }
    public void init(){

        button_next = (Button) findViewById(R.id.button_next);
        button_change = (Button) findViewById(R.id.button_change);
        button_info = (Button) findViewById(R.id.button_info);
        button_exit = (Button) findViewById(R.id.button_exit);
        textView = (TextView)  findViewById(R.id.textView);
    }

    public void listeners(){


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(gonext);
                finish();
            }
        });

        button_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gosave = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(gosave);
                finish();
            }
        });

        button_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String textView = sharedPreferences.getString("name",null);
                Toast.makeText(Main2Activity.this, "Ez a neved:" + textView, Toast.LENGTH_SHORT).show();
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
