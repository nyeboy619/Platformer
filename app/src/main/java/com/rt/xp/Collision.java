package com.rt.xp;

import android.graphics.*;

public class Collision extends RectF
{
		boolean onPlatform=false;

	public boolean collideOnPlatform(Player player,RectF lvlBox){
			if(lvlBox.contains(player.box.centerX(),player.box.centerY()+(player.box.height()/2))){
				player.stats=player.ON_PLATFORM;
			
	}
	return onPlatform;
	}
}

