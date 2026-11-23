package cpoo2.s05.bonbonsetat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Le comportement du distributeur à états, vu de dehors : les mêmes tests que
 * pour la version à `if` de `cpoo2.s05.bonbons`. Tout vert à la fin de la Q3.
 */
class DistributeurTest {

    /** Un hasard qui ne fait jamais gagner : le distributeur est prévisible. */
    static final Random JAMAIS = new Random() {
        @Override public int nextInt(int borne) { return 1; }
    };

    @Test
    void un_distributeur_plein_attend_une_piece() {
        Distributeur d = new Distributeur(5, JAMAIS);
        assertEquals("sans pièce", d.situation());
        assertEquals(5, d.bonbons());
    }

    @Test
    void un_distributeur_sans_bonbon_est_vide() {
        assertEquals("vide", new Distributeur(0, JAMAIS).situation());
    }

    @Test
    void une_piece_puis_la_poignee_donne_un_bonbon() {
        Distributeur d = new Distributeur(5, JAMAIS);
        d.insererPiece();
        assertEquals("avec pièce", d.situation());
        d.tournerPoignee();
        assertEquals(4, d.bonbons());
        assertEquals(1, d.bonbonsSortis());
        assertEquals("sans pièce", d.situation());
    }

    @Test
    void tourner_sans_piece_ne_donne_rien() {
        Distributeur d = new Distributeur(5, JAMAIS);
        d.tournerPoignee();
        assertEquals(5, d.bonbons());
        assertEquals(0, d.bonbonsSortis());
        assertEquals("sans pièce", d.situation());
    }

    @Test
    void on_peut_reprendre_sa_piece() {
        Distributeur d = new Distributeur(5, JAMAIS);
        d.insererPiece();
        d.rendrePiece();
        assertEquals("sans pièce", d.situation());
        d.tournerPoignee();
        assertEquals(5, d.bonbons());
    }

    @Test
    void une_seconde_piece_ne_change_rien() {
        Distributeur d = new Distributeur(5, JAMAIS);
        d.insererPiece();
        d.insererPiece();
        assertEquals("avec pièce", d.situation());
        d.tournerPoignee();
        assertEquals(4, d.bonbons());
    }

    @Test
    void le_dernier_bonbon_vide_le_distributeur() {
        Distributeur d = new Distributeur(1, JAMAIS);
        d.insererPiece();
        d.tournerPoignee();
        assertEquals(0, d.bonbons());
        assertEquals("vide", d.situation());
    }

    @Test
    void un_distributeur_vide_refuse_la_piece() {
        Distributeur d = new Distributeur(0, JAMAIS);
        d.insererPiece();
        assertEquals("vide", d.situation());
        d.tournerPoignee();
        assertEquals(0, d.bonbonsSortis());
    }
}
