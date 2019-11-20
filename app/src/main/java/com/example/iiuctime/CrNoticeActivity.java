package com.example.iiuctime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class CrNoticeActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr_notice);

        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
        datePicker = findViewById(R.id.datePickerId);

        getSupportActionBar().setTitle("Notice");

        textView.setText(currentdate());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(currentdate());
            }
        });


    }

    String currentdate() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Date: ");
        stringBuilder.append(datePicker.getDayOfMonth()+"/");
        stringBuilder.append((datePicker.getMonth()+1)+"/");
        stringBuilder.append(datePicker.getYear());

        return stringBuilder.toString();
    }
}
