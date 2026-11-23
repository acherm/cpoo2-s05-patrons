package cpoo2.s05.bonbons;

/**
 * Le distributeur de bonbons, première version : la situation est un entier,
 * et chaque méthode commence par une cascade de `if` sur cet entier.
 *
 * Ce code marche, et ses tests sont verts. Il est là pour être lu : la
 * version à états, celle que vous complétez, est dans `cpoo2.s05.bonbonsetat`.
 */
public class Distributeur {

    static final int VIDE = 0;
    static final int SANS_PIECE = 1;
    static final int AVEC_PIECE = 2;
    static final int BONBON_VENDU = 3;

    private int etat = VIDE;
    private int bonbons;
    private int bonbonsSortis;

    public Distributeur(int bonbons) {
        this.bonbons = bonbons;
        if (bonbons > 0) {
            etat = SANS_PIECE;
        }
    }

    public void insererPiece() {
        if (etat == AVEC_PIECE) {
            dire("Il y a déjà une pièce");
        } else if (etat == SANS_PIECE) {
            dire("Pièce acceptée");
            etat = AVEC_PIECE;
        } else if (etat == VIDE) {
            dire("Il n'y a plus de bonbons, gardez votre pièce");
        } else if (etat == BONBON_VENDU) {
            dire("Attendez, votre bonbon arrive");
        }
    }

    public void rendrePiece() {
        if (etat == AVEC_PIECE) {
            dire("Pièce rendue");
            etat = SANS_PIECE;
        } else if (etat == SANS_PIECE) {
            dire("Vous n'avez pas mis de pièce");
        } else if (etat == VIDE) {
            dire("Vous n'avez pas mis de pièce");
        } else if (etat == BONBON_VENDU) {
            dire("Trop tard, vous avez déjà tourné la poignée");
        }
    }

    public void tournerPoignee() {
        if (etat == AVEC_PIECE) {
            dire("Vous tournez la poignée");
            etat = BONBON_VENDU;
            distribuer();
        } else if (etat == SANS_PIECE) {
            dire("Vous tournez, mais il faut d'abord une pièce");
        } else if (etat == VIDE) {
            dire("Vous tournez, mais il n'y a plus de bonbons");
        } else if (etat == BONBON_VENDU) {
            dire("Tourner deux fois ne donne pas un second bonbon");
        }
    }

    private void distribuer() {
        if (etat == BONBON_VENDU) {
            dire("Un bonbon tombe");
            bonbons = bonbons - 1;
            bonbonsSortis = bonbonsSortis + 1;
            if (bonbons == 0) {
                dire("Il n'y a plus de bonbons");
                etat = VIDE;
            } else {
                etat = SANS_PIECE;
            }
        } else if (etat == SANS_PIECE) {
            dire("Il faut d'abord une pièce");
        } else if (etat == VIDE) {
            dire("Aucun bonbon à distribuer");
        } else if (etat == AVEC_PIECE) {
            dire("Aucun bonbon à distribuer");
        }
    }

    public String situation() {
        if (etat == AVEC_PIECE) {
            return "avec pièce";
        } else if (etat == SANS_PIECE) {
            return "sans pièce";
        } else if (etat == BONBON_VENDU) {
            return "bonbon vendu";
        } else {
            return "vide";
        }
    }

    public int bonbons() { return bonbons; }

    public int bonbonsSortis() { return bonbonsSortis; }

    @Override public String toString() {
        return "Distributeur : " + bonbons + " bonbon(s), " + situation();
    }

    private void dire(String message) { System.out.println("  " + message); }
}
