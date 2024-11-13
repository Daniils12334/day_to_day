    package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Get references to the EditTexts and Button
        EditText taskNameEditText = findViewById(R.id.taskNameEditText);
        EditText taskDateEditText = findViewById(R.id.taskDateEditText);
        EditText taskTimeEditText = findViewById(R.id.taskTimeEditText);
        Button saveTaskButton = findViewById(R.id.saveTaskButton);
        Button stopCreateTask = findViewById(R.id.StopCreateTask);

        saveTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = taskNameEditText.getText().toString();
                String taskDate = taskDateEditText.getText().toString();
                String taskTime = taskTimeEditText.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("task_name", taskName);
                resultIntent.putExtra("task_date", taskDate);
                resultIntent.putExtra("task_time", taskTime);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        stopCreateTask.setOnClickListener(v -> finish());
    }
///StopCreateTask START
        // Set an OnClickListener for the button

///StopCreateTask END


    }
