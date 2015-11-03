package com.btfc.tictactoe;

import com.btfc.tictactoe.*;
import java.awt.Point;



public class TicTacLogic{
    HumanPlayer player1;
    HumanPlayer player2;
    public Board board;
    int counter;
    boolean isGameOver;

    public TicTacLogic()
    {
	board = new Board();
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();
	counter = 0;
	newGame();
    }

    public int getSymbol(int x, int y)
    {
        return board.getSymbol(x, y); 
    }

    //returns the result of the action as a string
    //returns a empty string upon success
    public String makeMove(int x, int y)
    {
        int symbol;
	//Take no action if the game is over
	if(isGameOver)
	{
	    return "Game is over";
	}
        //Check which players turn it is
        if(counter % 2 == 0)
	{
	    symbol = 1; 
	}
	else
	{
            symbol = 2;	
	}
	counter++;
	//Check if the selected field is empty
        if(board.getSymbol(x, y) == ' ')
	{
            board.setSymbol(x, y, symbol);
	    //check if someone has won the game
	    if(isGameWon())
	    {
	        isGameOver = true;
	        return "winner!";
	    }
	    //check if the game is drawn
	    if(counter == 9)
	    {
	        isGameOver = true;
	        return "draw"; 
	    }
	    return "";
	}
	//the selected filed was not empty
	else
	{
	    counter--;
            return "Invalid move";	
	}
    }
    
    public void newGame()
    {
        board.initializeField();
	isGameOver = false;
    }

    /*
    public void playRound()
    {
        board.initializeField();
        Point move;
        int symbol = 0;
        //make moves while the field is not full or either player won                                  
        for(int i = 0; i < board.XDIMENSION * board.YDIMENSION; i++)
	{
		while(true)
		{
		    this.printField();
		    //let the players make their move                                                      
		    if(i % 2 == 0)
		    {
			move = player1.makeMove();
			symbol = board.X;
		    }
		    else
		    {
			move = player2.makeMove();
			symbol = board.O;
		    }
		    //check if the move is within the bounds of our array  
		    if(move.x >= board.XDIMENSION || move.x < 0 || move.y >= board.YDIMENSION || move.y < 0 )
		    {
			//tService.invalidMove();
			continue;
		    }
		    //check if the chosen field is empty                                                   
		    else if(board.getField()[move.x][move.y] == board.EMPTY)
		    {
			board.setSymbol(move,symbol);
			break;
		    }
		    else //if it's not, let the same player choose again                                   
		    {
			//tService.invalidMove();
			continue;
		    }
		}

		if(isGameWon())
		{
		    this.printField();
		    if(symbol == board.X)
		    {
			
		//	tService.playerWins(this.player1.getName());
			return;
		    }
		    else
		   {
		       
		  //     tService.playerWins(this.player2.getName());
		       return;
	    	  }
	        }
        }
    }
    */

    public boolean isGameWon()
    {
       //check the diagonal lines                                                                     
       if(board.getField()[0][0] == board.getField()[1][1] && board.getField()[1][1] == board.getField()[2][2] && board.getField()[0][0] == board.getField()[2][2] && board.getField()[0][0] != board.EMPTY)
       {
	   return true;
       }
       if(board.getField()[0][2] == board.getField()[1][1] && board.getField()[1][1] == board.getField()[2][0] && board.getField()[0][2] == board.getField()[2][0] && board.getField()[1][1] != board.EMPTY)
       {
	   return true;
       }
       //check the horizontal and vertical lines                                                      
       for(int i = 0; i < board.XDIMENSION; i++)
       {
	   if(board.getField()[0][i] == board.getField()[1][i] && board.getField()[0][i] == board.getField()[2][i] && board.getField()[2][i] == board.getField()[1][i]  && board.getField()[0][i] != board.EMPTY)
	   {
	       return true;
	   }
	   if(board.getField()[i][0] == board.getField()[i][1] && board.getField()[i][0] == board.getField()[i][2] && board.getField()[i][2] == board.getField()[i][1]  && board.getField()[i][0] != board.EMPTY)
	   {
	       return true;
	   }
       }
       return false;
   }
}
