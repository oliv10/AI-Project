public class C4 extends Game {

    public C4(Player p1, Player p2, Board b){
        super(p1, p2, b);
    }

    @Override
    public void run() {
        while (true){
            if (board.isGameOver()){
                break;
            }
            System.out.print(board);
            move();
            System.out.println("\n");
        }

        System.out.print(board);

        if (board.isWinner("Y")){
            System.out.println("Player Y Wins");
        }
        else if (board.isWinner("R")){
            System.out.println("Player R Wins");
        }
        else{
            System.out.println("Nobody Wins");
        }
    }
}
