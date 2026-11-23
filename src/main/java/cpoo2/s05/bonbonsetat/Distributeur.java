package cpoo2.s05.bonbonsetat;

import java.util.Random;

/** Le contexte du patron État : il garde son état courant et lui délègue tout. À comparer avec `cpoo2.s05.bonbons.Distributeur`. */
public class Distributeur {

    private Etat etat;
    private int bonbons;
    private int bonbonsSortis;
    private final Random hasard;

    public Distributeur(int bonbons) {
        this(bonbons, new Random());
    }

    public Distributeur(int bonbons, Random hasard) {
        this.bonbons = bonbons;
        this.hasard = hasard;
        this.etat = bonbons > 0 ? new SansPiece() : new Vide();
    }

    public void insererPiece() { etat.insererPiece(this); }

    public void rendrePiece() { etat.rendrePiece(this); }

    public void tournerPoignee() {
        etat.tournerPoignee(this);
        etat.distribuer(this);      // l'état a pu changer entre les deux lignes
    }

    public String situation() { return etat.nom(); }

    public int bonbons() { return bonbons; }

    public int bonbonsSortis() { return bonbonsSortis; }

    @Override public String toString() {
        return "Distributeur : " + bonbons + " bonbon(s), " + situation();
    }

    // ------------------------------------------------ ce dont les états ont besoin

    void changerEtat(Etat suivant) { this.etat = suivant; }

    void libererBonbon() {
        if (bonbons > 0) {
            bonbons--;
            bonbonsSortis++;
            dire("Un bonbon tombe");
        }
    }

    /** Vrai une fois sur dix. Pour la Q4. */
    boolean tirageGagnant() { return hasard.nextInt(10) == 0; }

    void dire(String message) { System.out.println("  " + message); }
}
