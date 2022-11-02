package com.example.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ListItem array[] = {new ListItem(R.drawable.black_cookie, "Dark chocolate cookie"), new ListItem(R.drawable.white_cookie, "Chocolate cookie")};

        ListItemArrayAdapter adapter = new ListItemArrayAdapter(this, R.layout.list_item, array);
        listView.setAdapter(adapter);

    }
}