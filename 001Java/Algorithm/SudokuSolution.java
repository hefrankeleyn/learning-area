import java.util.Set;
import java.util.HashSet;
/**
 *验证一个数独版是是否有效
 *思路：
 * 1、验证每一行是否有效；
 * 2、验证每一列是否有效；
 * 3、验证每一个3*3的子格是否有效；
 */
class SudokuSolution{
	public static void main(String[] args){
		String[][] board ={{"5","3",".",".","7",".",".",".","."},
						 {"6",".",".","1","9","5",".",".","."},
						 {".","9","8",".",".",".",".","6","."},
						 {"8",".",".",".","6",".",".",".","3"},
						 {"4",".",".","8",".","3",".",".","1"},
						 {"7",".",".",".","2",".",".",".","6"},
						 {".","6",".",".",".",".","2","8","."},
						 {".",".",".","4","1","9",".",".","5"},
						 {".",".",".",".","8",".",".","7","9"}
						};
        boolean rowAndcolBoolean = rowAndColValid(board);
        boolean subBoolean = subSudokuValid(board);
        if(rowAndcolBoolean && subBoolean){
            System.out.println(false);
        }else{
            System.out.println(true);
        }
	}
	//验证每一行和每一列是否有效
	private static boolean rowAndColValid(String[][] board){
		//将数字取出放到Set集合中，对‘.’进行计数fullStopCount
		// 比较 set.size() + fullStopCount == 9
		// 将上面的比较结果作为返回值
		for(int i=0;i<board.length;i++){
			Set<Integer> setNumRow = new HashSet<Integer>();
			Set<Integer> setNumCol = new HashSet<Integer>();
			int fullStopCountRow = 0;
			int fullStopCountCol = 0;
			for(int j=0;j<board[i].length;j++){
				if (".".equals(board[i][j]+"")){
					fullStopCountRow ++;
				}else {
					setNumRow.add(Integer.parseInt(board[i][j]+""));
				}
				if (".".equals(board[j][i]+"")){
					fullStopCountCol ++;
				}else {
					setNumCol.add(Integer.parseInt(board[j][i]+""));
				}
			}
			boolean rowBoolean = (setNumRow.size() + fullStopCountRow) != board.length;
			boolean colBoolean = (setNumCol.size() + fullStopCountCol) != board.length;
			if(rowBoolean || colBoolean){
				return false;
			}
		}
		return true;
	}
	// 验证每一个3*3 的子格是否正常
	private static boolean subSudokuValid(String[][] board){
		for(int x=0, stepLength = 3; x<board.length; x+=stepLength){
			for(int y=0; y<board.length; y+=stepLength){
				Set<Integer> setNumSub = new HashSet<Integer>();
				int fullStopCountSub = 0;
				int stepLengthX = x + stepLength;
				int stepLengthY = y + stepLength;
				for(int i=x; i<stepLengthX; i++){
					for(int j=y; j<stepLengthY; j++){
						//System.out.println("x,y:"+x+y+"; X,Y:"+stepLengthX+stepLengthY+"; i,j"+i+j);
						if (".".equals(board[i][j]+"")){
							fullStopCountSub ++;
						}else {
							setNumSub.add(Integer.parseInt(board[i][j]+""));
						}
					}
				}
				boolean subBoolean = (setNumSub.size() + fullStopCountSub) != board.length;
				if(subBoolean){
					return false;
				}
			}
		}
		return true;
	}
}