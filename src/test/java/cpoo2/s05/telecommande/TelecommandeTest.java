package cpoo2.s05.telecommande;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/** La télécommande fournie. Vert au départ, et il doit le rester. */
class TelecommandeTest {

    @Test
    void une_touche_execute_sa_commande() {
        Lampe salon = new Lampe("du salon");
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(0, new AllumerLampe(salon));
        telecommande.programmer(1, new EteindreLampe(salon));
        telecommande.appuyer(0);
        assertTrue(salon.estAllumee());
        telecommande.appuyer(1);
        assertFalse(salon.estAllumee());
    }

    @Test
    void une_touche_non_programmee_ne_fait_rien() {
        Lampe salon = new Lampe("du salon");
        Telecommande telecommande = new Telecommande();
        telecommande.programmer(0, new AllumerLampe(salon));
        telecommande.appuyer(5);
        assertFalse(salon.estAllumee());
    }

    @Test
    void il_n_y_a_que_dix_touches() {
        Telecommande telecommande = new Telecommande();
        assertThrows(IllegalArgumentException.class,
                () -> telecommande.programmer(10, new AucuneCommande()));
        assertThrows(IllegalArgumentException.class, () -> telecommande.appuyer(-1));
    }
}
