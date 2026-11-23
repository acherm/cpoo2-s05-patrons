package cpoo2.s05.bonbonsetat;

/**
 * Une situation du distributeur. Chaque méthode répond à une action, pour
 * cette situation-là, et change l'état du distributeur quand il le faut
 * (`distributeur.changerEtat(...)`).
 */
public interface Etat {

    void insererPiece(Distributeur distributeur);

    void rendrePiece(Distributeur distributeur);

    void tournerPoignee(Distributeur distributeur);

    /** Appelée par le distributeur juste après `tournerPoignee`. */
    void distribuer(Distributeur distributeur);

    /** Le nom de la situation : "sans pièce", "avec pièce", "bonbon vendu", "vide". */
    String nom();
}
