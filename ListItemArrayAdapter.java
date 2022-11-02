package com.example.lists;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;

public class ListItemArrayAdapter extends ArrayAdapter<ListItem> {

    Context context;
    int layoutResourceId;
    ListItem data[] = null;

    public ListItemArrayAdapter(@NonNull Context context, int layoutResourceId, ListItem[] data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListItemArrayAdapter{" +
                "context=" + context +
                ", layoutResourceId=" + layoutResourceId +
                ", data=" + Arrays.toString(data) +
                '}';
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ListItemHolder holder = null;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);
            holder = new ListItemHolder();
            holder.imageView = view.findViewById(R.id.imageView);
            holder.textView = view.findViewById(R.id.textView);
            view.setTag(holder);
        } else {
            holder = (ListItemHolder) view.getTag();
        }

        holder.imageView.setImageResource(data[position].imageID);
        holder.textView.setText(data[position].title);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("title", data[position].title);
                intent.putExtra("imageID", data[position].imageID);
                context.startActivity(intent);
            }
        });

        return view;
    }

    static class ListItemHolder{
        ImageView imageView;
        TextView textView;


    }
}
