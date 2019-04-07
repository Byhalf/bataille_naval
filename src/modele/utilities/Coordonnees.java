package modele.utilities;

public class Coordonnees{
    private int x, y;

    @Override
    public String toString() {
        return "x=" + Integer.toString(x) + " y=" + Integer.toString(y);
    }

    public Coordonnees(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean compare(Coordonnees coordAComparer) {
        return (getX() == coordAComparer.getX() && getY() == coordAComparer.getY());
    }
}
