package com.example.iiuctime;

public class ExampleNote{
    private int mImage;
    private String mText1;
    private String mText2;

    public ExampleNote(int image,String text1,String text2){
        mImage = image;
        mText1 = text1;
        mText2 = text2;
    }

    public int getImage(){
        return mImage;
    }
    public String getText1(){
        return mText1;
    }
    public String getTexxt2(){
        return mText2;
    }
}
