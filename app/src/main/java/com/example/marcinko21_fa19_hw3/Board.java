package com.example.marcinko21_fa19_hw3;

import java.util.Random;

/**
 * This is the Board Class that creates the sqaures for the board in the game
 *
 * @author Meredith Marcinko
 * @version 8 November 2019
 */
public class Board
{

	private Square[][] board;
	private int size;
	private int x;
	private int y;

	/**
	 * This is the constructor for the board class
	 * it creates the board
	 * @param x the x coordinate for the board
	 * @param y the y coordinate for the board
	 * @param size the size of the board
	 */
	public Board(int x, int y, int size)
	{
		this.x = x;
		this.y = y;
		this.size = size;

		int side = 200;
		int counter = 0;
		board = new Square[size][size];

		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				if(i==size-1 && j==size-1)
				{
					Square s = new Square(x + (j) * side,  y + (i) * side, side, 0);
					board[i][j] = s;
				}
				else
				{
					counter++;
					Square s = new Square(x + (j) * side, y + (i) * side, side, counter);
					board[i][j] = s;
				}
			}
		}
		randomize();

	}//Board

	/**
	 * boardSize method:
	 *      method that has the size of the board
	 * @return
	 *      the size of the board
	 */
	public int boardSize()
	{
		return size;
	}//boardSize

	/**
	 * Square method:
	 *      creates the invisible grid
	 * @return
	 *      the board
	 */
	public Square[][] getSquare()
	{
		return board;
	}//getSquare

	/**
	 * randomize method:
	 *      this method randomizes the numbers on the board
	 */
	public void randomize()
	{
		int z = boardSize()-1;
		int y = boardSize()-1;
		Random randomNum = new Random();

		for(int i = 0; i<boardSize(); i++)
		{
			for(int j = 0; j<boardSize(); j++)
			{
				int ranNum = randomNum.nextInt(z);
				int ranNum2 = randomNum.nextInt(y);
				int temp = board[ranNum][ranNum2].getNum();
				board[ranNum][ranNum2].setNum(board[i][j].getNum());
				board[i][j].setNum(temp);
			}
		}

	}//randomize
}//Board Class
