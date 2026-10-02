package com.example.app_cong_viec;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TaskListActivity extends AppCompatActivity {

    LinearLayout layoutTodayTasks, layoutUpcomingTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Button btnAddAction = findViewById(R.id.btnAddAction);
        layoutTodayTasks = findViewById(R.id.layoutTodayTasks);
        layoutUpcomingTasks = findViewById(R.id.layoutUpcomingTasks);


        btnAddAction.setOnClickListener(v -> {
            Intent intent = new Intent(TaskListActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadTasks();
    }

    private void loadTasks() {
        layoutTodayTasks.removeAllViews();
        layoutUpcomingTasks.removeAllViews();


        for (Task task : Task.todayTasks) {
            CheckBox cb = new CheckBox(this);
            cb.setTextSize(16);
            cb.setPadding(0, 16, 0, 16);


            cb.setButtonDrawable(null);


            String checkedIcon = "✅  ";
            String uncheckedIcon = "○  ";


            cb.setChecked(task.isCompleted);
            cb.setText((task.isCompleted ? checkedIcon : uncheckedIcon) + task.name + " (" + task.time + ")");


            cb.setPaintFlags(cb.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));


            cb.setOnCheckedChangeListener((buttonView, isChecked) -> {
                task.isCompleted = isChecked;


                cb.setText((isChecked ? checkedIcon : uncheckedIcon) + task.name + " (" + task.time + ")");
            });

            layoutTodayTasks.addView(cb);
        }


        for (Task task : Task.upcomingTasks) {
            TextView tv = new TextView(this);
            tv.setText("•  " + task.name + " (" + task.time + ")");
            tv.setTextSize(16);
            tv.setPadding(0, 16, 0, 16);
            layoutUpcomingTasks.addView(tv);
        }
    }
}