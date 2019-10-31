package com.example.marcinko21_fa19_hw3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class SquareSurfaceView extends SurfaceView implements View.OnTouchListener
{

	public SquareSurfaceView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		setWillNotDraw(false);
	}

	public boolean onTouch(View v, MotionEvent event)
	{
		int touchX = (int)event.getX();
		int touchY = (int)event.getY();

		//if(event.getAction() == MotionEvent.ACTION_DOWN)
		//{
				//if the number is tapped move to open space
		//}


		return true;
	}

	public void onDraw(Canvas canvas)
	{
		int XS = 650; //the start x position of the line
		int YS = 225; //the start y position of the line
		int XE = 1250; //the end x position of the line
		int YE = 825; //the end y position of the line
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);

		//for the horizontal lines
		canvas.drawLine(XS,YS,XE,YS, paint);
		canvas.drawLine(XS,YS+150,XE,YS+150, paint);
		canvas.drawLine(XS,YS+300,XE,YS+300, paint);
		canvas.drawLine(XS,YS+450,XE,YS+450, paint);
		canvas.drawLine(XS,YS+600,XE,YS+600, paint);

		//for the vertical lines
		canvas.drawLine(XS,YS,XS,YE, paint);
		canvas.drawLine(XS+150,YS,XS+150,YE, paint);
		canvas.drawLine(XS+300,YS,XS+300,YE, paint);
		canvas.drawLine(XS+450,YS,XS+450,YE, paint);
		canvas.drawLine(XS+600,YS,XS+600,YE, paint);


	}
}
