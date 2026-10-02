package com.example.app_cong_viec;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EditText edtTaskName = findViewById(R.id.edtTaskName);
        EditText edtTaskTime = findViewById(R.id.edtTaskTime);
        EditText edtTaskNote = findViewById(R.id.edtTaskNote);
        RadioButton rbToday = findViewById(R.id.rbToday);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = edtTaskName.getText().toString();
            String time = edtTaskTime.getText().toString();
            String note = edtTaskNote.getText().toString();


            Task newTask = new Task(name, time, note);


            if (rbToday.isChecked()) {
                Task.todayTasks.add(newTask);
            } else {
                Task.upcomingTasks.add(newTask);
            }


            finish();
        });
    }
}