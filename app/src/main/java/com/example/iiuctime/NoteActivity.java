package com.example.iiuctime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        ArrayList<ExampleNote> examplelist = new ArrayList<>();
        examplelist.add(new ExampleNote(R.drawable.note1,"CSE-3502","Mid"));
        examplelist.add(new ExampleNote(R.drawable.note2,"CSE-3501","Mid"));
        examplelist.add(new ExampleNote(R.drawable.note3,"CSE-3503","Final"));

        mRecyclerView = findViewById(R.id.RecyclerViewID);
        getSupportActionBar().setTitle("Note");
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(examplelist);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}