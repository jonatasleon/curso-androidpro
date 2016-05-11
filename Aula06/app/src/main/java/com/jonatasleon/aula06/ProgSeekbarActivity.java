package com.jonatasleon.aula06;

import android.media.tv.TvContract;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import junit.framework.Test;

public class ProgSeekbarActivity extends AppCompatActivity {

    private ProgressBar progressBarHor;
    private ProgressBar progressBarInf;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog_seekbar);
        progressBarHor = (ProgressBar) findViewById(R.id.progressBar2);
        progressBarInf = (ProgressBar) findViewById(R.id.progressBar);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(100);
        TesteProgressTask task = new TesteProgressTask();
        task.execute();
    }

    private class TesteProgressTask extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBarInf.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(Void... params) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    return -1;
                }
            }

            return 100;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            int progressValue = progress[0];
            progressBarHor.setProgress(progressValue);
            seekBar.setProgress(progressValue);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            progressBarInf.setVisibility(View.GONE);
            progressBarHor.setProgress(0);
            seekBar.setProgress(0);
        }

    }
}

