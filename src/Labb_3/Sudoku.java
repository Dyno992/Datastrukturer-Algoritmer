package Labb_3;

public class Sudoku {
    int[][] board = {{0, 0, 0, 8, 0, 4, 9, 3, 7},
            {0, 7, 4, 1, 0, 0, 0, 8, 0},
            {8, 3, 2, 0, 0, 0, 4, 0, 0},
            {2, 0, 5, 3, 0, 0, 7, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 6},
            {1, 4, 3, 0, 0, 0, 2, 0, 0},
            {0, 0, 7, 0, 9, 0, 6, 0, 0},
            {0, 2, 1, 7, 5, 6, 8, 9, 0},
            {6, 5, 9, 2, 3, 0, 0, 7, 4}};

    public Sudoku() {
        startSudoku();
    }

    private void startSudoku() {
        if (solve(board)) {
            System.out.println("Sudoku solved....");
            print();
        } else {
            System.out.println("Sudoku unsloved....");
        }
    }

    private void print() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
    }

    private boolean possible(int x, int y, int value) {
        //kontrollera rad och kolumn
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == value || board[i][y] == value) {
                return false;
            }
        }
        //Kontrollerar att indexpositionens ruta (3*3) är komplett
        int x0 = x - x % 3;
        int y0 = y - y % 3;
        for (int i = x0; i < x0 + 3; i++) {
            for (int j = y0; j < y0 + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solve(int[][] board) {
        for (int i = 0; i < 9; i++) { // Loopar fram vilken array
            for (int j = 0; j < 9; j++) { // Loopar fram vilket arrayindex
                if (board[i][j] == 0) { // Kontrollerar att positionen är tom
                    for (int value = 1; value < 10; value++) { // Loopar fram olika värden att testa
                        if (possible(i, j, value)) { // Returnerar true eller false om givet värde går att sätta
                            board[i][j] = value; // Sätter värdet
                            if (solve(board)) { // Rekursion (kallar på egna metoden)
                                return true;
                            } else {
                                board[i][j] = 0; // Om det inte går att lösa Sudoku återställs alla värden
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Sudoku();
    }
}