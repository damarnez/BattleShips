package com.battleships.client.game.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.battleships.client.R;

public class Background {
	
	private Bitmap _faro ;
	private Paint paint = new Paint();  
  
	
	public Background(Context context){
		_faro = BitmapFactory.decodeResource(context.getResources(), R.drawable.faro01);
		 //set the paint settings  
        paint.setAntiAlias(false);  
        paint.setDither(true);  
        paint.setFilterBitmap(false);
	}
	
	public void doDraw(Canvas c){
	    c.drawColor(0xFF56d2E9);  
        c.scale(1, 1);  
        int _faro_with = c.getWidth() - _faro.getWidth();
        c.drawBitmap(_faro,_faro_with,0, paint);
	}
	
}
