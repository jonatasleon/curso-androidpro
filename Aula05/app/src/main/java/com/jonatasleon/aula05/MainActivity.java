package com.jonatasleon.aula05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_linear).setOnClickListener(this);
        findViewById(R.id.btn_relative).setOnClickListener(this);
        findViewById(R.id.btn_frame).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Class destClass;

        if(v.getId() == R.id.btn_linear) {
            destClass = Linear.class;
        } else if (v.getId() == R.id.btn_relative) {
            destClass = Relative.class;
        } else if (v.getId() == R.id.btn_frame) {
            destClass = Frame.class;
        } else {
            return;
        }

        Intent i = new Intent(MainActivity.this, destClass);
        startActivity(i);
    }
}
