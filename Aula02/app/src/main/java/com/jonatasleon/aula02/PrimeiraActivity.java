package com.jonatasleon.aula02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrimeiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);

        ((Button) findViewById(R.id.button_segunda)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrimeiraActivity.this, SegundaActivity.class);
                Bundle b = new Bundle();
                b.putString("umaString", "Olá");
                intent.putExtra("stringBundle", b);
                intent.putExtra("mensagem", "Mundo!");
                intent.putExtra("umBoolean", true);
                intent.putExtra("umInteiro", 5);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.button_terceira)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimeiraActivity.this, TerceiraActivity.class);
                startActivityForResult(i, 0);
            }
        });

        ((Button) findViewById(R.id.button_site)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webSite = Uri.parse("http://jonatasleon.com");
                Intent i = new Intent(Intent.ACTION_VIEW, webSite);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0 && resultCode == Activity.RESULT_OK) {
            String dados = data.getStringExtra("dados");
            Toast.makeText(PrimeiraActivity.this, "Dados: " + dados, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
