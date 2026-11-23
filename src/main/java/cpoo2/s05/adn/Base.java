package cpoo2.s05.adn;

/**
 * Une base azotée d'un brin d'ADN. Aujourd'hui, chaque base garde son
 * symbole, son nom et sa position dans le brin : il faut donc un objet par
 * lettre du brin. Q6 : faites-en un poids-mouche.
 */
public final class Base {

    private static int creees = 0;

    /** Le nombre d'objets Base créés depuis le lancement du programme. */
    public static int creees() { return creees; }

    private final char symbole;
    private final String nom;
    private final int position;         // TODO S05 Q6 : la position n'a pas sa place ici

    public Base(char symbole, int position) {
        this.symbole = symbole;
        this.nom = switch (symbole) {
            case 'A' -> "adénine";
            case 'C' -> "cytosine";
            case 'G' -> "guanine";
            case 'T' -> "thymine";
            default -> throw new IllegalArgumentException("base inconnue : " + symbole);
        };
        this.position = position;
        creees++;
    }

    public char symbole() { return symbole; }

    public String nom() { return nom; }

    public String decrire() {
        return symbole + " (" + nom + ") en position " + position;
    }
}
