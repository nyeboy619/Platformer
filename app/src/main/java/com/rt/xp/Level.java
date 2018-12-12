package com.rt.xp;

import android.content.*;
import android.graphics.*;
import java.util.*;

public class Level
{
		Context context;
		
		Paint p;
		ArrayList<RectF> rects;
		int w;
		
		public Level(Context context){
			this.context = context;
			
			rects = new ArrayList<>();
			p = new Paint();
			p.setColor(Color.GREEN);
			p.setAntiAlias(true);
			p.setStyle(Paint.Style.STROKE);
			p.setAlpha((int)Math.random()+200);
			
			w=200;
			for(int i=0;i<=10;i++){
					RectF rect = new RectF(w*i,500,(i+1)*w,600);
					rects.add(rect);
			}
			
			
			
		}
		
		public void draw(Canvas canvas){
				
				for(RectF rect: rects){
						canvas.drawRect(rect,p);
				}
		}
		
		
		
}
