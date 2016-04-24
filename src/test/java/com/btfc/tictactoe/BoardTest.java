package com.btfc.test;
import com.btfc.tictactoe.Board;
import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest
{
    @Test
    public void testSizeOfBoard()
    {
        Board board = new Board();
        assertEquals(9, board.getField().length * board.getField()[0].length);
    }
    @Test
    public void testDimensions()
    {
        Board board = new Board();
        assertEquals(3, (board.getYDimension()));
    }

    @Test
    public void testInitializeField() throws Exception
    {
        Board board = new Board();
        int[][] boardField = new int[board.getXDimension()][board.getYDimension()];
        int[][] nonEmptyField = new int[board.getXDimension()][board.getYDimension()];
        //NOTE: This is dirty but inserting the same filling algorithm here seems dum                  
        int[][] emptyField = {{32, 32, 32}, {32, 32, 32}, {32, 32, 32}};
        //insert a couple of random characters into random positions in the array                      
        for(int i = 0; i < 10; i++)
	    {
		nonEmptyField[(int)(Math.random()*board.getXDimension())][(int)(Math.random()*board.getXDimension())] = (int)(Math.random() * 256);
	    }
        //set the board field as the non-zero field, then zero it out and assert that it's actually empty                                                                                                 
        board.setField(nonEmptyField);
        board.initializeField();
        boardField = board.getField();
        for(int i = 0; i < board.getYDimension(); i++)
	    {
		assertArrayEquals(emptyField[i], boardField[i]);
	    }
    }

   
}