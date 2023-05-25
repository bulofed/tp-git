import java.util.ArrayList;

public abstract class Pion extends Piece {
    public Pion(char couleur, Position position) {
        super("Pion", couleur, position);
    }

    public Pion() {
        super("Pion", 'B', new Position("A1"));
    }

    public String getType() {
        return "pion";
    }

    public abstract ArrayList<Position> getDeplacementsPossible(Plateau plateau);
}