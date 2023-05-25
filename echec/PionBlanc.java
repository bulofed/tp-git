import java.util.ArrayList;

public class PionBlanc extends Pion {
    public PionBlanc() {
        super('B', new Position("A1"));
    }

    public PionBlanc(Position position) {
        super('B', position);
    }

    public ArrayList<Position> getDeplacementsPossible(Plateau plateau) {
        ArrayList<Position> deplacements = new ArrayList<Position>();
        int y = this.getPosition().getY();
        int x = this.getPosition().getX();

        // Déplacement normal
        if (plateau.getCase(x, y + 1) == null) {
            deplacements.add(new Position(x, y + 1));
        }

        // Déplacement de 2 cases
        if (y == 1 && plateau.getCase(x, y + 2) == null){
            deplacements.add(new Position(x, y + 2));
        }

        // Prise en diagonale
        if (plateau.getCase(x - 1, y + 1) != null && plateau.getCase(x - 1, y + 1).getCouleur() == 'N') {
            deplacements.add(new Position(x - 1, y + 1));
        }

        if (plateau.getCase(x + 1, y + 1) != null && plateau.getCase(x + 1, y + 1).getCouleur() == 'N') {
            deplacements.add(new Position(x + 1, y + 1));
        }

        // En passant
        if (plateau.getCase(x - 1, y) != null && plateau.getCase(x - 1, y).getCouleur() == 'N' && plateau.getCase(x - 1, y) instanceof PionNoir && ((PionNoir) plateau.getCase(x - 1, y)).getEnPassant()) {
            deplacements.add(new Position(x - 1, y + 1));
        }
        
        return deplacements;
    }
}