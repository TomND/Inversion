package Canvas;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.inversion.MainActivity;

// stuff needs to be relative eventually

public class Obstacles {

	
	int max = 5000;
	int min = 1000;
	int randomColor= 0;
	int randomColorInverted= 0;
	//normal spike stuff
	public static int spikeDistance = 1000;
	public static int[] locationX = new int[5];
	public static int[] locationY =	new int[5];	
	public static Bitmap[] spike = new Bitmap[5];
	//inverted spike stuff
	public static int[] locationXInverted = new int[5];
	public static int[] locationYInverted =	new int[5];	
	public static Bitmap[] spikeInverted = new Bitmap[5];
	
	Boolean reset = false;

/*	public static Rect obstacleCollision1;
	public static Rect obstacleCollision2;
	public static Rect obstacleCollision3;
	public static Rect obstacleCollision4;
	public static Rect obstacleCollision5;*/
	
	Random random;

	
	
	public Obstacles(){
		//Bitmap spikes = MainActivity.spike;
		//spike initialization
		for(int x = 0; x < 5; x++){
		spike[x] = MainActivity.spike;
		locationY[x] = (int) (MainActivity.background.getHeight()/2 - 380 );
		locationX[x] = (int) MainActivity.background.getWidth() / 2  + spikeDistance*x + 1500;
		}
		
		//inverted spike initialization
		for(int x = 0; x < 5; x++){
		spikeInverted[x] = MainActivity.spikeInverted;
		locationYInverted[x] = (int) (MainActivity.background.getHeight()/2 - 278  );
		locationXInverted[x] = (int) MainActivity.background.getWidth() / 2  + spikeDistance*x + 1500 + 500;
		}
		
		randomNormal();
		
		
		
	}
	
	
	
		
	public void update(){
		

		
		
		for(int x = 0; x < locationX.length; x++){
		locationX[x] -= Background.movespeed;
		locationXInverted[x] -= Background.movespeed;
		}
		
	}
	
	public void draw(Canvas canvas){
		
		update();
		
				// resets spike location
		if(locationX[4] < (int) MainActivity.background.getWidth() / 2 - 900){
			for (int x = 0; x < 5; x++) {
				locationX[x] = (int) MainActivity.background.getWidth() / 2  + spikeDistance*x + 500;
				
			}
			randomNormal();
		}
				//resets inverted spike location
		if(locationXInverted[4] < (int) MainActivity.background.getWidth() / 2 - 900 - (900/2)){
			for (int x = 0; x < 5; x++) {
				locationXInverted[x] = (int) MainActivity.background.getWidth() / 2  + spikeDistance*x + 750 /*500 + (500/2)*/;
				
			}
			randomInverted();
		}
		
		//randomColor();
		
		canvas.drawBitmap(spike[0], locationX[0] , locationY[0], null);

		canvas.drawBitmap(spike[1], locationX[1] , locationY[1], null);

		canvas.drawBitmap(spike[2], locationX[2] , locationY[2], null);

		canvas.drawBitmap(spike[3], locationX[3] , locationY[3], null);

		canvas.drawBitmap(spike[4], locationX[4] , locationY[4], null);
		
/*		canvas.drawBitmap(spikeInverted[0], locationXInverted[0] , locationYInverted[0], null);

		canvas.drawBitmap(spikeInverted[1], locationXInverted[1] , locationYInverted[1], null);

		canvas.drawBitmap(spikeInverted[2], locationXInverted[2] , locationYInverted[2], null);

		canvas.drawBitmap(spikeInverted[3], locationXInverted[3] , locationYInverted[3], null);

		canvas.drawBitmap(spikeInverted[4], locationXInverted[4] , locationYInverted[4], null);*/
		

	}
	
	public void randomNormal(){	//rename this method please
		for(int x = 0; x < 5; x++){
		randomColor = (int)(Math.random() * (5 - 1) + 1);
		if(randomColor == 1){
			spike[x] = MainActivity.spike;
		}
		else if(randomColor == 2){
			spike[x] = MainActivity.spikeInverted;
		}
		else if(randomColor == 3){
			spike[x] = MainActivity.spike;
		}
		else if(randomColor == 4){
			spike[x] = MainActivity.wall;
		}
		else if(randomColor == 5){
			spike[x] = MainActivity.wallInverted;
		}
		
		if(spike[x] == MainActivity.wall){
			locationY[x] = (int) (MainActivity.background.getHeight()/2 - 630 );
			
		}
		else if(spike[x] == MainActivity.wallInverted){
			locationYInverted[x] = (int) (MainActivity.background.getHeight()/2 - 280 );
			
		}
		else if(spike[x] == MainActivity.spikeInverted){
			locationYInverted[x] = (int) (MainActivity.background.getHeight()/2  - 278 );
		}
		else{
			locationY[x] = (int) (MainActivity.background.getHeight()/2 - 380 );
		}
		
		}
		
	}
	
	public void randomInverted(){
		for(int x = 0; x < 5; x++){
			randomColorInverted = (int)(Math.random() * (5 - 1) + 1);
		if(randomColorInverted == 1){
			spikeInverted[x] = MainActivity.spikeInverted;
		}
		else if(randomColorInverted == 2){
			spikeInverted[x] = MainActivity.spikeInverted;
		}
		else if(randomColorInverted == 3){
			spikeInverted[x] = MainActivity.spikeInverted;
		}
		else if(randomColorInverted == 4){
			spikeInverted[x] = MainActivity.wallInverted;
		}
		else if(randomColorInverted == 5){
			spikeInverted[x] = MainActivity.wallInverted;
		}
		
		if(spikeInverted[x] == MainActivity.wallInverted){
			locationYInverted[x] = (int) (MainActivity.background.getHeight()/2 - 280 );
			
		}
		else{
			locationYInverted[x] = (int) (MainActivity.background.getHeight()/2  - 280 );
		}
		
		}
		
	}
	
}
