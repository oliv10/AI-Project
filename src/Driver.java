import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("1. Tic-Tac-Toe (Human vs Human)\n" +
                "2. Tic-Tac-Toe (Human vs Beginner AI)\n" +
                "3. Tic-Tac-Toe (Human vs Pro AI)\n" +
                "4. Connect 4 (Human vs Human)\n" +
                "5. Connect 4 (Human vs Beginner AI)\n" +
                "6. Connect 4 (Human vs Pro AI)\n" +
                "Select your game (1-6): ");
        int game = in.nextInt();

        System.out.println("You picked: " + game);

    }
}
