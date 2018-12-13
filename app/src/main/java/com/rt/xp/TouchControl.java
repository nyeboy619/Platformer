package com.rt.xp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class TouchControl {
    int x,y,w,h;
    Paint tPaintl;
    RectF box;
    public TouchControl(){
        box = new RectF();
        tPaintl = new Paint();
        x=0;
        y=0;
        w=200;
        h=200;

    }
    public void draw(Canvas canvas){

    }
    public void update(){

    }
}
