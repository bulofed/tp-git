import java.util.ArrayList;

public abstract class Piece {
    private char couleur;
    private Position position;
    private int nbDeplacements;

    public abstract String getType();
    public abstract ArrayList<Position> getDeplacementsPossible(Plateau plateau);

    public char getCouleur() {
        return this.couleur;
    }

    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Piece() {
        this.couleur = 'B';
        this.position = new Position("A2");
    }

    public Piece(Piece piece) {
        this.couleur = piece.getCouleur();
        this.position = new Position(piece.getPosition());
    }

    public Piece(String type, char couleur, int x, int y) {
        this.couleur = couleur;
        this.position = new Position(x, y);
        this.nbDeplacements = 0;
    }

    public Piece(String type, char couleur, Position position) {
        this.couleur = couleur;
        this.position = position;
        this.nbDeplacements = 0;
    }

    public Piece(String type, char couleur, String position) {
        this.couleur = couleur;
        this.position = new Position(position);
        this.nbDeplacements = 0;
    }

    public String getNomCourt() {
        return this.getType().substring(0, 1).toUpperCase() + this.getType().substring(1, 2).toLowerCase() + this.getCouleur();
    }

    public String getNomLong() {
        String nomLong = "";
        nomLong += this.getType();
        if (this.couleur == 'N') {
            nomLong += "_N";
        }
        else {
            nomLong += "_B";
        }
        return nomLong;
    }

    public boolean equals(Piece piece) {
        return this.couleur == piece.getCouleur() && this.position.equals(piece.getPosition());
    }

    public String toString() {
        // Retourne une description de la pièce sous la forme: "Roi Noir en A1"
        return this.getNomCourt() + " en " + this.position.toString();
    }

    public int getNbDeplacement() {
        return nbDeplacements;
    }

    public void setNbDeplacement(int nbDeplacement) {
        this.nbDeplacements = nbDeplacement;
    }
}