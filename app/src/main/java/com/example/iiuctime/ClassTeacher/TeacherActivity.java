package com.example.iiuctime.ClassTeacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.iiuctime.R;

import java.util.ArrayList;

public class TeacherActivity extends AppCompatActivity {
   private RecyclerView mRecyclerView;
   private RecyclerView.LayoutManager mLayoutmanager;
   private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);


        ArrayList<ExampleTeachers> teacherslist = new ArrayList<>();

        teacherslist.add(new ExampleTeachers(R.drawable.person1,"Aidul Islam","Assinstant Professior"));
        teacherslist.add(new ExampleTeachers(R.drawable.person2,"Robiul Alam","Professior"));
        teacherslist.add(new ExampleTeachers(R.drawable.person3,"Md. Mofizul Alam","Lecturer"));
        teacherslist.add(new ExampleTeachers(R.drawable.person4,"Abdul Kalam","Associate Professior"));
        teacherslist.add(new ExampleTeachers(R.drawable.person5,"Abddus Salam","Professior"));

        mRecyclerView = findViewById(R.id.RecyclerViewTeacher);
        getSupportActionBar().setTitle("Teachers");
        mRecyclerView.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mAdapter = new TeachersAdapter(teacherslist);

        mRecyclerView.setLayoutManager(mLayoutmanager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
