package com.jonatasleon.aula03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);
        InputStream inputStream = getResources().openRawResource(R.raw.links);
        String rawString = readInputStream(inputStream);
        String assetsString = "";
        try{
            assetsString = readInputStream(getAssets().open("links.json"));
        }catch (IOException e){
            e.printStackTrace();
        }

        ((TextView) findViewById(R.id.textRaw)).setText(rawString);
        ((TextView) findViewById(R.id.textAssets)).setText(assetsString);
    }

    private String readInputStream(InputStream inputStream) {
        StringBuffer sb = new StringBuffer();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        try {
            while((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
