package com.jonatasleon.aula06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFormulario = (Button) findViewById(R.id.btn_formulario);
        btnFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FormularioActivity.class);
                startActivityForResult(i, 0);
            }
        });

        Button btnAdapter = (Button) findViewById(R.id.btn_adapter);
        btnAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AdapterActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "DEU CERTO FEI!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "DEU ERRADO FEI!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
