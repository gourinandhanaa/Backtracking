/*
 Given a square chessboard of N x N size, the starting position of Knight and target position is given. We need to find out minimum steps a Knight will take to reach the target position. Knight moves in a L pattern - check the internet for how a knight moves on a chess board

Sample Input

1
1
8
8
Sample Output
6

HINT: In chess, a knight can come to the same position through multiple ways - so this code could easily lead to infinite loops. You have to save the history of positions visited and check if the new position is unique. */

import java.util.*;

public class Demo {
    static int[][] mat;
    static int n = 8;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        int r = sc.nextInt() - 1;
        int s = sc.nextInt() - 1;

        mat= new int[n][n];
        for (int[] i : mat) Arrays.fill(i, Integer.MAX_VALUE);

        solve(u, v, r, s, 0);
        System.out.println(min);
    }

    public static void solve(int x, int y, int tX, int tY, int steps) {
        if (x < 0 || y < 0 || x >= n || y >= n || steps >= mat[x][y] || steps >= min) {
            return;
        }

        mat[x][y] = steps;

        if (x == tX && y == tY) {
            min = Math.min(min, steps);
            return;
        }

        for (int i = 0; i < 8; i++) {
            solve(x + dx[i], y + dy[i], tX, tY, steps + 1);
        }
    }
}
