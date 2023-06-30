package com.wwx16265;

import java.util.Random;

//guess the number game
public class guess_number extends game_base 
{
	// default constructor
	public guess_number()
	{
		super("Guess the number", "Test you luck against the ruthless machine. Input a number from a range [0, 10] and see if the computer chooses the same!");
	}
	
	// processes the game's single iteration
	public void update(String input)
	{
		int number = -1;
		try
		{
			number = Integer.parseInt(input);
		}
		catch(Exception e)
		{
			System.out.println("Invalid input! Please try again.");
		}
		
		if(number < 0 || number > 10)
		{
			System.out.println("Given number is outside of the [0, 10] range. I know you crave to win against me, but it won't happen if you don't follow the rules!");
			return;
		}
			
		Random random = new Random();
		int my_number = random.nextInt(10);
		
		System.out.println("Your choice: " + number);
		System.out.println("Computer's choice: " + my_number);
		
		if(my_number == number)
		{
			this.m_user_score++;
			System.out.println("WOW! You have guessed correctly!");
		}
		else
		{
			this.m_my_score++;
			System.out.println("Better luck next time!");
		}
		
		System.out.println("You: " + this.m_user_score);
		System.out.println("Computer: " + this.m_my_score);
	}
}