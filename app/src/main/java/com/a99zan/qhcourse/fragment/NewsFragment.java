package com.a99zan.qhcourse.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a99zan.qhcourse.R;
import com.a99zan.qhcourse.adapter.NewsAdapter;
import com.a99zan.qhcourse.bean.NewsBean;
import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 99zan on 2018/4/18.
 */

public class NewsFragment extends Fragment {

    @BindView(R.id.news_list)
    ListView listNews;
    private List<NewsBean> data = new ArrayList<>();
    private NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);
        ButterKnife.bind(this, view);
        loadData();
        return view;
    }

    private void loadData() {

        String url = "common/news_list";
        ViseHttp.POST(url).request(new ACallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("111", result);
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(result, NewsBean.class);
                data.add(newsBean);
                adapter = new NewsAdapter(getContext(), data);
                listNews.setAdapter(adapter);
            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });

    }

}
