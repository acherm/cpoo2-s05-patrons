package cpoo2.s05.telecommande;

/** Une action devenue un objet : on peut la ranger sur une touche, l'exécuter, l'annuler. */
public interface Commande {

    void executer();

    /** Défait ce que le dernier `executer()` a fait. */
    void annuler();
}
