package telran.numbers;

public class TictactoeGame {
	/**
	 * 
	 * @param matrix square matrix (nRows == nCol; where nRows >=3)
	 * @param numRow
	 * @param numColumn
	 * @param symb ('x' or '0')
	 * @return 0 - game isn't over;
	 * 		   1 - game is over with the winner's move;
	 *		   2 - game is over with draw;
	 */
	public static int tictactoeMove(char matrix[][], int numRow, int numColumn, char symb) {
		int res = -1;	
		int length = matrix.length;	
		if (length == matrix[0].length && length >= 3) {
			if(numRow < length && numColumn < length && (symb == 'X' || symb == '0')) {
				matrix[numRow][numColumn] = symb;
				boolean isElementsEqual = false;	
				boolean hasEmptyElements = false;
				int countEmptyElements = 0;				
				//isRowFull
				for(int i = 0; i < length; i++) {
					for (int j = 1; j < length; j++) {
						if(matrix[0][0] == matrix[i][j]) {
							isElementsEqual =  true;
						} else {
							isElementsEqual =  false;
							break;
						}
					}
					if(isElementsEqual)  {
						return res = 1;
					}
				}
				//isColumnFull
				for(int j = 0; j < length; j++) {
					for(int i = 1; i < length; i++) {
						if(matrix[0][j] == matrix [i][j]) {
							isElementsEqual =  true;
						} else {
							isElementsEqual =  false;
							break;
						}
					}
					if(isElementsEqual)  {
						return res = 1;
					}
				}
				//isDiagonalsFull				
				for(int i = 1; i < length; i++) {
					if(matrix[0][0] == matrix[i][i]) {
						isElementsEqual =  true;
					} else {
						isElementsEqual =  false;
						break;
					}
				}
				if(!isElementsEqual)  {
					for(int i = length - 2, j = 1; i > 0; i--, j++) {
						if(matrix[length - 1][0] == matrix[i][j]) {
							isElementsEqual =  true;
						} else {
							isElementsEqual =  false;
							break;
						}					
					}
				} else {
					return res = 1;
				}				
				//hasEmptyElements
				for(int i = 0; i < length; i++) {
					countEmptyElements += ArrayInt.indexOf(matrix[i], '\0') > 0 ? 1 : 0;
				}
				hasEmptyElements = countEmptyElements > 0 ? true : false; 
				res = isElementsEqual ? 1 : hasEmptyElements ? 0 : 2;
			}			
		}
		return res;
	}
}
