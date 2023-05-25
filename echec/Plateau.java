import java.util.ArrayList;

public class Plateau {
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Plateau() {
        pieces.add(new Tour('B', new Position("A1")));
        pieces.add(new Cavalier('B', new Position("B1")));
        pieces.add(new Fou('B', new Position("C1")));
        pieces.add(new Dame('B', new Position("D1")));
        pieces.add(new Roi('B', new Position("E1")));
        pieces.add(new Fou('B', new Position("F1")));
        pieces.add(new Cavalier('B', new Position("G1")));
        pieces.add(new Tour('B', new Position("H1")));
        for (int i = 0; i < 8; i++) {
            pieces.add(new PionBlanc(new Position((char) ('A' + i) + "2")));
        }
        pieces.add(new Tour('N', new Position("A8")));
        pieces.add(new Cavalier('N', new Position("B8")));
        pieces.add(new Fou('N', new Position("C8")));
        pieces.add(new Dame('N', new Position("D8")));
        pieces.add(new Roi('N', new Position("E8")));
        pieces.add(new Fou('N', new Position("F8")));
        pieces.add(new Cavalier('N', new Position("G8")));
        pieces.add(new Tour('N', new Position("H8")));
        for (int i = 0; i < 8; i++) {
            pieces.add(new PionNoir(new Position((char) ('A' + i) + "7")));
        }
    }

    public Plateau(boolean cheat){
        if (cheat == false) {
            pieces.add(new Tour('B', new Position("A1")));
            pieces.add(new Cavalier('B', new Position("B1")));
            pieces.add(new Fou('B', new Position("C1")));
            pieces.add(new Dame('B', new Position("D1")));
            pieces.add(new Roi('B', new Position("E1")));
            pieces.add(new Fou('B', new Position("F1")));
            pieces.add(new Cavalier('B', new Position("G1")));
            pieces.add(new Tour('B', new Position("H1")));
            for (int i = 0; i < 8; i++) {
                pieces.add(new PionBlanc(new Position((char) ('A' + i) + "2")));
            }
            pieces.add(new Tour('N', new Position("A8")));
            pieces.add(new Cavalier('N', new Position("B8")));
            pieces.add(new Fou('N', new Position("C8")));
            pieces.add(new Dame('N', new Position("D8")));
            pieces.add(new Roi('N', new Position("E8")));
            pieces.add(new Fou('N', new Position("F8")));
            pieces.add(new Cavalier('N', new Position("G8")));
            pieces.add(new Tour('N', new Position("H8")));
            for (int i = 0; i < 8; i++) {
                pieces.add(new PionNoir(new Position((char) ('A' + i) + "7")));
            }
        } else {
            pieces.add(new Tour('B', new Position("A1")));
            pieces.add(new Cavalier('B', new Position("B1")));
            pieces.add(new Fou('B', new Position("C1")));
            pieces.add(new Dame('B', new Position("D1")));
            pieces.add(new Roi('B', new Position("E1")));
            pieces.add(new Fou('B', new Position("F1")));
            pieces.add(new Cavalier('B', new Position("G1")));
            pieces.add(new Tour('B', new Position("H1")));
            pieces.add(new PionBlanc(new Position("A2")));
            pieces.add(new PionBlanc(new Position("B2")));
            pieces.add(new Tavalier('B', new Position("C2")));
            pieces.add(new Favalier('B', new Position("D2")));
            pieces.add(new Favalier('B', new Position("E2")));
            pieces.add(new Tavalier('B', new Position("F2")));
            pieces.add(new PionBlanc(new Position("G2")));
            pieces.add(new PionBlanc(new Position("H2")));
            pieces.add(new Tour('N', new Position("A8")));
            pieces.add(new Cavalier('N', new Position("B8")));
            pieces.add(new Fou('N', new Position("C8")));
            pieces.add(new Dame('N', new Position("D8")));
            pieces.add(new Roi('N', new Position("E8")));
            pieces.add(new Fou('N', new Position("F8")));
            pieces.add(new Cavalier('N', new Position("G8")));
            pieces.add(new Tour('N', new Position("H8")));
            pieces.add(new PionNoir(new Position("A7")));
            pieces.add(new PionNoir(new Position("B7")));
            pieces.add(new Tavalier('N', new Position("C7")));
            pieces.add(new Favalier('N', new Position("D7")));
            pieces.add(new Favalier('N', new Position("E7")));
            pieces.add(new Tavalier('N', new Position("F7")));
            pieces.add(new PionBlanc(new Position("G7")));
            pieces.add(new PionBlanc(new Position("H7")));
        }
    }

