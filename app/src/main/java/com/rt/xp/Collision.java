package com.rt.xp;


import android.graphics.RectF;

public class Collision
{

		public void checkCollision(Player player,RectF lvlBox){
			if(lvlBox.contains(player.getX(),player.getY())){
				player.onAir=false;
				if(!player.jump) {

					player.setY((int) lvlBox.top);
					if(player.getY()>lvlBox.top)
						player.setY((int) lvlBox.top);

				}
				if(player.jump){

					player.jump();
				}
			}
		}
}

