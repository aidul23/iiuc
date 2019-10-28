package com.example.iiuctime.ClassNotice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiuctime.R;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        ArrayList<ExampleNotice> noticelist = new ArrayList<>();
        noticelist.add(new ExampleNotice("Date:01/02/03","Dear students all classes of Wed is suspended!"));
        noticelist.add(new ExampleNotice("Date:04/01/15","Dear students all classes of Sun is suspended!"));
        noticelist.add(new ExampleNotice("Date:21/08/06","CSE-2045's mid paper will be published today!"));

        mRecyclerView = findViewById(R.id.RecyclerViewID);
        getSupportActionBar().setTitle("Notice");
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new NoticeAdapter(noticelist);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.silde_out_right);
    }
}
