package com.example.inversion;

import Canvas.Player;
import android.content.Context;
import android.content.Intent;

public class gameOver {

	public static Boolean over = false;
	static Context context;
	
	// gets the context
	public gameOver(Context context){
		
		gameOver.context = context;
		
		
	}
	public gameOver(){
		
		
	}
	
	
	// ends the game, opens the game over screen, resets player position.
	public void Over(){
		
		if(over){
			//android.os.Process.killProcess(android.os.Process.myPid()); insert kill button. asdawe;WS?DB fuck
			
			over = false;
			Intent intent = new Intent(context,EndMenu.class)
	        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
			context.startActivity(intent);
			Player.locationX = (int) (MainActivity.displayValueX/2) - 500;
			Player.locationY = (int) (MainActivity.displayValueY/2) - 100;
			Player.player = MainActivity.characterBlack;
		//finish();
			
			
		}
		
	}
	
	
	
	
	
	
}
