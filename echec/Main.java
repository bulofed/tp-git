import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Plateau plateau = new Plateau();
        // afficher plateau
        System.out.println(plateau);
        // afficher listes des pieces blanches
        ArrayList<Piece> pieceBlanche = plateau.getPieceBlanches();
        System.out.println(pieceBlanche.toString());
        // afficher listes des pieces noires
        ArrayList<Piece> pieceNoire = plateau.getPieceNoires();
        System.out.println(pieceNoire.toString());
    }
}