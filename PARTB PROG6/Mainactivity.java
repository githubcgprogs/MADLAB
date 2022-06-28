package com.example.pgb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button,button2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.marqueeText);
        AsyncClass asyncClass=new AsyncClass();
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncClass.doInBackground();
                asyncClass.onProgressUpdate();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setSelected(false);
                asyncClass.onPostExecute("AsyncTask Completed");
            }
        });
    }

    private class AsyncClass extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Toast.makeText(getApplicationContext(),"Banner is Moving",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... strings) {
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.setSelected(true);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        }
    }
}
