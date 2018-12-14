package com.rt.xp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class TouchControl {
    int x,y,w,h,x2,y2;
    Paint tPaint;
    RectF center,plate,jumpRect;
    boolean control=false;

    public TouchControl(){

        center = new RectF();
        plate = new RectF();
        jumpRect = new RectF();
        tPaint = new Paint();
        tPaint.setAntiAlias(true);
        tPaint.setColor(Color.YELLOW);
        tPaint.setAlpha(250/2);



        x=0;
        y=0;
        w=150;
        h=150;

        center.set(x,y,x+w,y+h);


    }
    public void draw(Canvas canvas){
        canvas.drawOval(center,tPaint);
        canvas.drawOval(plate,tPaint);


    }
    public void update(int x, int y){
        this.x=x;
        this.y=y;
        center.set(this.x-w/2,this.y-h/2,this.x+w/2,this.y+h/2);
    }
    public void setPlate(int x,int y){
        x2 = x;
        y2 = y;
        plate.set(x2-100,y2-100,x2+100,y2+100);
    }


}
