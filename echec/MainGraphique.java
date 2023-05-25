import java.util.ArrayList;
import MG2D.*;
import MG2D.geometrie.*;

public class MainGraphique {
    private static int TAILLE_PLATEAU = 600;
    private static int TAILLE_CASE = TAILLE_PLATEAU / 8;
    public static ArrayList<Piece> piece_blanche = null;
    public static ArrayList<Piece> piece_noire = null;
    public static ArrayList<Position> deplacements = new ArrayList<Position>();
    public static ArrayList<Cercle> cercles = new ArrayList<Cercle>();
    public static char couleur = 'B';

    public static void main(String[] args) throws InterruptedException {
        Fenetre f = new Fenetre("Echec", TAILLE_PLATEAU, TAILLE_PLATEAU);
        Plateau p = new Plateau();
        Souris s = f.getSouris();
        
        rafraichir(f, p);

        // Boucle principale
        while (true) {
            if (s.getClicGauche()) {
                Position p1 = new Position(s.getPosition().getX() / TAILLE_CASE, s.getPosition().getY() / TAILLE_CASE);
                int x = p1.getX();
                int y = p1.getY();

                // On peut seulement déplacer les pièces de la couleur du joueur
                if (p.getCase(x, y) == null || p.getCase(x, y).getCouleur() != couleur) {
                    continue;
                }

                // On crée un cercle rouge pour montrer les déplacements possibles
                deplacements = p.getCase(x, y).getDeplacementsPossible(p);
                for (Position pos : deplacements) {
                    Cercle c = new Cercle(Couleur.ROUGE, new Point(pos.getX() * TAILLE_CASE + TAILLE_CASE / 2, pos.getY() * TAILLE_CASE + TAILLE_CASE / 2), TAILLE_CASE / 2, false);
                    f.ajouter(c);
                    f.rafraichir();
                    cercles.add(c);
                }

                // On attend jusqu'à ce que le joueur clic de nouveau
                while (!s.getBoutonGaucheEnfonce()) {
                    Thread.sleep(10);
                }
                
                // On récupère la position du clic
                Position p2 = new Position(s.getPosition().getX() / TAILLE_CASE, s.getPosition().getY() / TAILLE_CASE);

                // Si le joueur clic sur une case qui n'est pas une position disponible, on retire les cercles
                if (!deplacements.contains(p2)) {
                    for (Cercle c : cercles) {
                        f.supprimer(c);
                    }
                    cercles.clear();
                    continue;
                }

                p.deplacer(p1, p2);
                rafraichir(f, p);
                
                if (couleur == 'B') {
                    couleur = 'N';
                } else {
                    couleur = 'B';
                }
            }
            try { Thread.sleep(10);}
            catch (Exception e) { e.printStackTrace();}
        }
    }
        
    public static void PiecesPlateau(Plateau p, Fenetre f) {
        piece_noire = p.getPieceNoires();
        piece_blanche = p.getPieceBlanches();
        
        // Ajout des pièces au plateau
        for (Piece p1 : piece_blanche) {
            Texture blanc = new Texture("images/" + p1.getNomLong() + ".png",
                    new Point(p1.getPosition().getX() * TAILLE_CASE, p1.getPosition().getY() * TAILLE_CASE),
                    TAILLE_CASE, TAILLE_CASE);
            f.ajouter(blanc);
        }

        for (Piece p2 : piece_noire) {
            Texture noir = new Texture("images/" + p2.getNomLong() + ".png",
                    new Point(p2.getPosition().getX() * TAILLE_CASE, p2.getPosition().getY() * TAILLE_CASE),
                    TAILLE_CASE, TAILLE_CASE);
            f.ajouter(noir);
        }
        f.rafraichir();
    }

    public static void constructionPlateau(Fenetre f) {
        // Construction du plateau en créant plusieurs carrés blancs et gris
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    Carre carreBlanc = new Carre(Couleur.BLANC, new Point(i * TAILLE_CASE, j * TAILLE_CASE), TAILLE_CASE, true);
                    f.ajouter(carreBlanc);
                } else {
                    Carre carreGris = new Carre(Couleur.GRIS, new Point(i * TAILLE_CASE, j * TAILLE_CASE), TAILLE_CASE, true);
                    f.ajouter(carreGris);
                }
            }
        }
    }

    public static void rafraichir(Fenetre f, Plateau p) {
        f.effacer();
        constructionPlateau(f);
        // Echec
        if (p.estEchec(couleur)) {
            System.out.println("Echec");
            // On colorie la case du roi en rouge
            if (couleur == 'B') {
                for (Piece p3 : p.getPieceNoires()) {
                    if (p3 instanceof Roi) {
                        Carre t = new Carre(Couleur.ROUGE, new Point(p3.getPosition().getX() * TAILLE_CASE, p3.getPosition().getY() * TAILLE_CASE), TAILLE_CASE, true);
                        f.ajouter(t);
                    }
                }
            } else {
                for (Piece p3 : p.getPieceBlanches()) {
                    if (p3 instanceof Roi) {
                        Carre t = new Carre(Couleur.ROUGE, new Point(p3.getPosition().getX() * TAILLE_CASE, p3.getPosition().getY() * TAILLE_CASE), TAILLE_CASE, true);
                        f.ajouter(t);
                    }
                }
            }
        }
        PiecesPlateau(p, f);
        f.rafraichir();
    }
}