package com.example.marcinko21_fa19_hw3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is the SquareSufaceView Class. The board is drawn in this class and the
 * surface gets connected to the actions
 *
 * @author Meredith Marcinko
 * @version 9 November 2019
 */
public class SquareSurfaceView extends SurfaceView implements View.OnTouchListener, View.OnClickListener
{

	private Paint paint = new Paint();
	protected Square[][] theSquare;
	private Board board;
	private int boardSize = 4;//the initial size of the board
	private Paint background = new Paint();
	private Paint numPaint = new Paint();

	/**
	 * This is the constructor where the surface view gets the context and the
	 * arrtibutes that are created
	 * @param context
	 * @param attrs
	 */
	public SquareSurfaceView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		setWillNotDraw(false);
		setBoardSize(boardSize);
	}//SquareSurfaceView

	/**
	 * setBoardSize method:
	 *      this is the method that sets the size of the board
	 * @param theSize
	 */
	public void setBoardSize(int theSize)
	{
		boardSize = theSize;
		board = new Board(600,100,boardSize);
		theSquare = board.getSquare();
	}


	/**
	 * External Citation
	 * Date: October 30th 2019
	 *
	 * Problem: I wasnt sure how to connect the code to the board that I drew
	 *
	 * Solution: Fredrik helped me with the logic of how to draw the board and connect it
	 * to the code that makes it work
	 *
	 * onDraw method:
	 *      this is the method in which the board is drawn on the canvas
	 * @param canvas
	 */
	public void onDraw(Canvas canvas)
	{
		theSquare = board.getSquare();
		background.setTextSize(60);
		setBackgroundColor(Color.LTGRAY);

		if(checkIfGameOver(theSquare,board.boardSize()) == true)
		{
			canvas.drawText("You win!!! :)", 200, 200, background);
		}


		for(int i = 0; i < board.boardSize(); i++)
		{
			for(int j = 0; j<board.boardSize(); j++)
			{
				paint.setColor(Color.GREEN);

				int leftSide = theSquare[i][j].getX();
				int rightSide = theSquare[i][j].getX() + theSquare[i][j].getSide();
				int top = theSquare[i][j].getY();
				int bottom = theSquare[i][j].getY() + theSquare[i][j].getSide();

				canvas.drawRect(leftSide,top,rightSide,bottom, paint);

				paint.setColor(Color.WHITE);

				leftSide = theSquare[i][j].getX()+1;
				rightSide = theSquare[i][j].getX() + theSquare[i][j].getSide()-1;
				top = theSquare[i][j].getY()+1;
				bottom = theSquare[i][j].getY() + theSquare[i][j].getSide()-1;

				canvas.drawRect(leftSide, top, rightSide, bottom, numPaint);

				paint.setColor(Color.BLUE);
				paint.setTextSize(50);

				int value = theSquare[i][j].getNum();
				int x = theSquare[i][j].getX() + theSquare[i][j].getSide() /2;
				int y = theSquare[i][j].getY() + theSquare[i][j].getSide() /2;

				if(value > 0)
				{
					canvas.drawText("" + value, x, y, paint);
				}
				else
				{
					canvas.drawText("", x, y, paint);
				}
			}
		}
	}//onDraw

	/**
	 * checkIfGameOver method:
	 *      this method checks if the numbers are in order and the game is over
	 * @param board
	 * @param size
	 * @return
	 *      true is the game is over
	 */
	public boolean checkIfGameOver(Square[][] board, int size)
	{
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				int number  = board[i][j].getNum();
				int gameGoal = (j%size)+ 1 + i*size;
				if(number == gameGoal)
				{
					list.add(1);
				}
			}
		}
		if(list.size() == size*size-1)
		{
			return true;
		}
		list.clear();
		return false;
	}//checkIfGameOver

	/**
	 * getCoordinates method:
	 *      this is the method for finding the coordinates of the square
	 *      that the user has touched
	 * @param row
	 * @param col
	 * @return
	 *      an array of the values for left, right, top and bottom
	 */
	private int[] getCoordinates(int row, int col)
	{

		int left;
		int right;
		int top;
		int bottom;
		int[] coordinates = new int[4];

		if (row - 1 < 0 && col - 1 < 0) {
			left = -1;
			top = -1;
			right = theSquare[row][col + 1].getNum();
			bottom = theSquare[row + 1][col].getNum();

		} else if (row - 1 < 0 && col + 1 == board.boardSize()) {
			left = theSquare[row][col - 1].getNum();
			top = -1;
			right = -1;
			bottom = theSquare[row + 1][col].getNum();

		} else if (row + 1 == board.boardSize() && col + 1 == board.boardSize()) {
			left = theSquare[row][col - 1].getNum();
			top = theSquare[row - 1][col].getNum();
			right = -1;
			bottom = -1;

		} else if (row + 1 == board.boardSize() && col - 1 < 0) {
			left = -1;
			top = theSquare[row - 1][col].getNum();
			right = theSquare[row][col + 1].getNum();
			bottom = -1;

		} else if (row - 1 < 0) {
			left = theSquare[row][col - 1].getNum();
			top = -1;
			right = theSquare[row][col + 1].getNum();
			bottom = theSquare[row + 1][col].getNum();

		} else if (col - 1 < 0) {
			left = -1;
			top = theSquare[row - 1][col].getNum();
			right = theSquare[row][col + 1].getNum();
			bottom = theSquare[row + 1][col].getNum();

		} else if (row + 1 == board.boardSize()) {
			left = theSquare[row][col - 1].getNum();
			top = theSquare[row - 1][col].getNum();
			right = theSquare[row][col + 1].getNum();
			bottom = -1;

		} else if (col + 1 == board.boardSize()) {
			left = theSquare[row][col - 1].getNum();
			top = theSquare[row - 1][col].getNum();
			right = -1;
			bottom = theSquare[row + 1][col].getNum();

		} else {
			left = theSquare[row][col - 1].getNum();
			top = theSquare[row - 1][col].getNum();
			right = theSquare[row][col + 1].getNum();
			bottom = theSquare[row + 1][col].getNum();

		}
		coordinates[0]=left;
		coordinates[1]=top;
		coordinates[2]=right;
		coordinates[3]=bottom;
		return coordinates;

	}//getCoordinates

	/**
	 * onTouch method:
	 *      this method is where the listeners interact with the board
	 * @param v
	 * @param event
	 * @return
	 *      returns true if the surfaceView was clicked
	 */
	public boolean onTouch(View v, MotionEvent event)
	{
		int left;
		int right;
		int top;
		int bottom;

		if(event.getActionMasked() == MotionEvent.ACTION_DOWN)
		{
			float touchX = event.getX();
			float touchY = event.getY();

			for(int i = 0; i<board.boardSize(); i++)
			{
				for(int j = 0; j<board.boardSize(); j++)
				{
					int xMin = theSquare[i][j].getX();
					int xMax = theSquare[i][j].getX()+theSquare[i][j].getSide();
					int yMin = theSquare[i][j].getY();
					int yMax = theSquare[i][j].getY()+theSquare[i][j].getSide();

					if(touchX > xMin && touchX < xMax && touchY > yMin
							&& touchY < yMax)
					{

						int[] coord = getCoordinates(i,j);
						left = coord[0];
						top = coord[1];
						right = coord[2];
						bottom = coord[3];

						if(left == 0){
							int temp = theSquare[i][j].getNum();
							theSquare[i][j].setNum(0);
							theSquare[i][j-1].setNum(temp);
						}
						if(top == 0){
							int temp = theSquare[i][j].getNum();
							theSquare[i][j].setNum(0);
							theSquare[i-1][j].setNum(temp);
						}
						if(right == 0){
							int temp = theSquare[i][j].getNum();
							theSquare[i][j].setNum(0);
							theSquare[i][j+1].setNum(temp);
						}
						if(bottom == 0){
							int temp = theSquare[i][j].getNum();
							theSquare[i][j].setNum(0);
							theSquare[i+1][j].setNum(temp);
						}

					}
				}
			}
		}
		checkIfGameOver(theSquare, board.boardSize());
		invalidate();
		return true;
	}//onTouch

	/**
	 * onClick method:
	 *      listens to the clicks of the button and responds appropriately
	 */
	@Override
	public void onClick(View v)
	{
		Button theOneClicked = (Button)v;
		CharSequence label = theOneClicked.getText();
		if(label.charAt(0) == 'S')
		{
			board.randomize();
			invalidate();
		}

		if(label.charAt(0) == 'R')
		{
			Random randomNum = new Random();
			numPaint.setARGB(255,randomNum.nextInt(256), randomNum.nextInt(256),
					randomNum.nextInt(256));
			invalidate();
		}
	}
}
