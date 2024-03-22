package com.example.lab5;

import static android.system.Os.shutdown;
import static com.example.lab5.Activator2.text;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText text;
boolean chbx1;
boolean chbx2;
CheckBox cb1,cb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.EntryPoint);
        Intent i = getIntent();
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        String s = i.getStringExtra("secondary");
        text.setText(s);
        if (chbx1) cb1.setChecked(true);
        if (chbx2) cb2.setChecked(true);
    }

    public void Dialog_click(View v)
    {
        boolean chb1 = cb1.isChecked();
        boolean chb2 = cb2.isChecked();

        String s = text.getText().toString();
        Intent i = new Intent(MainActivity.this, Activator2.class);
        i.putExtra("main", s);
        i.putExtra("bool1", chb1);
        i.putExtra("bool2", chb2);
        startActivityForResult(i, 555);
    }

    public static boolean murmushka;
    public void Exit_Click(View v)
    {
        AlertDialog.Builder gex = new AlertDialog.Builder(this);
        gex
                .setIcon(R.drawable.myicon)
                .setTitle("Close application")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        murmushka = false;
                    }
                })
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create();
        gex.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent i)
    {
        if (requestCode == 555)
        {
            if (i != null)
            {
                chbx1 = i.getBooleanExtra("boolc1",false);
                chbx2 = i.getBooleanExtra("boolc2",false);
                String s = i.getStringExtra("secondary");

                Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

                text.setText(s);
                cb1.setChecked(chbx1);
                cb2.setChecked(chbx2);
            }
        }
        super.onActivityResult(requestCode,resultCode,i);
    }

}