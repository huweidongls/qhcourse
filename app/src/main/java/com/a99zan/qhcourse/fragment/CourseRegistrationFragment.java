package com.a99zan.qhcourse.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a99zan.qhcourse.R;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 99zan on 2018/4/18.
 */

public class CourseRegistrationFragment extends Fragment {

    @BindView(R.id.calendarView)
    CalendarView calendarView;
    @BindView(R.id.fragment_regist_day)
    TextView tvDay;
    @BindView(R.id.fragment_regist_month)
    TextView tvMonth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courseregistration, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {

        Calendar calendar = new Calendar();
        calendar.setYear(2018);
        calendar.setMonth(4);
        calendar.setDay(25);
        calendar.setScheme("43");

        List<Calendar> cList = new ArrayList<>();
        cList.add(calendar);
        calendarView.setSchemeDate(cList);

        tvDay.setText(calendarView.getCurDay()+"日");
        tvMonth.setText(calendarView.getCurMonth()+"月"+calendarView.getCurYear()+"年");
        calendarView.setOnDateSelectedListener(new CalendarView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Calendar calendar, boolean isClick) {
                tvDay.setText(calendar.getDay()+"日");
                tvMonth.setText(calendar.getMonth()+"月"+calendar.getYear()+"年");
            }
        });

    }
}
