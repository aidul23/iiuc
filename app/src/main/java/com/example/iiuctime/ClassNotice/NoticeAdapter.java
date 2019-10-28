package com.example.iiuctime.ClassNotice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iiuctime.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    private ArrayList<ExampleNotice> mNoticelist;

    public static class NoticeViewHolder extends RecyclerView.ViewHolder{

        public TextView textView1;
        public TextView textView2;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.TextViewID1);
            textView2 = itemView.findViewById(R.id.TextViewID2);
        }
    }

    public NoticeAdapter(ArrayList<ExampleNotice> noticelist){
        mNoticelist = noticelist;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_example,parent,false);
        NoticeViewHolder en = new NoticeViewHolder(v);
        return en;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        ExampleNotice currentItem = mNoticelist.get(position);


        holder.textView1.setText(currentItem.getmText1());
        holder.textView2.setText(currentItem.getmText2());
        //holder.textView2.setText(mNoticelist.get(position).getmText1());
    }

    @Override
    public int getItemCount() {
        return mNoticelist.size();
    }
}
