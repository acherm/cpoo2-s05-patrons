package cpoo2.s05.telecommande;

/** Un appareil de la maison. Il ne sait rien de la télécommande. */
public class Lampe {

    private final String piece;
    private boolean allumee;

    public Lampe(String piece) { this.piece = piece; }

    public void allumer() { allumee = true; }

    public void eteindre() { allumee = false; }

    public boolean estAllumee() { return allumee; }

    @Override public String toString() {
        return "lampe " + piece + (allumee ? " allumée" : " éteinte");
    }
}
