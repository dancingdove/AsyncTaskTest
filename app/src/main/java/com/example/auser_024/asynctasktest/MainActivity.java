package com.example.auser_024.asynctasktest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyTask task = new MyTask();
        task.execute(10);
        tv = (TextView)findViewById(R.id.textview1);

    }

    class MyTask extends AsyncTask<Integer,Integer,String> {

        @Override
        protected String doInBackground(Integer... params) {

            int n = params[0];
            for (int i = n; i>=0 ; i--) {
                publishProgress(i);
                try {
                    Thread.sleep(1000);

                    System.out.println(" >>>>>>>>>>>>>>>>>> " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "OK";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText(s);
        }
    }
}
