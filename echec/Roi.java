import java.util.ArrayList;

public class Roi extends Piece {
    public Roi(char couleur, Position position) {
        super("Roi", couleur, position);
    }

    public Roi() {
        super("Roi", 'B', new Position("A1"));
    }

    public String getType() {
        return "roi";
    }

    public ArrayList<Position> getDeplacementsPossible(Plateau plateau) {
        ArrayList<Position> deplacements = new ArrayList<Position>();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        if (x + 1 < 8 && (plateau.getCase(x + 1, y) == null || plateau.getCase(x + 1, y).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x + 1, y));
        }
        if (x - 1 >= 0 && (plateau.getCase(x - 1, y) == null || plateau.getCase(x - 1, y).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x - 1, y));
        }
        if (y + 1 < 8 && (plateau.getCase(x, y + 1) == null || plateau.getCase(x, y + 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x, y + 1));
        }
        if (y - 1 >= 0 && (plateau.getCase(x, y - 1) == null || plateau.getCase(x, y - 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x, y - 1));
        }
        if (x + 1 < 8 && y + 1 < 8 && (plateau.getCase(x + 1, y + 1) == null || plateau.getCase(x + 1, y + 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x + 1, y + 1));
        }
        if (x + 1 < 8 && y - 1 >= 0 && (plateau.getCase(x + 1, y - 1) == null || plateau.getCase(x + 1, y - 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x + 1, y - 1));
        }
        if (x - 1 >= 0 && y + 1 < 8 && (plateau.getCase(x - 1, y + 1) == null || plateau.getCase(x - 1, y + 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x - 1, y + 1));
        }
        if (x - 1 >= 0 && y - 1 >= 0 && (plateau.getCase(x - 1, y - 1) == null || plateau.getCase(x - 1, y - 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x - 1, y - 1));
        }

        // Roc
        if (this.getNbDeplacement() == 0) {
            if (plateau.getCase(x + 1, y) == null && plateau.getCase(x + 2, y) == null && plateau.getCase(x + 3, y) != null && plateau.getCase(x + 3, y).getNbDeplacement() == 0) {
                deplacements.add(new Position(x + 2, y));
            }
            if (plateau.getCase(x - 1, y) == null && plateau.getCase(x - 2, y) == null && plateau.getCase(x - 3, y) == null && plateau.getCase(x - 4, y) != null && plateau.getCase(x - 4, y).getNbDeplacement() == 0) {
                deplacements.add(new Position(x - 2, y));
            }
        }
        return deplacements;
    }
}

