package com.example.iiuctime.ClassRoutine.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiuctime.R;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    Context c;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView subject,time;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.subject);
            time = itemView.findViewById(R.id.time);
        }
    }

    public ExampleAdapter(Context context,ArrayList<ExampleItem> examplelist){
        this.mExampleList = examplelist;
        this.c = context;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_routine,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        final ExampleItem currentitem = mExampleList.get(position);
        holder.subject.setText(currentitem.getSubject());
        holder.time.setText(currentitem.getTime());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
