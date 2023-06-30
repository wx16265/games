package com.wwx16265;

//base class for the games. 
public class game_base {
	private String m_name;
	private String m_description;
	protected int m_my_score;
	protected int m_user_score;
	
	// default constructor
	public game_base()
	{
		this.m_name = "No game selected";
	}
	
	// constructor with parameters
	public game_base(String name, String description)
	{
		this.m_name = name;
		this.m_description = description;
	}

	// returns the game's name
	public String get_name()
	{
		return this.m_name;
	}
	
	// returns the game's description
	public String get_description()
	{
		return this.m_description;
	}
	
	// abstract method. represents game's single iteration
	public void update(String input)
	{
	}
}