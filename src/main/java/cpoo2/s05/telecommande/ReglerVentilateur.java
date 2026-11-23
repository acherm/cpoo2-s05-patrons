package cpoo2.s05.telecommande;

import cpoo2.s05.telecommande.Ventilateur.Vitesse;

/** Une commande qui met le ventilateur à une vitesse donnée. À écrire (Q8). */
public class ReglerVentilateur implements Commande {

    public ReglerVentilateur(Ventilateur ventilateur, Vitesse vitesse) {
        // TODO S05 Q8 : que doit retenir la commande ?
    }

    @Override public void executer() {
        throw new UnsupportedOperationException("TODO S05 Q8");
    }

    @Override public void annuler() {
        throw new UnsupportedOperationException("TODO S05 Q8");
    }
}
