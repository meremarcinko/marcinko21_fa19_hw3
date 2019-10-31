package com.example.marcinko21_fa19_hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board
{

	int[][] board;
	ArrayList<Integer> boardNum;
	protected int r; //row
	protected int c; //col



	public Board()
	{
		board = new int[4][4];
		boardNum = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
	}

	public int randomize(int n)
	{
		Random randomNum = new Random();
		return randomNum.nextInt(n); //pick a random number for numbers 0-15
	}

	public void placeNum()
	{

		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				int rn = randomize(boardNum.size());
				board[i][j] = boardNum.get(rn);
				boardNum.remove(rn);
			}
		}
	}
}
