package com.introtoandroid.csci490_lab05;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        save = findViewById(R.id.button);

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        editText1.setText(sharedPreferences.getString("Name", ""));
        editText2.setText(sharedPreferences.getString("Pass", ""));
        editText3.setText(sharedPreferences.getString("Email", ""));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String pass = editText2.getText().toString();
                String email = editText3.getText().toString();

                editor.putString("Name", name);
                editor.putString("Pass", pass);
                editor.putString("Email", email);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Entered", Toast.LENGTH_SHORT).show();

            }
        });




    }
}
