package com.example.marcinko21_fa19_hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

/**
 * This is the MainActivity where the buttons connect to the actions
 * I added a button that changes the color of the board when pressed
 *
 * @author Meredith Marcinko
 * @version 9 November 2019
 */
public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//find the SurfaceView
		SquareSurfaceView SqrSV = findViewById(R.id.SquareSurfaceView);

		SqrSV.setOnTouchListener(SqrSV);

		Button shuffleButton = findViewById(R.id.shuffleButton);
		shuffleButton.setOnClickListener(SqrSV);

		Button randomColor = findViewById(R.id.randomColorButton);
		randomColor.setOnClickListener(SqrSV);


	}
}
