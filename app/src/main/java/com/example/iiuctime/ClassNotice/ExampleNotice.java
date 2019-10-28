package com.example.iiuctime.ClassNotice;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleNotice {
    private String mText1;
    private String mText2;

    public ExampleNotice(String text1,String text2){
        mText1 = text1;
        mText2 = text2;
    }
    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }

}
