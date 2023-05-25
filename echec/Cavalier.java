import java.util.ArrayList;

public class Cavalier extends Piece {
    public Cavalier(char couleur, Position position) {
        super("Cavalier", couleur, position);
    }

    public Cavalier() {
        super("Cavalier", 'B', new Position("A1"));
    }

    public String getType() {
        return "cavalier";
    }

    public ArrayList<Position> getDeplacementsPossible(Plateau plateau) {
        ArrayList<Position> deplacements = new ArrayList<Position>();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        if (x + 2 < 8 && y + 1 < 8 && (plateau.getCase(x + 2, y + 1) == null || plateau.getCase(x + 2, y + 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x + 2, y + 1));
        }
        if (x + 2 < 8 && y - 1 >= 0 && (plateau.getCase(x + 2, y - 1) == null || plateau.getCase(x + 2, y - 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x + 2, y - 1));
        }
        if (x - 2 >= 0 && y + 1 < 8 && (plateau.getCase(x - 2, y + 1) == null || plateau.getCase(x - 2, y + 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x - 2, y + 1));
        }
        if (x - 2 >= 0 && y - 1 >= 0 && (plateau.getCase(x - 2, y - 1) == null || plateau.getCase(x - 2, y - 1).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x - 2, y - 1));
        }
        if (x + 1 < 8 && y + 2 < 8 && (plateau.getCase(x + 1, y + 2) == null || plateau.getCase(x + 1, y + 2).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x + 1, y + 2));
        }
        if (x + 1 < 8 && y - 2 >= 0 && (plateau.getCase(x + 1, y - 2) == null || plateau.getCase(x + 1, y - 2).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x + 1, y - 2));
        }
        if (x - 1 >= 0 && y + 2 < 8 && (plateau.getCase(x - 1, y + 2) == null || plateau.getCase(x - 1, y + 2).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x - 1, y + 2));
        }
        if (x - 1 >= 0 && y - 2 >= 0 && (plateau.getCase(x - 1, y - 2) == null || plateau.getCase(x - 1, y - 2).getCouleur() != this.getCouleur())) {
            deplacements.add(new Position(x - 1, y - 2));
        }
        return deplacements;
    }
}
