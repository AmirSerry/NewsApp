package com.amirserry.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> newsList = new ArrayList<News>();

    public NewsAdapter(@NonNull Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public int getCount() {
        return this.newsList.size();
    }

    @Override
    public News getItem(int index) {
        return this.newsList.get(index);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        NewsViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.news_item, parent, false);
            viewHolder = new NewsViewHolder();
            viewHolder.title = (TextView) row.findViewById(R.id.title);
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.auther = (TextView) row.findViewById(R.id.auther);
            viewHolder.date = (TextView) row.findViewById(R.id.date);
            row.setTag(viewHolder);
        } else {
            viewHolder = (NewsViewHolder) row.getTag();
        }
        final News news = getItem(position);
        viewHolder.title.setText(news.getTitle());
        viewHolder.name.setText(news.getName());
        viewHolder.auther.setText(news.getAutherName());
        viewHolder.date.setText(news.getDatePublished());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.getWebURL()));
                v.getContext().startActivity(browserIntent);


            }
        });
        return row;
    }

    public void add(News news) {
        newsList.add(news);
        super.add(news);
    }

    static class NewsViewHolder {
        TextView title;
        TextView name;
        TextView auther;
        TextView date;

    }
}
