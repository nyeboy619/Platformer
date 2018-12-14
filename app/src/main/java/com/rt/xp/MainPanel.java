package com.rt.xp;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

import java.util.zip.Checksum;

public class MainPanel extends SurfaceView implements SurfaceHolder.Callback
{
	MainThread thread;
	Point touchPoint;
	Context context;
	Display display;
	int x,y,sw,sh;

	
	Player player;
	Level lvl;
	Viewport viewport;
	Collision collision;
	TouchControl touchControl;
	
	
	
	
	
	public MainPanel(Context context,Display display){
		super(context);

		this.context = context;
		getHolder().addCallback(this);
		player = new Player(context);
		lvl = new Level(context);
		viewport = new Viewport();
		collision = new Collision();
		touchControl = new TouchControl();
		
		
		this.display = display;
		touchPoint = new Point();
		setFocusable(true);
		
		
		sw = this.getResources().getDisplayMetrics().widthPixels;
		sh = this.getResources().getDisplayMetrics().heightPixels;
		
		
		
	
		
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder){
		thread = new MainThread(getHolder(),this);

		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder){

		boolean retry = true;
		while(retry){
			try{
				thread.setRunning(false);
				thread.join();
			}	catch (Exception e) {	e.printStackTrace();}
			retry = false;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){

			touchPoint.set((int)event.getX(),(int)event.getY());
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
				touchControl.setPlate(touchPoint.x,touchPoint.y);
				touchControl.control=true;



		
			break;
			case MotionEvent.ACTION_MOVE:
				touchControl.update(touchPoint.x,touchPoint.y);
						viewport.setLocation(0.01f,0,-8);
					
			break;
			case MotionEvent.ACTION_UP:
				touchControl.control=false;

			
			break;
			case MotionEvent.ACTION_POINTER_2_DOWN:

				if (!player.onAir)
					player.jump();

			break;
		}

		return true;
	}



	@Override
	public void draw(Canvas canvas){
			

			
		super.draw(canvas);
		if(touchControl.control){
			touchControl.draw(canvas);
		}

	  viewport.applyToCanvas(canvas);
		player.draw(canvas);
		lvl.draw(canvas);
	
	}

	public void update(){
		player.update();
	    for(RectF rect:lvl.rects) {
            collision.checkCollision(player,rect);
        }
	}
	
	
	
	}
	
	
	

