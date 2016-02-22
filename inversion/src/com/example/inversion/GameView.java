package com.example.inversion;

import Canvas.Background;
import Canvas.Player;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

// remove ontouchlistener
// remove ontouchlistener
public class GameView extends SurfaceView implements Runnable, OnTouchListener/*, View.OnTouchListener*/{

    SurfaceHolder ourHolder;
    Thread ourThread = null;
    boolean isRunning = false;
    Context context;
    Background background;
    Player player;
    MainActivity mainActivity;
    ImageView imageView;
    Collision collision;
    
    

    gameOver gameover;
    //View imageView;
    

	
	public GameView(Context context) {
        super(context);
        ourHolder = getHolder();
        this.context = context;
		setOnTouchListener(new SwipeTouchListener() {
			public void onSwipeTop() {
				// jump when swipe up
				if(Player.inverted){
					Player.revert = true;
				}
				else{
				Player.jump = true;
				}
			}

			public void onSwipeRight() {

			}

			public void onSwipeLeft() {

			}

			public void onSwipeBottom() {
				//invert when swipe down
				
				if(Player.inverted){
					Player.invertJump = true;
				}
				else{
					Player.invert = true;
				}
				
			}
		});
        background = new Background(MainActivity.background);
        player = new Player();
        gameover = new gameOver();
        collision = new Collision();
	}

	/*@Override // jumping stuff..
	public boolean onTouch(View v, MotionEvent e) {
		//int oldX = 0;
		int oldY = 0;
		
		int event = e.getAction();
		Log.d("report", "touch");
		if(event == MotionEvent.ACTION_DOWN){
			//insert crazy jumping physics...
			//oldX = (int) e.getX();
			oldY = (int) e.getY();

			return true;
		}
		else if(e.getAction() == e.ACTION_MOVE){
			if(e.getY() - oldY > 500){
				Player.jump = true;
			}
			//oldY = (int) e.getY();
			return true;
		}
		

			return false;
		
		
	}*/
	
	
	
	
	
	
	public void pause(){
		isRunning = false;
		
		ourThread = null;
	}
	
	public void resume(){
		isRunning = true;
		ourThread = new Thread(this);
		ourThread.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		while(isRunning){
		
        if (!ourHolder.getSurface().isValid()){
            continue;
        }
		
        
        	
        
        Canvas canvas = ourHolder.lockCanvas();

       
        
        try {
			Draw(canvas);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        	collision.collisionCheck();
        	gameover.Over();

        ourHolder.unlockCanvasAndPost(canvas);
        
        
		}
	}
	
	protected void Draw(Canvas canvas) throws InterruptedException{
		
		
/*		if(Collision.test){
			canvas.drawRGB(200, 0, 0);
		}*/
		background.Draw(canvas);
		player.Draw(canvas);
		//Log.d("error1", canvas+" ");
		
		//canvas.drawRGB(200, 0, 0);
		//Log.d("error2", canvas+" ");
	}

	public boolean onDown(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	
	
	

}
