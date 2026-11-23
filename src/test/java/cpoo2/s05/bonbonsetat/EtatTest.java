package cpoo2.s05.bonbonsetat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** Q3 : les deux états à compléter, pris un par un. */
class EtatTest {

    @Test
    void q3_avec_piece_rend_la_piece() {
        Distributeur d = new Distributeur(5, DistributeurTest.JAMAIS);
        new AvecPiece().rendrePiece(d);
        assertEquals("sans pièce", d.situation());
    }

    @Test
    void q3_avec_piece_refuse_une_seconde_piece() {
        Distributeur d = new Distributeur(5, DistributeurTest.JAMAIS);
        d.changerEtat(new AvecPiece());
        new AvecPiece().insererPiece(d);
        assertEquals("avec pièce", d.situation());
    }

    @Test
    void q3_avec_piece_passe_a_bonbon_vendu_quand_on_tourne() {
        Distributeur d = new Distributeur(5, DistributeurTest.JAMAIS);
        new AvecPiece().tournerPoignee(d);
        assertEquals("bonbon vendu", d.situation());
        assertEquals(5, d.bonbons(), "c'est BonbonVendu qui fait tomber le bonbon");
    }

    @Test
    void q3_bonbon_vendu_distribue_puis_attend_une_piece() {
        Distributeur d = new Distributeur(5, DistributeurTest.JAMAIS);
        new BonbonVendu().distribuer(d);
        assertEquals(4, d.bonbons());
        assertEquals("sans pièce", d.situation());
    }

    @Test
    void q3_bonbon_vendu_vide_le_distributeur_au_dernier_bonbon() {
        Distributeur d = new Distributeur(1, DistributeurTest.JAMAIS);
        new BonbonVendu().distribuer(d);
        assertEquals(0, d.bonbons());
        assertEquals("vide", d.situation());
    }
}
