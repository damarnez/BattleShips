package com.battleships.client.game.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.battleships.client.R;

public class Chip extends Generic{

	
	private Bitmap _wather ;
	private Bitmap _red_wather ;
	private Paint paint = new Paint();  
	public int size = 0;
 	public boolean visible;
 	public boolean ship; 
 	private int order = 0;  
 	
 	
	public Chip(Context context){
	  super(context);
	  _wather = BitmapFactory.decodeResource(context.getResources(), R.drawable.wather);
	  _red_wather = BitmapFactory.decodeResource(context.getResources(), R.drawable.redwather);
	  setHeigth(_wather.getHeight());
	  setWidth(_wather.getWidth());
	  //Default get with
	  size = _wather.getWidth();
	  //set the paint settings  
      paint.setAntiAlias(false);  
      paint.setDither(true);  
      paint.setFilterBitmap(false);
      visible = true;
      ship = false;
 	}
	
	public void doDraw(Canvas c){
	    c.scale(1, 1);  
		//Is resized 
	    if(_wather.getWidth() != size){
			_wather = getResizedBitmap(_wather, size,size);
		}
	    
	    if(visible){
	    	c.drawBitmap(_wather,getX(),getY(), paint);
	    }else{
	    	if(ship){
	    	  	c.drawBitmap(_red_wather,getX(),getY(), paint);
	    	}
	    }
	}
	
	
	public boolean checkCollision(Coordinates coordinates){
		 
		int firstXrange = getX() + getSize();
		int firstYrange = getY() + getSize();
		
		if((getX() <= coordinates.getX() && firstXrange >= coordinates.getX()) && 
			(getY()<= coordinates.getY() && firstYrange >= coordinates.getY())){
			Log.d("Collision","get X :"+coordinates.getX()+ " get Y : "+coordinates.getY());
			Log.d("Collision","Collision!!");
			visible = false;
			return true;
		}
		return false;
	}
 
	
	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
