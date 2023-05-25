import java.util.ArrayList;

public class Fou extends Piece {
    public Fou(char couleur, Position position) {
        super("Fou", couleur, position);
    }

    public Fou() {
        super("Fou", 'B', new Position("A1"));
    }

    public String getType() {
        return "fou";
    }

    public ArrayList<Position> getDeplacementsPossible(Plateau plateau) {
        ArrayList<Position> deplacements = new ArrayList<Position>();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        for (int i = 1; i < 8; i++) {
            if (x + i < 8 && y + i < 8 && (plateau.getCase(x + i, y + i) == null || plateau.getCase(x + i, y + i).getCouleur() != this.getCouleur())) {
                deplacements.add(new Position(x + i, y + i));
            }
            else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x - i >= 0 && y - i >= 0 && (plateau.getCase(x - i, y - i) == null || plateau.getCase(x - i, y - i).getCouleur() != this.getCouleur())) {
                deplacements.add(new Position(x - i, y - i));
            }
            else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x + i < 8 && y - i >= 0 && (plateau.getCase(x + i, y - i) == null || plateau.getCase(x + i, y - i).getCouleur() != this.getCouleur())) {
                deplacements.add(new Position(x + i, y - i));
            }
            else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x - i >= 0 && y + i < 8 && (plateau.getCase(x - i, y + i) == null || plateau.getCase(x - i, y + i).getCouleur() != this.getCouleur())) {
                deplacements.add(new Position(x - i, y + i));
            }
            else {
                break;
            }
        }
        return deplacements;
    }
}
