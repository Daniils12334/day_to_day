package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    private TextView[] taskTextViews = new TextView[5];
    private int taskCounter = 0; // Начнем с 0 для отслеживания свободного TextView
    private static final int MAX_TASKS = 5;
    private static final int REQUEST_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        taskTextViews[0] = findViewById(R.id.taskTextView1);
        taskTextViews[1] = findViewById(R.id.taskTextView2);
        taskTextViews[2] = findViewById(R.id.taskTextView3);
        taskTextViews[3] = findViewById(R.id.taskTextView4);
        taskTextViews[4] = findViewById(R.id.taskTextView5);


        findViewById(R.id.AddTaskButton).setOnClickListener(v -> {
            if (taskCounter < MAX_TASKS) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, REQUEST_CODE);
            } else {
                Toast.makeText(this, "Maximum of 5 tasks reached", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String taskName = data.getStringExtra("task_name");
            String taskDate = data.getStringExtra("task_date");
            String taskTime = data.getStringExtra("task_time");

            if (taskName != null && taskDate != null && taskTime != null && taskCounter < MAX_TASKS) {
                String taskText = (taskCounter + 1) + ". " + taskName + " - Date: " + taskDate + " - Time: " + taskTime;
                taskTextViews[taskCounter].setText(taskText);
                taskCounter++;
            }
        }
    }

///Transfer to MainActivity2 START

///Transfer to MainActivity2 END

    }
