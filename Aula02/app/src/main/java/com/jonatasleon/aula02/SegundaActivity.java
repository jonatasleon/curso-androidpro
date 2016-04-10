package com.jonatasleon.aula02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        final TextView textView = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();

        if (intent != null) {
            String action = intent.getAction();
            String type = intent.getType();

            if (Intent.ACTION_SEND.equals(action) && "text/plain".equals(type)){
                textView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
            } else {
                Bundle bundle = intent.getBundleExtra("stringBundle");
                String umaString = bundle.getString("umaString");
                String mensagem = intent.getStringExtra("mensagem");
                boolean umBoolean = intent.getBooleanExtra("umBoolean", false);
                int umInteiro = intent.getIntExtra("umInteiro", 0);

                textView.setText(getString(R.string.text_segunda) + ": " + umaString + " " + mensagem +
                        " " + umBoolean + " " + umInteiro);

                Button btn = (Button) findViewById(R.id.button2);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SegundaActivity.this, PrimeiraActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
