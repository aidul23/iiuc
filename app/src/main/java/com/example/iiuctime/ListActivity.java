package com.example.iiuctime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.iiuctime.ClassNotice.NoticeActivity;
import com.example.iiuctime.ClassRoutine.RoutineActivity;
import com.example.iiuctime.ClassTeacher.TeacherActivity;

public class ListActivity extends AppCompatActivity {
    CardView cardView1,cardView2,cardView3,cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        cardView1 = findViewById(R.id.c1);
        cardView2 = findViewById(R.id.c2);
        cardView3 = findViewById(R.id.c3);
        cardView4 = findViewById(R.id.c4);

        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this,NoticeActivity.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, TeacherActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.silde_out_left);
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, RoutineActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.silde_out_left);
            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.silde_out_right);
    }
}
