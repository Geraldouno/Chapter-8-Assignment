
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    
    // Enum to represent the possible values in each cell of the board
    enum Player {X, O, EMPTY}

    // Board is a 3x3 array initialized to EMPTY
    private Player[][] board = new Player[3][3];
    private Player currentPlayer;
    
    // Constructor to initialize the game board
    public TicTacToe() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = Player.EMPTY;  // Set all cells to EMPTY
            }
        }
    }

    // Print the current board
    public void printBoard() {
        System.out.println();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] == Player.EMPTY ? "." : board[row][col]);
                if (col < 2) System.out.print("|");
            }
            System.out.println();
            if (row < 2) System.out.println("-----");
        }
        System.out.println();
    }

    // Set the current player
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    // Check if the current player has won
    public boolean checkWinner() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Check row
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Check column
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Check main diagonal
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Check anti-diagonal
        }
        return false;
    }

    // Check if the board is full (i.e., a draw)
    public boolean isDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == Player.EMPTY) {
                    return false;
                }
            }
        }
        return true; // The board is full, it's a draw
    }

    // Make a move for the current player
    public boolean makeMove(int row, int col) {
        if (board[row][col] == Player.EMPTY) {
            board[row][col] = currentPlayer;
            return true; // Move made successfully
        }
        return false; // Invalid move (cell already taken)
    }

    // Computer makes a random valid move (for one of the players)
    public void computerMove() {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (board[row][col] != Player.EMPTY); // Keep trying until we find an empty spot

        board[row][col] = currentPlayer; // Place the computer's move
    }

    // Start the game between two human players
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
        
        System.out.print("Who should go first? (1 for X, 2 for O): ");
        int firstPlayerChoice = scanner.nextInt();
        setCurrentPlayer(firstPlayerChoice == 1 ? Player.X : Player.O);

        printBoard();
        
        while (true) {
            int row, col;
            if (currentPlayer == Player.X) {
                System.out.println("Player X's turn.");
            } else {
                System.out.println("Player O's turn.");
            }

            if (currentPlayer == Player.X) { // Player X (Human)
                System.out.print("Enter row (0, 1, or 2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0, 1, or 2): ");
                col = scanner.nextInt();
            } else { // Player O (Computer)
                computerMove();
                printBoard();
                if (checkWinner()) {
                    System.out.println("Player O wins!");
                    break;
                }
                if (isDraw()) {
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = Player.X; 
                continue;
            }

            if (makeMove(row, col)) {
                printBoard();

                if (checkWinner()) {
                    System.out.println(currentPlayer + " wins!");
                    break;
                }
                if (isDraw()) {
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X; // Switch players
            } else {
                System.out.println("That cell is already taken. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
