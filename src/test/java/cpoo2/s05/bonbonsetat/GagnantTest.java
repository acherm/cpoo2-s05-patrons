package cpoo2.s05.bonbonsetat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

/** Q4 : une fois sur dix, deux bonbons. Le test choisit le hasard. */
class GagnantTest {

    /** Un hasard qui fait toujours gagner. */
    static final Random TOUJOURS = new Random() {
        @Override public int nextInt(int borne) { return 0; }
    };

    @Test
    void q4_le_gagnant_recoit_deux_bonbons() {
        Distributeur d = new Distributeur(5, TOUJOURS);
        d.insererPiece();
        d.tournerPoignee();
        assertEquals(2, d.bonbonsSortis());
        assertEquals(3, d.bonbons());
        assertEquals("sans pièce", d.situation());
    }

    @Test
    void q4_sans_chance_un_seul_bonbon() {
        Distributeur d = new Distributeur(5, DistributeurTest.JAMAIS);
        d.insererPiece();
        d.tournerPoignee();
        assertEquals(1, d.bonbonsSortis());
    }

    @Test
    void q4_pas_de_gagnant_quand_il_ne_reste_qu_un_bonbon() {
        Distributeur d = new Distributeur(1, TOUJOURS);
        d.insererPiece();
        d.tournerPoignee();
        assertEquals(1, d.bonbonsSortis());
        assertEquals("vide", d.situation());
    }

    @Test
    void q4_deux_bonbons_gagnes_peuvent_vider_le_distributeur() {
        Distributeur d = new Distributeur(2, TOUJOURS);
        d.insererPiece();
        d.tournerPoignee();
        assertEquals(0, d.bonbons());
        assertEquals("vide", d.situation());
    }
}
