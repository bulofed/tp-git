import java.util.ArrayList;

public class PionNoir extends Pion {
    private boolean enPassant = false;
    public PionNoir() {
        super('N', new Position("A8"));
    }

    public PionNoir(Position position) {
        super('N', position);
    }

    public ArrayList<Position> getDeplacementsPossible(Plateau plateau) {
        ArrayList<Position> deplacements = new ArrayList<Position>();
        int y = this.getPosition().getY();
        int x = this.getPosition().getX();

        // Une case en avant
        if (plateau.getCase(x, y - 1) == null) {
            deplacements.add(new Position(x, y - 1));
        }

        // Deux cases en avant si première case
        if (y == 6 && plateau.getCase(x, y - 2) == null){
            deplacements.add(new Position(x, y - 2));
        }

        // Prise en diagonale
        if (plateau.getCase(x - 1, y - 1) != null && plateau.getCase(x - 1, y - 1).getCouleur() == 'B') {
            deplacements.add(new Position(x - 1, y - 1));
        }

        if (plateau.getCase(x + 1, y - 1) != null && plateau.getCase(x + 1, y - 1).getCouleur() == 'B') {
            deplacements.add(new Position(x + 1, y - 1));
        }
        
        return deplacements;
    }

    public boolean getEnPassant() {
        return this.enPassant;
    }

    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }
}