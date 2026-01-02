package Day6;
// Medium

// According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

// Given the current state of the board, update the board to reflect its next state.

// Note that you do not need to return anything.

// Example 1:


// Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
// Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// Example 2:


// Input: board = [[1,1],[1,0]]
// Output: [[1,1],[1,1]]
 

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 25
// board[i][j] is 0 or 1.
import java.util.*;
class solution {
    public static void main(String[] args) {
        int[][] board1 = {
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        int[][] board2 = {
            {1,1},
            {1,0}
        };
        gameOfLife(board1);
        gameOfLife(board2);
        System.out.println(Arrays.deepToString(board1));
        System.out.println(Arrays.deepToString(board2));
    }

    // 8방향 탐색용
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = countLives(board, i, j, m, n);

                // 원본이 1(살아있음)일 때
                if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) board[i][j] = 2; // 2: 1->0(죽음 예정)
                } else {
                    // 원본이 0(죽어있음)일 때
                    if (lives == 3) board[i][j] = 3; // 3: 0->1(부활 예정)
                }
            }
        }

        // 상태 확정(2->0, 3->1)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                else if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    private static int countLives(int[][] board, int x, int y, int m, int n) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                // 1이거나 2(과거에 1이었던 것)를 카운트
                if (board[nx][ny] == 1 || board[nx][ny] == 2) count++;
            }
        }
        return count;
    }
}