    public Piece getCase(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getPosition().getX() == x && pieces.get(i).getPosition().getY() == y) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public Piece getCase(Position position) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getPosition().getX() == position.getX() && pieces.get(i).getPosition().getY() == position.getY()) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public Piece getCase(String position) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getPosition().getX() == Position.getX(position) && pieces.get(i).getPosition().getY() == Position.getY(position)) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public String toString() {
        String s = "";
        s += " |---|---|---|---|---|---|---|---|\n";
        for (int i = 8; i > 0; i--) {
            s += i;
            for (int j = 0; j < 8; j++) {
                Piece p = getCase(j, i - 1);
                if (p == null) {
                    s += "|   ";
                } else {
                    s += "|" + p.getNomCourt();
                }
            }
            s += "|" + i + "\n";
            s += " |---|---|---|---|---|---|---|---|\n";
        }
        s += "   A   B   C   D   E   F   G   H";
        return s;
    }

    public ArrayList<Piece> getPieceBlanches() {
        ArrayList<Piece> pieceBlanche = new ArrayList<Piece>(); // 16 pièces blanches
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i) != null && pieces.get(i).getCouleur() == 'B') {
                pieceBlanche.add(pieces.get(i));
            }
        }
        return pieceBlanche;
    }

    public ArrayList<Piece> getPieceNoires() {
        ArrayList<Piece> pieceNoire = new ArrayList<Piece>(); // 16 pièces noires
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i) != null && pieces.get(i).getCouleur() == 'N') {
                pieceNoire.add(pieces.get(i));
            }
        }
        return pieceNoire;
    }

    public void deplacerPiece(Piece piece, Position position) {
        if (piece != null) {
            piece.setPosition(position);
        }
        else {
            System.out.println("La pièce n'existe pas");
        }
    }

    public void deplacer(Position from, Position to) {
        ArrayList<Position> deplacements = new ArrayList<Position>();
        deplacements = getCase(from).getDeplacementsPossible(this);
        if (deplacements.contains(to)) {
            Piece piece = getCase(to);
            if (piece != null) {
                pieces.remove(piece);
            }
            getCase(from).setPosition(to);

            // On ajoute 1 au compteur de déplacement de la pièce
            getCase(to).setNbDeplacement(getCase(to).getNbDeplacement() + 1);

            // Detection du roc
            if (getCase(to).getNomCourt().charAt(0) == 'R' && getCase(to).getNomCourt().charAt(1) == 'o' && getCase(to).getNbDeplacement() == 1) {
                if (to.getX() == 6) {
                    deplacerForce(new Position("H" + (to.getY() + 1)), new Position("F" + (to.getY() + 1)));
                }
                else if (to.getX() == 2) {
                    deplacerForce(new Position("A" + (to.getY() + 1)), new Position("D" + (to.getY() + 1)));
                }
            }

            // Detection de la prise en passant
            if (getCase(to).getNomCourt().charAt(0) == 'P' && getCase(to).getNbDeplacement() == 1) {
                if (to.getY() == 2) {
                    if (getCase(to.getX(), to.getY() + 1) != null && getCase(to.getX(), to.getY() + 1).getNomCourt().charAt(0) == 'P' && getCase(to.getX(), to.getY() + 1).getNbDeplacement() == 1) {
                        
                    }
                }
                else if (to.getY() == 5) {
                    if (getCase(to.getX(), to.getY() - 1) != null && getCase(to.getX(), to.getY() - 1).getNomCourt().charAt(0) == 'P' && getCase(to.getX(), to.getY() - 1).getNbDeplacement() == 1) {
                        pieces.remove(getCase(to.getX(), to.getY() - 1));
                    }
                }
            }

        }
        else {
            System.out.println("Le déplacement n'est pas possible");
        }
    }

    public boolean estEchec(char couleur) {
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        if (couleur == 'B') {
            pieces = getPieceBlanches();
        }
        else {
            pieces = getPieceNoires();
        }
        for (int i = 0; i < pieces.size(); i++) {
            ArrayList<Position> deplacements = new ArrayList<Position>();
            deplacements = pieces.get(i).getDeplacementsPossible(this);
            for (int j = 0; j < deplacements.size(); j++) {
                if (getCase(deplacements.get(j)) != null && getCase(deplacements.get(j)).getNomCourt().charAt(0) == 'R' && getCase(deplacements.get(j)).getCouleur() != couleur) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deplacerForce(Position from, Position to) {
        Piece piece = getCase(to);
        if (piece != null) {
            pieces.remove(piece);
        }
        getCase(from).setPosition(to);
    }
}