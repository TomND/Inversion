package Canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.inversion.MainActivity;

public class Player extends Activity{

	public static int locationX = (int) (MainActivity.displayValueX/2) - 500;
	public static int locationY = (int) (MainActivity.displayValueY/2) - 100;
	public static Boolean jump = false;
	public static Boolean invert = false;
	public static Boolean inverted = false;
	public static Boolean revert = false;
	public static Boolean invertJump = false;
	static Context context;
	int counter = 0;
	int jumpHeight = 12;
	int invertHeight = 7;
	int invertSpeed = 18;
	int jumpSpeed = 20; //higher number is slower
	int collision = 0;

	public static Bitmap player = MainActivity.characterBlack;
public Player(){
	

	//collisionPlayer = (1,2,3,4);
	
}

/*public static void context(Context context){
	Player.context = context;
}*/






public void Draw(Canvas canvas){
	
	if(jump && !inverted){ /// player jumps
	//jump = false;
			if (counter < jumpSpeed) {
				locationY -= jumpHeight;

				canvas.drawBitmap(player, locationX, locationY, null);
				counter++;
			} else if (counter < jumpSpeed*2) {
				locationY += jumpHeight;

				canvas.drawBitmap(player, locationX, locationY, null);
				counter++;
			}
			else{
				jump = false;
				counter = 0;
			
				canvas.drawBitmap(player, locationX, locationY, null);
			}
	
	}
	else if(invert && !inverted){ // inverts player
		player = MainActivity.characterWhite;
		//inverted = true;
		if (counter < invertSpeed) {
			locationY += invertHeight;

			canvas.drawBitmap(player, locationX, locationY, null);
			counter++;
		}
		else{
			inverted = true;
			invert = false;
			counter = 0;
			
			canvas.drawBitmap(player, locationX, locationY, null);
		}
	}
	else if(revert && inverted){ // reverts the player
		
		player = MainActivity.characterBlack;
		if (counter < invertSpeed) {
			locationY -= invertHeight;

			canvas.drawBitmap(player, locationX, locationY, null);
			counter++;
		}
		else{
			inverted = false;
			revert = false;
			counter = 0;
		
			canvas.drawBitmap(player, locationX, locationY, null);
		}
	}
	else if(inverted && invertJump){ /// inverted jump  player
		player = MainActivity.characterWhite;
		if (counter < jumpSpeed) {
			locationY += jumpHeight;

			canvas.drawBitmap(player, locationX, locationY, null);
			counter++;
		} else if (counter < jumpSpeed*2) {
			locationY -= jumpHeight;

			canvas.drawBitmap(player, locationX, locationY, null);
			counter++;
		}
		else{
			invertJump = false;
			counter = 0;
		
			canvas.drawBitmap(player, locationX, locationY, null);
		}
	}
	else{
	canvas.drawBitmap(player, locationX, locationY, null);
	//collisionPlayer = new Rect(locationX,locationY,locationX + MainActivity.characterBlack.getWidth(),locationY + MainActivity.characterBlack.getHeight());
	//canvas.drawRGB(0, 0, 200);
	}
}














}