//This is the console interface class expected to be replaced later with web gui
package com.btfc.tictactoe;

public class Interface 
{
    public void  printMenu()
    {
     System.out.print("Welcome to Tic Tac Toe\n");
     System.out.print("----------------------\n");
     System.out.print("1. For new game\n");
     System.out.print("2. To exit game\n");
     System.out.print("----------------------\n");
    }

}


/*

	System.out.println("Enter the x, y coordinates you want move to");
	x = (System.in.read() - 48);
	//clear out the comma and space
	System.in.read();
	System.in.read();
	y = (System.in.read() - 48);
	//remove trailing newline character
	System.in.read();
	System.out.println(x + ", " + y);


	
     System.out.println("Welcome to Tic Tac Toe");
     System.out.println("----------------------");
     System.out.println("1. For new game ");
     System.out.println("2. To exit game ");
     System.out.println("----------------------");
*/




