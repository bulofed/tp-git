import java.util.ArrayList;

public class Tour extends Piece {
    public Tour(char couleur, Position position) {
        super("Tour", couleur, position);
    }

    public Tour() {
        super("Tour", 'B', new Position("A1"));
    }

    public String getType() {
        return "tour";
    }

    public ArrayList<Position> getDeplacementsPossible(Plateau plateau) {
        ArrayList<Position> deplacements = new ArrayList<Position>();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int i = 1;
        while (x + i < 8 && plateau.getCase(x + i, y) == null) {
            deplacements.add(new Position(x + i, y));
            i++;
        }
        if (x + i < 8 && plateau.getCase(x + i, y).getCouleur() != this.getCouleur()) {
            deplacements.add(new Position(x + i, y));
        }
        i = 1;
        while (x - i >= 0 && plateau.getCase(x - i, y) == null) {
            deplacements.add(new Position(x - i, y));
            i++;
        }
        if (x - i >= 0 && plateau.getCase(x - i, y).getCouleur() != this.getCouleur()) {
            deplacements.add(new Position(x - i, y));
        }
        i = 1;
        while (y + i < 8 && plateau.getCase(x, y + i) == null) {
            deplacements.add(new Position(x, y + i));
            i++;
        }
        if (y + i < 8 && plateau.getCase(x, y + i).getCouleur() != this.getCouleur()) {
            deplacements.add(new Position(x, y + i));
        }
        i = 1;
        while (y - i >= 0 && plateau.getCase(x, y - i) == null) {
            deplacements.add(new Position(x, y - i));
            i++;
        }
        if (y - i >= 0 && plateau.getCase(x, y - i).getCouleur() != this.getCouleur()) {
            deplacements.add(new Position(x, y - i));
        }
        
        return deplacements;
    }
}
