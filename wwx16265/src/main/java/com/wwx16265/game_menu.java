package com.wwx16265;

import java.io.IOException;
import java.util.Scanner;

// A menu class, which is responsible for displaying the menu, processing the users input and acts as a driver for the games. 
public class game_menu 
{
	game_base m_game;
	
	
	// run the application
	public void run()
	{
		while(this.process_menu()) {}
	}
	
	// prints the options menu
	private void print_menu()
	{
		System.out.println("0 - Exit");
		System.out.println("1 - Paper, Rock, Scissors");
		System.out.println("2 - Guess the number");
	}
	
	// would clear the screen if I was able to make it in Java. It does not work due to the specifics of this programming language, which I do not understand.
	private void cls()
	{
	    
	}
	
	// prints the game name and description. Also prints the prompt on how to quit the game.
	private void print_game_info()
	{
		System.out.println(this.m_game.get_name());
		System.out.println(this.m_game.get_description());
		System.out.println("Write \"exit\" to return to the main menu");
	}
	
	// if the game is chosen, it will wait for the user to provide input. Is responsible to drive the game's loop.
	private void process_game()
	{
		if(this.m_game == null)
			return;

		this.print_game_info();
		
		Scanner console = new Scanner(System.in);
		while(true)
		{
			String str = console.nextLine();
			
			if(str.equalsIgnoreCase("exit"))
			{
				break;
			}
			
			this.cls();
			this.print_game_info();
			this.m_game.update(str);
		}
	}
	
	// processes the menu 
	private boolean process_menu()
	{
		Scanner console = new Scanner(System.in);
		
		while(true)
		{
			this.cls();
			
			this.print_menu();
			
			int option = console.nextInt();
			
			switch(option)
			{
			case 0:
				System.out.println("Thanks for playing! GG! Goodbye!");
				return false;
			case 1:
				this.m_game = new prs();
				break;
			case 2: 
				this.m_game = new guess_number();
				break;
			default:
				return true;
			}
			
			this.process_game();
			
			return true;
		}
	}
}