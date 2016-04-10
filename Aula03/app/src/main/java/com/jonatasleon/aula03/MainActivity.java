package com.jonatasleon.aula03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.startAnimation(fadein);

        final TextView tv = (TextView) findViewById(R.id.textView);

        final Animation fadeout = new AlphaAnimation(1f, 0);
        fadeout.setDuration(2500);
        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv.startAnimation(fadeout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tv.startAnimation(fadeout);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LinksActivity.class);
                startActivity(i);
            }
        });
    }
}
