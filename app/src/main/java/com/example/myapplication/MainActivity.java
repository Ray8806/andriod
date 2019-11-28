package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {
private TextView txtShow;
Thread th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtShow=findViewById(R.id.txtShow);

        th=new Thread(r0);
        th.start();


    }
    private Runnable r0 =new Runnable() {
        @Override
        public void run() {
            try {
                Document doc = Jsoup.connect("https://zh.wikipedia.org/wiki/Wiki").get();

                Elements elements = doc.select("div.mw-content-ltr");
                elements.select("p");
                txtShow.setText(elements.text());

            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    };

}
