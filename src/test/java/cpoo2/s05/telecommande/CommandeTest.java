package cpoo2.s05.telecommande;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cpoo2.s05.telecommande.Ventilateur.Vitesse;
import org.junit.jupiter.api.Test;

/** Exercice 5 : les lampes sont vertes au départ, le ventilateur passe au vert à la Q8. */
class CommandeTest {

    @Test
    void q8_une_commande_regle_le_ventilateur() {
        Ventilateur ventilateur = new Ventilateur();
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(4, new ReglerVentilateur(ventilateur, Vitesse.RAPIDE));
        telecommande.programmer(5, new ReglerVentilateur(ventilateur, Vitesse.ARRET));
        telecommande.appuyer(4);
        assertEquals(Vitesse.RAPIDE, ventilateur.vitesse());
        telecommande.appuyer(5);
        assertEquals(Vitesse.ARRET, ventilateur.vitesse());
    }

    @Test
    void annuler_eteint_la_lampe_qu_on_vient_d_allumer() {
        Lampe salon = new Lampe("du salon");
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(0, new AllumerLampe(salon));
        telecommande.appuyer(0);
        telecommande.annuler();
        assertFalse(salon.estAllumee());
    }

    @Test
    void annuler_rallume_la_lampe_qu_on_vient_d_eteindre() {
        Lampe salon = new Lampe("du salon");
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(0, new AllumerLampe(salon));
        telecommande.programmer(1, new EteindreLampe(salon));
        telecommande.appuyer(0);
        telecommande.appuyer(1);
        telecommande.annuler();
        assertTrue(salon.estAllumee());
    }

    @Test
    void annuler_sans_avoir_rien_fait_ne_fait_rien() {
        Lampe salon = new Lampe("du salon");
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(0, new AllumerLampe(salon));
        telecommande.annuler();
        assertFalse(salon.estAllumee());
    }

    @Test
    void annuler_ne_concerne_que_la_derniere_touche() {
        Lampe salon = new Lampe("du salon");
        Lampe cuisine = new Lampe("de la cuisine");
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(0, new AllumerLampe(salon));
        telecommande.programmer(2, new AllumerLampe(cuisine));
        telecommande.appuyer(0);
        telecommande.appuyer(2);
        telecommande.annuler();
        assertTrue(salon.estAllumee());
        assertFalse(cuisine.estAllumee());
    }

    @Test
    void q8_annuler_remet_le_ventilateur_a_sa_vitesse_d_avant() {
        Ventilateur ventilateur = new Ventilateur();
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(3, new ReglerVentilateur(ventilateur, Vitesse.LENTE));
        telecommande.programmer(4, new ReglerVentilateur(ventilateur, Vitesse.RAPIDE));
        telecommande.appuyer(3);
        telecommande.appuyer(4);
        telecommande.annuler();
        assertEquals(Vitesse.LENTE, ventilateur.vitesse());
    }

    @Test
    void q8_la_vitesse_d_avant_n_est_pas_toujours_l_arret() {
        Ventilateur ventilateur = new Ventilateur();
        ventilateur.regler(Vitesse.RAPIDE);
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(5, new ReglerVentilateur(ventilateur, Vitesse.ARRET));
        telecommande.appuyer(5);
        telecommande.annuler();
        assertEquals(Vitesse.RAPIDE, ventilateur.vitesse());
    }
}
