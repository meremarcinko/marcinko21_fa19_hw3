package com.example.marcinko21_fa19_hw3;

public class Square
{
	private int x;
	private int y;
	private int num;
	private int side;

	public Square(int x, int y, int side, int num)
	{
		this.x = x;
		this.y = y;
		this.num = num;
		this.side = side;
	}//Square

	public int getSide()
	{
		return side;
	}//getSide

	public int getX()
	{
		return x;
	}//getX

	public int getY()
	{
		return y;
	}//getY

	public int getNum()
	{
		return num;
	}//getNum

	public void setNum(int newNum)
	{
		num = newNum;
	}//setNum
}
