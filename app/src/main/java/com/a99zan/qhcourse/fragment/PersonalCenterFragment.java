package com.a99zan.qhcourse.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a99zan.qhcourse.R;
import com.a99zan.qhcourse.utils.Consts;
import com.a99zan.qhcourse.utils.L;
import com.a99zan.qhcourse.utils.MD5;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 99zan on 2018/4/18.
 */

public class PersonalCenterFragment extends Fragment {

    @BindView(R.id.fragment_personset_img_header)
    ImageView ivHeader;
    @BindView(R.id.fragment_personset_user_nickname)
    TextView tvNickname;
    @BindView(R.id.fragment_personset_user_autograph)
    TextView tvAutograph;

    private String token;
    private String userId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personalcenter, null);
        ButterKnife.bind(this, view);

        init();

        return view;
    }

    private void init() {
        SharedPreferences pref = getContext().getSharedPreferences(Consts.FILENAME, getContext().MODE_PRIVATE);
        userId = L.decrypt(pref.getString("user_id", ""), Consts.LKEY);
        token = L.decrypt(pref.getString("user_token", ""), Consts.LKEY);
        String url = "user/personal_information";
        String sign = MD5.getMD5(Consts.BASE_URL + url + token);
        ViseHttp.POST(url)
                .addParam("user_id", userId)
                .addParam("sign", sign)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        Log.e("111", data+"person");
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {

                    }
                });
    }
}
