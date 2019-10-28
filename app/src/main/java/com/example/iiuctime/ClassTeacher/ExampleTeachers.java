package com.example.iiuctime.ClassTeacher;

import android.widget.TextView;

public class ExampleTeachers {
    private int mImage;
    private String mtext1;
    private String mtext2;

    public ExampleTeachers(int image,String text1,String text2){
        mImage = image;
        mtext1 = text1;
        mtext2 = text2;
    }

    public int getmImage() {
        return mImage;
    }

    public String getMtext1() {
        return mtext1;
    }

    public String getMtext2() {
        return mtext2;
    }


}
