public class Position {
    // x et y entre 0 et 7
    private int x;
    private int y;

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(String position) {
        // Lettre en majuscule suivi d'un chiffre
        this.x = position.charAt(0) - 'A';
        this.y = position.charAt(1) - '1';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getX(String position) {
        return position.charAt(0) - 'A';
    }

    public static int getY(String position) {
        return position.charAt(1) - '1';
    }

    public void setX(int x) {
        if (x >= 0 && x <= 7) {
            this.x = x;
        }
        else {
            System.out.println("x doit être compris entre 0 et 7");
        }
    }

    public void setY(int y) {
        if (y >= 0 && y <= 7) {
            this.y = y;
        }
        else {
            System.out.println("y doit être compris entre 0 et 7");
        }
    }

    public String toString() {
        // Sous la forme A1
        return (char) (this.x + 'A') + "" + (this.y + 1);
    }

    public boolean equals(Object object) {
        if (object instanceof Position) {
            Position position = (Position) object;
            return this.x == position.getX() && this.y == position.getY();
        }
        else {
            return false;
        }
    }
}