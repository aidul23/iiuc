package com.example.iiuctime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrListActivity extends AppCompatActivity {

    CardView cardView1,cardView2,cardView3,cardView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr_list);

        cardView1 = findViewById(R.id.c1);
        cardView2 = findViewById(R.id.c2);
        cardView3 = findViewById(R.id.c3);
        cardView4 = findViewById(R.id.c4);

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrListActivity.this, CrNoticeActivity.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrListActivity.this,CrTeachersActivity.class);
                startActivity(intent);
            }
        });
    }
}
