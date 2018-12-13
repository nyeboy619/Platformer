package com.rt.xp;

import android.graphics.*;
import android.view.*;

public class MainThread extends Thread
{


	private boolean running;
	private SurfaceHolder surfaceHolder;
	private MainPanel mainPanel;

	public static Canvas canvas;

	public MainThread(SurfaceHolder surfaceHolder,MainPanel mainPanel){
		super();
		this.surfaceHolder = surfaceHolder;
		this.mainPanel = mainPanel;

	}

	public void setRunning(boolean running){
		this.running = running;
	}

	@Override
	public void run(){


		while(running){

			canvas = null;

			try{
				canvas = this.surfaceHolder.lockCanvas();
				synchronized(surfaceHolder){
					this.mainPanel.update();
					this.mainPanel.draw(canvas);
				}
			}	catch (Exception e)	{	e.printStackTrace();}
				finally {
					if(canvas != null){
						try{



						surfaceHolder.unlockCanvasAndPost(canvas);
					}	
					catch (Exception e) {e.printStackTrace();}

						

				}

		}	
	}}
}
