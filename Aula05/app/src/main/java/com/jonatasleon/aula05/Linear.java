package com.jonatasleon.aula05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Linear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        Button btnSaudacao = (Button) findViewById(R.id.btn_saudacao);
        btnSaudacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Linear.this, getResources().getString(R.string.message), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
