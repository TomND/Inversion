package Canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import com.example.inversion.MainActivity;
import com.example.inversion.gameOver;

public class Background  {

	public static int movespeed;
	public static int timer;
	public static int pauseTime = 0;
	
	
	public static Boolean initialized = false;
	public static Boolean obstacle = false;
	
	public static Bitmap map;
	
	gameOver gameOver;
	Player player;
	
	Obstacles obstacles;
	int sourceY = 0;
	int sourceX = 0;
	
	
	public Background(Bitmap map){
		
		if(!initialized){
			//map = this.map;
			this.map = map;
			initialized = true;
		}
		obstacles = new Obstacles();
		
		
		
		
		
	}
	
	
	
	
	
	public void Update(){
		
		timer = 50; // time till objects spawn...
		movespeed = 8; // object movespeed
		
		
		if(pauseTime>timer){
			obstacle = true;
		}
		else{
			pauseTime++;
		}
		
		
	}
	
	
	public void Draw(Canvas canvas){
		
		Update();
		
		
        int halfX = (int)MainActivity.displayValueX / 2;
        int halfY = (int)MainActivity.displayValueY / 2;
        int fullX = (int)MainActivity.displayValueX;
        int fullY = (int)MainActivity.displayValueY;
        double scaleMap = (double)fullX / 150;

        // THE RECT METHOD OF DRAWING
        sourceX = (map.getWidth() / 2) - halfX;
        sourceY = (map.getHeight() / 2) - halfY;


        Rect r1 = new Rect(sourceX, sourceY, sourceX + fullX, sourceY + fullY);
        Rect r2 = new Rect((int)((double)-fullX * scaleMap), (int)((double)-fullX * scaleMap), fullX + (int)((double)fullX * scaleMap), fullY + (int)((double)fullX * scaleMap));
		
		
		
		

		Log.d("error_background", canvas+" ");
		//canvas.drawBitmap(map, matrix, paint);
		canvas.drawRGB(0, 0, 200);
		canvas.drawBitmap(map, r1, r2, null);
		obstacles.draw(canvas);
		

		
		if (obstacle) {
			obstacle = false;
			obstacles.draw(canvas);
			
			//pauseTime = 0;
		}
		
	}
	
}
