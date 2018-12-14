package com.rt.xp;

import android.content.*;
import android.graphics.*;

public class Player
{
	boolean onAir=true,forward;
		Paint mPaint;
		int x,y,xVel,yVel,gravity,jumpStr,w,h,orig,jumpHeight;
		Context context;
		Bitmap mBitmap;
		RectF box;
		boolean jump;
		
		public Player(Context context) {
			this.context = context;
			box = new RectF();
			mPaint = new Paint();
			mPaint.setAntiAlias(true);
			mPaint.setColor(Color.YELLOW);


			w = 100;
			h = 250;
			xVel = 1;
			yVel = 0;
			x = 300;
			y = 0;
			orig = x;
			gravity = 5;
			jumpStr = 0;

			mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);


		}
			

		public void draw(Canvas canvas){

				box.set(x,y,mBitmap.getWidth()+x,mBitmap.getHeight()+y);
				//canvas.drawRect(center,mPaint);
				canvas.drawRect(box,mPaint);
				canvas.drawBitmap(mBitmap,x,y,mPaint);
				
				
		}
		public void update() {
			y+=gravity;
			if(!onAir){
				y-=jumpStr;
				jumpStr-=gravity;
				if (jumpStr<0||jumpStr>jumpHeight){
					jumpStr=0;
					}
				}
			}

		public void jump(){
			onAir=true;
			jumpStr=40;
			jumpHeight=100;

		}
		public int getX(){
			return x+(int) box.centerX();
		}
		public int getY(){
			return y+mBitmap.getHeight();
		}
		public void setY(int y){
			this.y = y-mBitmap.getHeight();
		}
}
