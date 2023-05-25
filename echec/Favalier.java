import java.util.ArrayList;

public class Favalier extends Piece{

    public Favalier(char couleur, Position position) {
        super("Favalier", couleur, position);
    }

    public Favalier() {
        super("Favalier", 'B', new Position("A1"));
    }

    public String getType() {
        return "favalier";
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