package com.wwx16265;

public class App {
    public static void main(String[] args) {
        game_menu menu = new game_menu();
        
        try
        {
        	menu.run();
        }
        catch(Exception e)
        {
        	System.out.println("The game has encountered an unresolvable problem: " + e.getMessage());
        }
    }   
}
