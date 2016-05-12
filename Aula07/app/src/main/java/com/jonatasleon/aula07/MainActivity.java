package com.jonatasleon.aula07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        switch (item.getItemId()){
            case R.id.action_settings:
                toast.setText("Action Settings");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        toast.show();
        return true;
    }
}
