package com.example.app_cong_viec;

import java.util.ArrayList;
import java.util.List;

public class Task {
    public String name;
    public String time;
    public String note;
    public boolean isCompleted;

    public Task(String name, String time, String note) {
        this.name = name;
        this.time = time;
        this.note = note;
        this.isCompleted = false;
    }

    public static List<Task> todayTasks = new ArrayList<>();
    public static List<Task> upcomingTasks = new ArrayList<>();
}