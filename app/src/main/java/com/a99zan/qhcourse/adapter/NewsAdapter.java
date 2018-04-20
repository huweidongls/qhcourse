package com.a99zan.qhcourse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a99zan.qhcourse.R;
import com.a99zan.qhcourse.bean.NewsBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 99zan on 2018/4/18.
 */

public class NewsAdapter extends BaseAdapter {

    private Context context;
    private List<NewsBean> data = new ArrayList<>();
    private LayoutInflater inflater;

    public NewsAdapter(Context context, List<NewsBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.get(0).getData().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_news, null);
            holder.imageView = convertView.findViewById(R.id.list_news_img);
            holder.textView = convertView.findViewById(R.id.list_news_text);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(data.get(0).getData().get(position).getNews_show_img()).into(holder.imageView);
        holder.textView.setText(data.get(0).getData().get(position).getNews_title());

        return convertView;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
