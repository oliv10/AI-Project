public class TTT extends Game {

    public TTT(Player p1, Player p2, Board b){
        super(p1, p2, b);
    }

    @Override
    public void run() {
        System.out.println("HI");
        while (true){
            if (board.isGameOver()){
                break;
            }
            System.out.println(board);
            move();
        }

        System.out.println(board);

        if (board.isWinner("X")){
            System.out.println("Player X Wins");
        }
        else if (board.isWinner("O")){
            System.out.println("Player O Wins");
        }
        else{
            System.out.println("Nobody Wins");
        }
    }
}
