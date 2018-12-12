package com.rt.xp;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

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
	
	
	
	
	
	public MainPanel(Context context,Display display){
		super(context);

		this.context = context;
		getHolder().addCallback(this);
		player = new Player(context);
		lvl = new Level(context);
		viewport = new Viewport();
		collision = new Collision();
		
		
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
		
			break;
			case MotionEvent.ACTION_MOVE:
						player.jump();
						viewport.setLocation(0.01f,0,-8);
					
			break;
			case MotionEvent.ACTION_UP:
			
			break;
		}

		return true;
	}

	public void update(){
			checkCollision();
	}

	@Override
	public void draw(Canvas canvas){
			
		update();
			
		super.draw(canvas);
	  viewport.applyToCanvas(canvas);
		player.draw(canvas);
		lvl.draw(canvas);
	
	}
	
	public void checkCollision(){
			
		for(RectF rect:lvl.rects){
			
				collision.collideOnPlatform(player,rect);
				
		}
	}
	
	
	
	
	}
	
	
	

