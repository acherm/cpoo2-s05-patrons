package cpoo2.s05.telecommande;

/** La commande d'une touche qui n'a pas été programmée : elle ne fait rien. */
public class AucuneCommande implements Commande {

    @Override public void executer() { }

    @Override public void annuler() { }
}
