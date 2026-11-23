package cpoo2.s05.telecommande;

/** L'invocateur : dix touches. Il exécute des commandes sans savoir ce qu'elles font. */
public class Telecommande {

    private static final int TOUCHES = 10;
    private static final Commande AUCUNE = new AucuneCommande();

    private final Commande[] commandes = new Commande[TOUCHES];
    private Commande derniere = AUCUNE;

    public Telecommande() {
        for (int touche = 0; touche < TOUCHES; touche++) {
            commandes[touche] = AUCUNE;
        }
    }

    public void programmer(int touche, Commande commande) {
        verifier(touche);
        commandes[touche] = commande;
    }

    public void appuyer(int touche) {
        verifier(touche);
        commandes[touche].executer();
        derniere = commandes[touche];
    }

    /** La touche « annuler » : elle défait la dernière commande exécutée. */
    public void annuler() {
        derniere.annuler();
        derniere = AUCUNE;
    }

    private static void verifier(int touche) {
        if (touche < 0 || touche >= TOUCHES) {
            throw new IllegalArgumentException("pas de touche " + touche);
        }
    }

    @Override public String toString() {
        StringBuilder texte = new StringBuilder("Télécommande\n");
        for (int touche = 0; touche < TOUCHES; touche++) {
            texte.append("  [").append(touche).append("] ")
                 .append(commandes[touche].getClass().getSimpleName()).append('\n');
        }
        return texte.toString();
    }
}
