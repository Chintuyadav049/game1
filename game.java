import java.util.*;

public class game {
    static Scanner sc = new Scanner(System.in);
    static char ch[][] = new char[3][3];

    public static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ch[i][j] = ' ';
            }
        }
    }

    public static void board() {
        System.out.println("      0      1      2");
        for (int i = 0; i < 3; i++) {
            System.out.println("   +------+------+------+");
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print(i + "  |  " + ch[i][j] + "  ");
                } else {
                    System.out.print(" |  " + ch[i][j] + "  ");
                }
            }
            System.out.println(" |");
        }
        System.out.println("   +------+------+------+");
    }

    public static boolean mark(int r, int c, String s) {
        if (r < 0 || r > 2 || c < 0 || c > 2) {
            System.out.println("Invalid position! Use 0–2 only.");
            return false;
        }
        if (ch[r][c] != ' ') {
            System.out.println("Cell already occupied! Try again.");
            return false;
        }

        if (s.equals("p1")) {
            ch[r][c] = 'X';
        } else if (s.equals("p2")) {
            ch[r][c] = 'O';
        }
        return true;
    }

    public static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (ch[i][0] == symbol && ch[i][1] == symbol && ch[i][2] == symbol)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (ch[0][i] == symbol && ch[1][i] == symbol && ch[2][i] == symbol)
                return true;
        }

        if (ch[0][0] == symbol && ch[1][1] == symbol && ch[2][2] == symbol)
            return true;
        if (ch[0][2] == symbol && ch[1][1] == symbol && ch[2][0] == symbol)
            return true;

        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ch[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public static void player1(String p1) {
        boolean valid = false;
        while (!valid) {
            System.out.println(p1 + "'s turn (X): Enter row and column (0–2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();
            valid = mark(r, c, "p1");
        }
    }

    public static void player2(String p2) {
        boolean valid = false;
        while (!valid) {
            System.out.println(p2 + "'s turn (O): Enter row and column (0–2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();
            valid = mark(r, c, "p2");
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the player 1 name: ");
        String p1 = sc.next();
        System.out.print("Enter the player 2 name: ");
        String p2 = sc.next();

        initBoard();
        board();

        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0) {
                player1(p1);
                board();
                if (checkWin('X')) {
                    System.out.println(p1 + " wins the game!");
                    return;
                }
            } else {
                player2(p2);
                board();
                if (checkWin('O')) {
                    System.out.println(p2 + " wins the game!");
                    return;
                }
            }
            if (isBoardFull()) {
                System.out.println("It's a tie!");
                return;
            }
        }
    }
}
