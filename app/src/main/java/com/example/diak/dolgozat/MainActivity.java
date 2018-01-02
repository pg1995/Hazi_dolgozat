package com.example.diak.dolgozat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText2;
    private Button button_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        listeners();

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        editText2.setText(sharedPreferences.getString("name",null));
    }
    public void init(){

        editText2 = (EditText) findViewById(R.id.editText2);
        button_submit = (Button) findViewById(R.id.button_submit);
    }

    public void listeners() {

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", editText2.getText().toString());
                editor.commit();

                Toast.makeText(MainActivity.this, "Adat mentve", Toast.LENGTH_SHORT).show();

                Intent vissza_menube = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(vissza_menube);
                finish();

            }
        });
    }
}