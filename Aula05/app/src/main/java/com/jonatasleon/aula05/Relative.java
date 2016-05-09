package com.jonatasleon.aula05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Relative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        Button btnCenter = (Button) findViewById(R.id.btn_center);
        btnCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Relative.this, getString(R.string.message), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
