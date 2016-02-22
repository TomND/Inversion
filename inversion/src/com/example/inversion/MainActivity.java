package com.example.inversion;

import Canvas.Background;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class com.example.inversion.MainMenu extends Activity{
	
	
	public static Bitmap background, characterBlack, characterWhite, spike, spike1, spike2, spike3, wall, spikeInverted, wallInverted;
	public static float displayValueX, displayValueY;
	
	
	GameView gameView;
	public static Context context;
	FrameLayout gameLayout; // layout for game
	DisplayMetrics metrics;
	Background backgroundDraw;
	Handler handler;
	gameOver gameover;
	

	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gameover = new gameOver(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // loads resources
        loadStuff();
        loadResources();
        createGameView();
        handler = new Handler();
	}

	
	
	// use async eventually
	public void loadResources(){

		
		MainActivity.background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
		MainActivity.characterBlack = BitmapFactory.decodeResource(getResources(), R.drawable.black_square);
		MainActivity.characterWhite = BitmapFactory.decodeResource(getResources(), R.drawable.white_square);
		MainActivity.spike = BitmapFactory.decodeResource(getResources(), R.drawable.spike);
		MainActivity.spike1 = BitmapFactory.decodeResource(getResources(), R.drawable.spike1);
		MainActivity.spike2 = BitmapFactory.decodeResource(getResources(), R.drawable.spike2);
		MainActivity.spike3 = BitmapFactory.decodeResource(getResources(), R.drawable.spike3);
		MainActivity.wall = BitmapFactory.decodeResource(getResources(), R.drawable.wall);
		MainActivity.wallInverted = BitmapFactory.decodeResource(getResources(), R.drawable.wall_inverted);
		MainActivity.spikeInverted = BitmapFactory.decodeResource(getResources(), R.drawable.spike_inverted);
		

		
		
	}
	
	public void loadStuff(){
		
		metrics = this.getResources().getDisplayMetrics();
		displayValueX = metrics.widthPixels;
		displayValueY = metrics.heightPixels;
	}
	
	
	public void createGameView(){
		
		gameView = new GameView(this);
		
		gameLayout = new FrameLayout(this);
		
		gameLayout.addView(gameView);
		
		
		setContentView(gameLayout);
		
	}
	
	
/*	@Override
	 protected void onResume() {
		 super.onResume();
		 
		 gameView.resume();
		 
		 
	 }*/

	protected void onPause(){
		
		super.onPause();
		gameView.pause();
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		gameView.resume();
	}


/*	protected void Draw(Canvas canvas){
		
		
		
		//backgroundDraw.Draw(canvas);
		
		
		canvas.drawRGB(0, 0, 0);
		
	}*/
	
	
	
	
	
	
	
	
	
	
	


}
