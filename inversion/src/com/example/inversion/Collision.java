package com.example.inversion;

import Canvas.Obstacles;
import Canvas.Player;
import android.graphics.Rect;

public class Collision {
	/// obstacle collision
	public static Rect obstacleCollision1, obstacleCollision2,obstacleCollision3,obstacleCollision4,obstacleCollision5;
	public static Rect obstacleCollisionInverted1,obstacleCollisionInverted2,obstacleCollisionInverted3,obstacleCollisionInverted4,obstacleCollisionInverted5;
	//// player collision
	public static Rect playerCollision;
	
	public Collision(){
		// initialize object collison.
		obstacleCollision1 = new Rect(Obstacles.locationX[0], Obstacles.locationY[0], Obstacles.locationX[0] + MainActivity.characterBlack.getWidth(), Obstacles.locationY[0] + MainActivity.characterBlack.getHeight());
		obstacleCollision2 = new Rect(Obstacles.locationX[1], Obstacles.locationY[1], Obstacles.locationX[1] + MainActivity.characterBlack.getWidth(), Obstacles.locationY[1] + MainActivity.characterBlack.getHeight());
		obstacleCollision3 = new Rect(Obstacles.locationX[2], Obstacles.locationY[2], Obstacles.locationX[2] + MainActivity.characterBlack.getWidth(), Obstacles.locationY[2] + MainActivity.characterBlack.getHeight());
		obstacleCollision4 = new Rect(Obstacles.locationX[3], Obstacles.locationY[3], Obstacles.locationX[3] + MainActivity.characterBlack.getWidth(), Obstacles.locationY[3] + MainActivity.characterBlack.getHeight());
		obstacleCollision5 = new Rect(Obstacles.locationX[4], Obstacles.locationY[4], Obstacles.locationX[4] + MainActivity.characterBlack.getWidth(), Obstacles.locationY[4] + MainActivity.characterBlack.getHeight());
		////initialize player collision
		playerCollision = new Rect(Player.locationX,Player.locationY,Player.locationX + MainActivity.characterBlack.getWidth(),Player.locationY + MainActivity.characterBlack.getHeight());
		// initialize object collision inverted
		obstacleCollisionInverted1 = new Rect(Obstacles.locationXInverted[0], Obstacles.locationYInverted[0], Obstacles.locationXInverted[0] + MainActivity.characterBlack.getWidth(), Obstacles.locationYInverted[0] + MainActivity.characterBlack.getHeight());
		obstacleCollisionInverted2 = new Rect(Obstacles.locationXInverted[1], Obstacles.locationYInverted[1], Obstacles.locationXInverted[1] + MainActivity.characterBlack.getWidth(), Obstacles.locationYInverted[1] + MainActivity.characterBlack.getHeight());
		obstacleCollisionInverted3 = new Rect(Obstacles.locationXInverted[2], Obstacles.locationYInverted[2], Obstacles.locationXInverted[2] + MainActivity.characterBlack.getWidth(), Obstacles.locationYInverted[2] + MainActivity.characterBlack.getHeight());
		obstacleCollisionInverted4 = new Rect(Obstacles.locationXInverted[3], Obstacles.locationYInverted[3], Obstacles.locationXInverted[3] + MainActivity.characterBlack.getWidth(), Obstacles.locationYInverted[3] + MainActivity.characterBlack.getHeight());
		obstacleCollisionInverted5 = new Rect(Obstacles.locationXInverted[4], Obstacles.locationYInverted[4], Obstacles.locationXInverted[4] + MainActivity.characterBlack.getWidth(), Obstacles.locationYInverted[4] + MainActivity.characterBlack.getHeight());
	}
	
	public void Update(){
		
		obstacleCollision1 = new Rect(Obstacles.locationX[0], Obstacles.locationY[0], Obstacles.locationX[0] + Obstacles.spike[0].getWidth(), Obstacles.locationY[0] + Obstacles.spike[0].getHeight());
		obstacleCollision2 = new Rect(Obstacles.locationX[1], Obstacles.locationY[1], Obstacles.locationX[1] + Obstacles.spike[1].getWidth(), Obstacles.locationY[1] + Obstacles.spike[1].getHeight());
		obstacleCollision3 = new Rect(Obstacles.locationX[2], Obstacles.locationY[2], Obstacles.locationX[2] + Obstacles.spike[2].getWidth(), Obstacles.locationY[2] + Obstacles.spike[2].getHeight());
		obstacleCollision4 = new Rect(Obstacles.locationX[3], Obstacles.locationY[3], Obstacles.locationX[3] + Obstacles.spike[3].getWidth(), Obstacles.locationY[3] + Obstacles.spike[3].getHeight());
		obstacleCollision5 = new Rect(Obstacles.locationX[4], Obstacles.locationY[4], Obstacles.locationX[4] + Obstacles.spike[4].getWidth(), Obstacles.locationY[4] + Obstacles.spike[4].getHeight());
		////initialize player collision
		playerCollision = new Rect(Player.locationX,Player.locationY,Player.locationX + MainActivity.characterBlack.getWidth(),Player.locationY + MainActivity.characterBlack.getHeight());
		/////stuff
		obstacleCollisionInverted1 = new Rect(Obstacles.locationXInverted[0], Obstacles.locationYInverted[0], Obstacles.locationXInverted[0] + Obstacles.spike[0].getWidth(), Obstacles.locationYInverted[0] + Obstacles.spike[0].getHeight());
		obstacleCollisionInverted2 = new Rect(Obstacles.locationXInverted[1], Obstacles.locationYInverted[1], Obstacles.locationXInverted[1] + Obstacles.spike[1].getWidth(), Obstacles.locationYInverted[1] + Obstacles.spike[1].getHeight());
		obstacleCollisionInverted3 = new Rect(Obstacles.locationXInverted[2], Obstacles.locationYInverted[2], Obstacles.locationXInverted[2] + Obstacles.spike[2].getWidth(), Obstacles.locationYInverted[2] + Obstacles.spike[2].getHeight());
		obstacleCollisionInverted4 = new Rect(Obstacles.locationXInverted[3], Obstacles.locationYInverted[3], Obstacles.locationXInverted[3] + Obstacles.spike[3].getWidth(), Obstacles.locationYInverted[3] + Obstacles.spike[3].getHeight());
		obstacleCollisionInverted5 = new Rect(Obstacles.locationXInverted[4], Obstacles.locationYInverted[4], Obstacles.locationXInverted[4] + Obstacles.spike[4].getWidth(), Obstacles.locationYInverted[4] + Obstacles.spike[4].getHeight());
		
	}
	
	public void collisionCheck(){
		
		Update();
		
		// checks for collision
		if(Rect.intersects(playerCollision, obstacleCollision1)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollision2)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollision3)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollision4)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollision5)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollisionInverted1)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollisionInverted2)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollisionInverted3)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollisionInverted4)){
			gameOver.over = true;
		}
		else if(Rect.intersects(playerCollision, obstacleCollisionInverted5)){
			gameOver.over = true;
		}
		
		
		
	}
	
	
	
}
