package com.rt.xp;

import android.content.*;
import android.graphics.*;

public class Player
{
	  public static final int JUMP=0;
		
		Paint mPaint;
		int x,y,xVel,yVel,gravity,jumpStr,w,h,orig;
		Context context;
		Bitmap mBitmap;
		RectF box;
		
		public Player(Context context){
			this.context=context;
			box = new RectF();
			mPaint = new Paint();
			mPaint.setAntiAlias(true);
			mPaint.setColor(Color.YELLOW);
			
			
			w=100;
			h=250;
			xVel=1;
			yVel=0;
			x=300;
			y=0;
			orig = x;
			gravity=1;
			jumpStr=0;
			
			mBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_launcher);
			
			
			
		}
		public void setBox(RectF box)
		{
				this.box = box;
		}

		public RectF getBox()
		{
				return box;
		}

		public void setX(int x)
		{
				this.x = x;
		}

		public int getX()
		{
				return x;
		}

		public void setY(int y)
		{
				this.y = y;
		}

		public int getY()
		{
				return y=mBitmap.getHeight()/2;
		}

		public void setXVel(int xVel)
		{
				this.xVel = xVel;
		}

		public int getXVel()
		{
				return xVel;
		}

		public void setYVel(int yVel)
		{
				this.yVel = yVel;
		}

		public int getYVel()
		{
				return yVel;
		}

		public void setGravity(int gravity)
		{
				this.gravity = gravity;
		}

		public int getGravity()
		{
				return gravity;
		}

		public void setJumpStr(int jumpStr)
		{
				this.jumpStr = jumpStr;
		}

		public int getJumpStr()
		{
				return jumpStr;
		}

		public void setW(int w)
		{
				this.w = w;
		}

		public int getW()
		{
				return w;
		}

		public void setH(int h)
		{
				this.h = h;
		}

		public int getH()
		{
				return h;
		}
		public void draw(Canvas canvas){
				update();
				box.set(x,y,mBitmap.getWidth()+x,mBitmap.getHeight()+y);
				//canvas.drawRect(box,mPaint);
				canvas.drawRect(box,mPaint);
				canvas.drawBitmap(mBitmap,x,y,mPaint);
				
				
		}
		public void update(){
				
				position();
				
				
		}
		public void position(){
				y+=gravity;
				y+=jumpStr;
				jumpStr+=gravity;
				
				
		}
		public void onPlatform(){
				gravity=0;
				
		}
		public void jump(){
				jumpStr=-25;
		}
		
}
