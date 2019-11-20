package com.example.iiuctime.ClassRoutine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.iiuctime.ClassRoutine.Adapter.DatabaseOpenHelper;
import com.example.iiuctime.ClassRoutine.Adapter.ExampleAdapter;
import com.example.iiuctime.ClassRoutine.Adapter.ExampleItem;
import com.example.iiuctime.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

@SuppressLint("ValidFragment")
public class Fragment_Routine extends Fragment {

    String parm;
    RecyclerView recyclerView;
    TextView name;
    Cursor c = null;
    ArrayList<ExampleItem> list = new ArrayList<>();
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    ExampleAdapter adapter;
    

    @SuppressLint("ValidFragment")
    public Fragment_Routine(String parm) {
        this.parm = parm;

    }

    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_routine, container, false);

        name = view.findViewById(R.id.name);
        name.setText(parm);
//
//        openHelper = new DatabaseOpenHelper(getContext());
//        db = openHelper.getWritableDatabase();
//        get_routine(parm);
//        db.close();
//
//        recyclerView = view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setHasFixedSize(true);
//        adapter = new ExampleAdapter(getContext(),list);
//        recyclerView.setAdapter(adapter);

        return view;
    }


    public void get_routine(String day){

        c=db.rawQuery("SELECT * FROM tbl_routine WHERE day = '"+day+"'", null);
        int rowCount=c.getCount();

        if(rowCount<=0)
        {
//            Toast.makeText(c, "No data available", Toast.LENGTH_SHORT).show();
            name.setText("NO DATA AVAILABLE");
        }
        else
        {
            c.moveToFirst();

            do {
                String time=c.getString(c.getColumnIndex("time"));
                String subject=c.getString(c.getColumnIndex("subject"));
                Log.d("Database ", time + "  " + subject);
                list.add(new ExampleItem(subject,time));


            } while (c.moveToNext());

        }

    }
}
