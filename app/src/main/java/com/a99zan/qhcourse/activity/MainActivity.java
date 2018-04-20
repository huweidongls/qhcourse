package com.a99zan.qhcourse.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.a99zan.qhcourse.R;
import com.a99zan.qhcourse.app.MyApp;
import com.a99zan.qhcourse.fragment.CourseRegistrationFragment;
import com.a99zan.qhcourse.fragment.FriendsFragment;
import com.a99zan.qhcourse.fragment.NewsFragment;
import com.a99zan.qhcourse.fragment.PersonalCenterFragment;
import com.a99zan.qhcourse.utils.Consts;
import com.a99zan.qhcourse.utils.L;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    /**
     * 底部菜单第一个按钮
     */
    @BindView(R.id.news)
    RadioButton btnNews;
    /**
     * 底部菜单第二个按钮
     */
    @BindView(R.id.CourseRegistration)
    RadioButton btnCourseRegistration;
    /**
     * 底部菜单第三个按钮
     */
    @BindView(R.id.friends)
    RadioButton btnFriends;
    /**
     * 底部菜单第四个按钮
     */
    @BindView(R.id.PersonalCenter)
    RadioButton btnPersonalCenter;

    private String userId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tupianshipei();
        initFragment();
        initEvent();
    }

    /**
     * 加载fragment
     */
    private void initFragment() {

        Fragment newsFragment = new NewsFragment();
        Fragment courseRegistrationFragment = new CourseRegistrationFragment();
        Fragment friendsFragment = new FriendsFragment();
        Fragment personalCenterFragment = new PersonalCenterFragment();

        fragmentList.add(newsFragment);
        fragmentList.add(courseRegistrationFragment);
        fragmentList.add(friendsFragment);
        fragmentList.add(personalCenterFragment);

        fragmentTransaction.add(R.id.fl_container,newsFragment);
        fragmentTransaction.add(R.id.fl_container,courseRegistrationFragment);
        fragmentTransaction.add(R.id.fl_container,friendsFragment);
        fragmentTransaction.add(R.id.fl_container,personalCenterFragment);

        fragmentTransaction.show(newsFragment).hide(courseRegistrationFragment).hide(friendsFragment).hide(personalCenterFragment);
        fragmentTransaction.commit();
        selectButton(btnNews);

    }

    /**
     * 适配底部菜单图片
     */
    private void tupianshipei() {

        //控制登录用户名图标大小
        Drawable drawable1 = getResources().getDrawable(R.drawable.news_selector);
        drawable1.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        btnNews.setCompoundDrawables(null, drawable1, null, null);//只放左边

        Drawable drawable2 = getResources().getDrawable(R.drawable.regist_selector);
        drawable2.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        btnCourseRegistration
                .setCompoundDrawables(null, drawable2, null, null);//只放左边

        Drawable drawable3 = getResources().getDrawable(R.drawable.friends_selector);
        drawable3.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        btnFriends.setCompoundDrawables(null, drawable3, null, null);//只放左边

        Drawable drawable4 = getResources().getDrawable(R.drawable.person_selector);
        drawable4.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        btnPersonalCenter.setCompoundDrawables(null, drawable4, null, null);//只放左边

    }

    // 注册点击事件
    private void initEvent() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgMenus);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Intent intent = new Intent();
                switch (checkedId) {
                    case R.id.news:
                        selectButton(btnNews);
                        switchFragment(0);
                        break;
                    case R.id.CourseRegistration:
                        selectButton(btnCourseRegistration);
                        switchFragment(1);
                        break;
                    case R.id.friends:
                        if(isLogin()){
                            selectButton(btnFriends);
                            switchFragment(2);
                        }else{
                            intent.setClass(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.PersonalCenter:
                        if(isLogin()){
                            selectButton(btnPersonalCenter);
                            switchFragment(3);
                        }else{
                            intent.setClass(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });
    }

    /**
     * 判断是否登录
     * @return
     */
    public boolean isLogin(){
        SharedPreferences pref = getSharedPreferences(Consts.FILENAME,MODE_PRIVATE);
        userId= L.decrypt(pref.getString("user_id", ""), Consts.LKEY);
        Log.e("111", userId);
        if (TextUtils.isEmpty(userId)){
            return false;
        }
        return true;
    }

    /**
     * 控制底部菜单按钮的选中
     * @param v
     */
    public void selectButton(View v) {
        btnNews.setSelected(false);
        btnCourseRegistration.setSelected(false);
        btnFriends.setSelected(false);
        btnPersonalCenter.setSelected(false);
        v.setSelected(true);
    }

    /**
     * 选择隐藏与显示的Fragment
     * @param index 显示的Frgament的角标
     */
    private void switchFragment(int index){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        for(int i = 0; i < fragmentList.size(); i++){
            if (index == i){
                fragmentTransaction.show(fragmentList.get(index));
            }else {
                fragmentTransaction.hide(fragmentList.get(i));
            }
        }
        fragmentTransaction.commit();
    }

    /**
     * 菜单、返回键响应
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(this);      //调用双击退出函数
        }
        return false;  //不会执行退出事件
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    public static void exitBy2Click(Activity activity) {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(activity, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            MyApp.getInstance().exit();
        }
    }

}
