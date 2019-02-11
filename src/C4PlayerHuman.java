import java.util.Scanner;

public class C4PlayerHuman extends Player {

    private Scanner in = new Scanner(System.in);

    public C4PlayerHuman(String name){
        super(name);
    }

    @Override
    public String getMove(Board board) {
        System.out.print(name + ", Place your piece (1-7): ");
        return in.next();
    }
}