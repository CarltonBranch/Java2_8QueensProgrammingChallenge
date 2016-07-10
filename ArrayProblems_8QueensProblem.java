/**
 * Program Name: ArrayProblems_8QueensProblem.java
 * Purpose: This code solves the classic "8 Queens" Problem - Tester code provided by Texas_University CS307 course file 	
 * Coder:  Carlton Branch, 0771107
 * Date: Jul 9, 2016
 */

public class ArrayProblems_8QueensProblem {
	
	/**
	 * Method Name: 	isQueenSafe
	 * Purpose: Call each predicate testing method to determine if the current Queen is safe from attack
	 * Accepts:		the 2d array representing the board and the coordinates of the current Queen being checked
	 * Returns: 	boolean
	 */
	public static boolean isQueenSafe( char[][] board , int startX , int startY ){
		if ( isQueenSafeVertical ( board , startX , startY ) )
			if ( isQueenSafeHorizontal(board , startX , startY ) )
				if ( isQueenSafeDiagonal(board , startX , startY ) )
					return true; //The queen is safe from attack by other queens
		
	 return false;  //The current queen is not safe from attack by other queens
	}
	
	/**
	 * Method Name: 	isQueenSafeVertical
	 * Purpose:		determine if current queen is safe from attack in the current column (vertical axis)
	 * Accepts:		the 2d array representing the board and the coordinates of the current Queen being checked
	 * Returns: 	true if safe, false if not safe
	 */
	public static boolean isQueenSafeVertical( char[][] board , int positionY , int positionX )
	{
		int count = 0;
		for ( int i = 0 ; i < board.length ; ++i )
			if ( board[ i ][ positionX ] == 'q' )
				count++;
		//if there are more than one queen in the column, the current queen is not safe from attack
		if ( 1 < count )
			return false;
		
		return true;
	}
	
	/**
	 * Method Name: 	isQueenSafeHorizontal
	 * Purpose:		determine if current queen is safe from attack in the current row (horizontal axis)
	 * Accepts:		the 2d array representing the board and the coordinates of the current Queen being checked
	 * Returns: 	true if safe, false if not safe
	 */
	
	public static boolean isQueenSafeHorizontal(char[][] board, int positionY, int positionX)
	{
		int count = 0;
		for ( int i = 0 ; i < board[ positionY ].length ; ++i )
			if ( board[ positionY ][ i ] == 'q' )
				count++;

		//if there are more than one queen in the row, the current queen is not safe from attack
		if ( 1 < count )
			return false;
	
		return true;
	}
	
	/**
	 * Method Name: 	isQueenSafeDiagonal
	 * Purpose:		determine if current queen is safe from attack on both sides diagonally 
	 * Accepts:		the 2d array representing the board and the coordinates of the current Queen being checked
	 * Returns: 	true if safe, false if not safe
	 */
	public static boolean isQueenSafeDiagonal( char[][] board , int rowStart , int colStart )
	{	
		//check flag used to determine the results of each directional test
		boolean flag = true;
		
		//SOUTH-EAST
		for ( int i = 1 ; i < board[0].length ; ++i )
			if ( rowStart + i < board.length && colStart + i < board[0].length )
				if ( board[ rowStart + i ][ colStart + i ] == 'q' )
					flag = false;
				
		//NORTH-EAST
		for ( int i = 1 ; i < board[0].length ; ++i )
			if ( 0 <= rowStart - i && colStart + i < board[0].length )
				if ( board[ rowStart - i ][ colStart + i ] == 'q')
					flag = false;
		
		//SOUTH-WEST
		for ( int i = 1 ; i < board[0].length ; ++i )
			if ( 0 <= colStart - i && rowStart + i < board.length)
				if ( board[ rowStart + i ][colStart - i ] == 'q')
					flag = false;
		
		//NORTH-WEST
		for ( int i = 1 ; i < board[0].length ; ++i )
			if ( 0 <= colStart - i && 0 <= rowStart-i )
				if (board[rowStart - i][colStart - i ] == 'q' )
					flag = false;
		
	return flag;
	}
	
	
	
	
    /**METHOD HEADER PROVIDED BY CS307 ASSIGNMENT .JAVA FILE
	 * Determine if the chess board represented by board is a safe set up.
	 * <p>pre: board != null, board.length > 0, board is a square matrix.
	 * (In other words all rows in board have board.length columns.),
	 * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
	 * represent open spaces.<br>
	 * <p>post: return true if the configuration of board is safe,
	 * that is no queen can attack any other queen on the board.
	 * false otherwise.
	 * the parameter <tt>board</tt> is not altered as a result of 
	 * this method.
	 * @param board the chessboard
	 * @return true if the configuration of board is safe,
	 * that is no queen can attack any other queen on the board.
	 * false otherwise.
	*/
	
	public static boolean queensAreSafe(char[][] board) {
		char[] validChars = {'q', '.'};
			
		for (int i = 0; i < board.length; ++i)
			for (int j= 0; j < board[i].length; ++j)
				if (board[i][j] == 'q')
					if (!isQueenSafe(board, i, j))
						return false;
		
		return true; //All the Queens on the board are safe
	}
	
	
	public static void main(String[] args){
		
		//TESTER CODE BELOW PROVIDED BY CS307 TEXAS UNIVERSITY ASSIGNMENT .JAVA FILE
		boolean expectedBool, actualBool;

		char[][] safe = { {'.', '.', '.'},
						  {'q', '.', '.'},
		                  {'.', '.', 'q'}};
		
		expectedBool = true;
		actualBool = queensAreSafe(safe);
		System.out.print("\nTest 5 expected value: " + expectedBool + ", actual value: " + actualBool);
		if ( expectedBool == actualBool )
			System.out.println(" passed test 5, queensAreSafe");
		else
			System.out.println(" failed test 5, queensAreSafe");
		
			    
		//test 6
		char[][] unsafe = { {'.', '.', '.', 'q'},
		                    {'.', '.', '.', '.'},
		                    {'.', '.', '.', '.'},
		                    {'q', '.', '.', '.'}};
	    expectedBool = false;
	   actualBool = queensAreSafe(unsafe);
	    System.out.print("\nTest 6 expected value: " + expectedBool + ", actual value: " + actualBool);
	    if ( expectedBool == actualBool )
			System.out.println(" passed test 8, queensAreSafe");
		else
			System.out.println(" failed test 8, queensAreSafe");
	
	}
}