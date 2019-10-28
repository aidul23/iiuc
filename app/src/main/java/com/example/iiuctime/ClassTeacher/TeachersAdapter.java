package com.example.iiuctime.ClassTeacher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiuctime.R;

import java.util.ArrayList;

public class TeachersAdapter extends RecyclerView.Adapter<TeachersAdapter.TeachersviewHolder> {
    private ArrayList<ExampleTeachers> mTeachersList;

    public static class TeachersviewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textViewTeacher1;
        public TextView textViewTeacher2;

        public TeachersviewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageId);
            textViewTeacher1 = itemView.findViewById(R.id.TextViewTeacherID1);
            textViewTeacher2 = itemView.findViewById(R.id.TextViewTeacherID2);
        }
    }

    public TeachersAdapter(ArrayList<ExampleTeachers> teachersList){
        mTeachersList = teachersList;
    }
    @NonNull
    @Override
    public TeachersviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teachers_example,parent,false);
        TeachersviewHolder en = new TeachersviewHolder(v);
        return en;
    }

    @Override
    public void onBindViewHolder(@NonNull TeachersviewHolder holder, int position) {
        ExampleTeachers currentItem = mTeachersList.get(position);

        holder.imageView.setImageResource(currentItem.getmImage());
        holder.textViewTeacher1.setText(currentItem.getMtext1());
        holder.textViewTeacher2.setText(currentItem.getMtext2());
    }


    @Override
    public int getItemCount() {
        return mTeachersList.size();
    }
}
