package com.example.lab5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Activator2 extends AppCompatActivity {
public static EditText text;
Switch sw1,sw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activator2);
        text = findViewById(R.id.EntryActivator);
        Intent i = getIntent();
        String s = i.getStringExtra("main");
        boolean swb1 = i.getBooleanExtra("bool1",false);
        boolean swb2 = i.getBooleanExtra("bool2",false);
        text.setText(s);
        sw1 = findViewById(R.id.switch1);
        sw2 = findViewById(R.id.switch2);
        if (swb1) sw1.setChecked(true);
        if (swb2) sw2.setChecked(true);
    }

    public void Cancel_button_click(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void OK_button_click(View v){
        Intent i = new Intent(Activator2.this, MainActivity.class);
        String s = text.getText().toString();
        boolean sww1 = sw1.isChecked();
        boolean sww2 = sw2.isChecked();
        i.putExtra("secondary", s);
        i.putExtra("boolc1", sww1);
        i.putExtra("boolc2",sww2);
        setResult(RESULT_OK, i);
        startActivityForResult(i, 555);
    }
}
