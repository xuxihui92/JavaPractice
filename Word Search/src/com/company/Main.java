package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // the input string should be capital letters
        Scanner reader = new Scanner(System.in);
        String word = reader.nextLine();

        // initial board array
        char[][] board = new char[3][4];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};

        boolean result = exist(board, word);
        System.out.println(result);
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int ind, int rowInd, int colInd, boolean[][] visited) {
        if (ind == word.length()) {
            return true;
        }
        if (rowInd < 0 || colInd < 0 || rowInd >= board.length || colInd >= board[0].length) {
            return false;
        }
        if (visited[rowInd][colInd]) {
            return false;
        }
        if (board[rowInd][colInd] != word.charAt(ind)) {
            return false;
        }
        visited[rowInd][colInd] = true;
        boolean res = dfs(board, word, ind + 1, rowInd - 1, colInd, visited)
                || dfs(board, word, ind + 1, rowInd + 1, colInd, visited)
                || dfs(board, word, ind + 1, rowInd, colInd - 1, visited)
                || dfs(board, word, ind + 1, rowInd, colInd + 1, visited);
        visited[rowInd][colInd] = false;
        return res;
    }
}
