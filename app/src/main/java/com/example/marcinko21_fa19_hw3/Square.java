package com.example.marcinko21_fa19_hw3;

/**
 * This is the Square class that makes the individual squares for each of the square in the board
 *
 * @author Meredith Marcinko
 * @version 8 November 2019
 */
public class Square
{
	private int x;
	private int y;
	private int num;
	private int side;

	/**
	 * The constructor for the Square Class
	 * @param x
	 * @param y
	 * @param side
	 * @param num
	 */
	public Square(int x, int y, int side, int num)
	{
		this.x = x;
		this.y = y;
		this.num = num;
		this.side = side;
	}//Square

	/**
	 * getSide Method:
	 *      this is the method to get the side of the square
	 * @return
	 *      the length of the side for the sqaure
	 */
	public int getSide()
	{
		return side;
	}//getSide

	/**
	 * getX Method:
	 *      this is the method that get the x coordinate of the square
	 * @return
	 *      the x coordinate of the square
	 */
	public int getX()
	{
		return x;
	}//getX

	/**
	 * getY Method:
	 *      this is the method that gets the y coordinate of the square
	 * @return
	 *      the y coordinate of the square
	 */
	public int getY()
	{
		return y;
	}//getY

	/**
	 * getNum Method:
	 *      this is the method that number that the square contains
	 * @return
	 *      the number that the square contains
	 */
	public int getNum()
	{
		return num;
	}//getNum

	/**
	 * setNum method:
	 *      this method giver the sqaure the new number that is contained
	 * @param newNum
	 *      the new number that is within the square
	 */
	public void setNum(int newNum)
	{
		num = newNum;
	}//setNum
}
