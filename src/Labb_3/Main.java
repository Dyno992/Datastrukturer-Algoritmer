package Labb_3;

public class Main {

    private static void print(int[][] board){
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(board[x][y] + " ");

            }
            System.out.println();

        }

    }

    private static boolean possible(int[][] board, int x, int y, int value){
        //kontrollera rad och kolumn
        for(int i = 0; i < 9; i++){
            if(board[y][i] == value || board[i][x] == value){
                return false;
            }
        }
        //kontrollera rutan
        int x0 = (x/3) * 3;
        int y0 = (y/3) * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (board[y0+i][x0+j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    private static void solve(int[][] board){
        for(int i= 0; i < 9; i++) {
            for (int j= 0; j < 9; j++){
                if (board [i][j] == 0){
                    for(int k= 1; k < 10; k++){
                        if (possible(board, i, j, k)){
                            board [i][j] = k;
                            solve(board);
                            board[i][j] = 0;

                        }
                    }
                }print(board);
            }
        }


        //Loopa igenom alla rader och kolumner
        //  Kolla om det är en nolla på aktuell pos
        //      Loopa igenom alla värden från 1 till 9
        //          Kolla om man kan placera aktuellt värd på aktuell position
        //              Om ja, placera aktuellt värde
        //                  anropa solve
        //                      Ta bort aktuellt värde
        //      Gör return
        // Skriv ut lösning
    }

    public static void main(String[] args) {
        int [][] board = {{0, 0, 0, 8, 0, 4, 9, 3, 7},
                          {0, 7, 4, 1, 0, 0, 0, 8, 0},
                          {8, 3, 2, 0, 0, 0, 4, 0, 0},
                          {2, 0, 5, 3, 0, 0, 7, 4, 0},
                          {0, 0, 0, 0, 0, 0, 0, 1, 6},
                          {1, 4, 3, 0, 0, 0, 2, 0, 0},
                          {0, 0, 7, 0, 9, 0, 6, 0, 0},
                          {0, 2, 1, 7, 5, 6, 8, 9, 0},
                          {6, 5, 9, 2, 3, 0, 0, 7, 4}};


        solve(board);




        //System.out.println(board [0][0]);







        /*System.out.println("Should be " + possible(board, 4, 4, 2));
        System.out.println("Should be " + possible(board, 4, 4, 1));
        System.out.println("Should be " + possible(board, 5, 6, 3));
        System.out.println("Should be " + possible(board, 0, 0, 5));*/
    }
}