package com.example.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.textView2);
        ImageView imageView = findViewById(R.id.imageView2);

        Intent intent = getIntent();

        textView.setText(intent.getStringExtra("title"));
        imageView.setImageResource(intent.getIntExtra("imageID", 0));

    }
}