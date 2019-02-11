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

        if(game == 1){
            System.out.println("You picked: Human vs Human Tic Tac Toe");
            TTT newGame = new TTT(new TTTPlayerHuman("X"), new TTTPlayerHuman("O"), new TTTBoard());
            newGame.run();
        }
        else if(game == 2){
            System.out.println("You picked: Human vs Easy AI Tic Tac Toe");
            TTT newGame = new TTT(new TTTPlayerHuman("X"), new TTTPlayerEasyAI("O"), new TTTBoard());
            newGame.run();
        }
        else if(game == 3){
            System.out.println("You picked: Human vs Pro AI Tic Tac Toe");
            TTT newGame = new TTT(new TTTPlayerHuman("X"), new TTTPlayerProAI("O"), new TTTBoard());
            newGame.run();
        }
        else if(game == 4){
            System.out.println("You picked: Human vs Human Connect 4");
            //Board newGame = new ?(new C4PlayerHuman("Y"), new C4PlayerHuman("R"), new C4Board());
        }
        else if (game == 5){
            System.out.println("You picked: Human vs Easy AI Connect 4");
        }
        else if (game == 6){
            System.out.println("You picked: Human vs Hard AI Connect 4");
        }
    }
}
