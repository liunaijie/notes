import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独
 *
 * @author ：LiuNaiJie
 * @date ：2020-04-03
 */
public class T36 {

	public static boolean isValidSudoku(char[][] board) {
		if (board == null) {
			return false;
		}
		Set[] rows = new Set[9];
		Set[] cols = new Set[9];
		Set[] boxes = new Set[9];
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashSet<>(9);
			cols[i] = new HashSet<>(9);
			boxes[i] = new HashSet<>(9);
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c != '.') {
					if (rows[i].contains(c)) {
						return false;
					} else {
						rows[i].add(c);
					}
					if (cols[j].contains(c)) {
						return false;
					} else {
						cols[j].add(c);
					}
					int boxIndex = (i / 3) * 3 + j / 3;
					if (boxes[boxIndex].contains(c)) {
						return false;
					} else {
						boxes[boxIndex].add(c);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = {{'.', '8', '7', '6', '5', '4', '3', '2', '1'}, {'2', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '.', '.', '.', '.', '.', '.', '.'}, {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, {'5', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
		System.out.println(isValidSudoku(board));
	}

}
