package com.a99zan.qhcourse.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.a99zan.qhcourse.R;
import com.a99zan.qhcourse.bean.LoginBean;
import com.a99zan.qhcourse.utils.Consts;
import com.a99zan.qhcourse.utils.L;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_mobile)
    MaterialEditText etMobile;
    @BindView(R.id.login_password)
    MaterialEditText etPwd;
    @BindView(R.id.login_ok)
    Button btnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
    }

    @OnClick({R.id.login_ok})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_ok:
                if(TextUtils.isEmpty(etMobile.getText().toString())){
                    showToast("手机号不能为空");
                }else if(TextUtils.isEmpty(etPwd.getText().toString())){
                    showToast("密码不能为空");
                }else{
                    login();
                }
                break;
        }
    }

    private void login() {
        String url = "common/login";
        String mobile = etMobile.getText().toString();
        String pwd = etPwd.getText().toString();
        ViseHttp.POST(url)
                .addParam("tel", mobile)
                .addParam("password", pwd)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        Log.e("111", data);
                        saveMsg(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {

                    }
                });
    }

    private void saveMsg(String data) {
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(data, LoginBean.class);
        if(loginBean.getCode().equals("200")){
            SharedPreferences.Editor editor = getSharedPreferences(Consts.FILENAME, MODE_PRIVATE).edit();
            editor.putString("user_id", L.encrypt(loginBean.getData().getUser_id(), Consts.LKEY));
            editor.putString("user_name", L.encrypt(loginBean.getData().getUser_name(), Consts.LKEY));
            editor.putString("user_autograph", L.encrypt(loginBean.getData().getUser_autograph(), Consts.LKEY));
            editor.putString("user_head", L.encrypt(loginBean.getData().getUser_head(), Consts.LKEY));
            editor.putString("user_token", L.encrypt(loginBean.getData().getUser_token(), Consts.LKEY));
            editor.commit();
            LoginActivity.this.finish();
        }else {
            showToast(loginBean.getMsg());
        }
    }
}
