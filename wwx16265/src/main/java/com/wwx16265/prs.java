package com.wwx16265;

import java.util.Random;

//Paper, Rock, Scissors game
public class prs extends game_base {
	// enum representing possible options
	private enum hand_type
	{
		INVALID(-1, ""),
		PAPER(0, "Paper"),
		ROCK(1, "Rock"),
		SCISSORS(2, "Scissors");
		
		final int id;
		final String name;
		
		hand_type(int id, String name)
		{
			this.id = id;
			this.name = name;
		}
	}
	
	// default constructor.
	public prs()
	{
		super("Paper, Rock, Scissors", "Enjoy your epic battle against the computer in which you try to establish dominance over the machines random number generator algorithm!");
	}
	
	// processes the game's single iteration 
	public void update(String input)
	{
		if(this.get_hand_type(input) == hand_type.INVALID)
		{
			System.out.println("Invalid hand gesture. You need to choose one of the following: \"Paper\", \"Rock\", \"Scissors\"");
			return;
		}
		
		Random random = new Random();
		int my_hand_id = random.nextInt(3);
		hand_type my_hand = this.get_hand_type(my_hand_id); 
		hand_type user_hand = this.get_hand_type(input);
				
		System.out.println("Your choice: " + input);
		System.out.println("Computer's choice: " + my_hand.name);
		
		int result = this.check_winner(user_hand, my_hand);
		if(result == -1)
		{
			this.m_user_score++;
			System.out.println("You have won!");
		}
		else if(result == 0)
		{
			System.out.println("Draw!");
		}
		else if(result == 1)
		{
			this.m_my_score++;
			System.out.println("You have lost!");
		}
		
		System.out.println("You: " + this.m_user_score);
		System.out.println("Computer: " + this.m_my_score);
	}
	
	// return the result of comparison of two hand_type-s. -1 - lhs won, 0 - draw, 1 - rhs won
	private int check_winner(hand_type lhs, hand_type rhs)
	{
		if(lhs == rhs)
			return 0;
		
		if((lhs == hand_type.PAPER && rhs == hand_type.ROCK)
		 || (lhs == hand_type.ROCK && rhs == hand_type.SCISSORS)
		 || (lhs == hand_type.SCISSORS && rhs == hand_type.PAPER))
			return -1;
		
		return 1;
	}
	
	// get hand_type by id
	private hand_type get_hand_type(int id)
	{
		for(hand_type t : hand_type.values())
			if(id == t.id)
				return t;
		
		return hand_type.INVALID;
	}
	
	// get hand_type by name
	private hand_type get_hand_type(String str)
	{
		for(hand_type t : hand_type.values())
			if(str.equalsIgnoreCase(t.name))
				return t;
		
		return hand_type.INVALID;
	}
}