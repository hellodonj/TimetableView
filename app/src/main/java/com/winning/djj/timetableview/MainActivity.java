package com.winning.djj.timetableview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zhuangfei.timetable.core.OnSubjectItemClickListener;
import com.zhuangfei.timetable.core.SubjectBean;
import com.zhuangfei.timetable.core.TimetableView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnSubjectItemClickListener {

    private TimetableView mTime;
    private List<SubjectBean> subjectBeanList;
    private List<Integer> weekList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTime = findViewById(R.id.time_table);
        for (int i = 0; i < 5; i++) {
            weekList = new ArrayList<>();
            weekList.add(1);
        }

        for (int j = 0; j < 11; j++) {
            subjectBeanList = new ArrayList<SubjectBean>();
            subjectBeanList.add(new SubjectBean("李林森","PT","康复科",weekList,1,1,3,6,"8:00-8:30"));
        }

        mTime.setDataSource(subjectBeanList)
                .setCurTerm("今日排班")//设置学期
                .setOnSubjectItemClickListener(this)
                .showTimetableView();


    }

    @Override
    public void onItemClick(View v, List<SubjectBean> subjectList) {
        Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
    }
}
