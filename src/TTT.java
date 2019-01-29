public class TTT extends Game {

    public TTT(Player p1, Player p2, Board b){
        super(p1, p2, b);
    }

    @Override
    public void run() {
        System.out.println("HI");
        while (true){
            System.out.println(board);
            move();
        }
    }
}
