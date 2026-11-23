package cpoo2.s05.adn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

class BasesTest {

    // ------------------------------------------- verts au départ, à garder verts

    @Test
    void un_brin_garde_sa_sequence() {
        Brin brin = new Brin("GATTACA");
        assertEquals(7, brin.taille());
        assertEquals("GATTACA", brin.sequence());
    }

    @Test
    void un_brin_sait_decrire_une_base() {
        Brin brin = new Brin("GATTACA");
        assertEquals("G (guanine) en position 0", brin.decrire(0));
        assertEquals("T (thymine) en position 3", brin.decrire(3));
        assertEquals("C (cytosine) en position 5", brin.decrire(5));
    }

    @Test
    void une_mutation_remplace_une_base() {
        Brin brin = new Brin("GATTACA");
        brin.muter(1, 'C');
        assertEquals("GCTTACA", brin.sequence());
        assertEquals("C (cytosine) en position 1", brin.decrire(1));
    }

    @Test
    void une_lettre_inconnue_est_refusee() {
        assertThrows(IllegalArgumentException.class, () -> new Brin("GAXT"));
    }

    // ------------------------------------------------------- rouges au départ

    @Test
    void q6_une_base_ne_garde_plus_sa_position() {
        for (Field champ : Base.class.getDeclaredFields()) {
            if (!Modifier.isStatic(champ.getModifiers())) {
                assertNotEquals(int.class, champ.getType(),
                        "Base garde encore un entier : " + champ.getName());
            }
        }
    }

    @Test
    void q6_la_fabrique_rend_toujours_la_meme_base() {
        assertSame(FabriqueDeBases.obtenir('A'), FabriqueDeBases.obtenir('A'));
        assertNotSame(FabriqueDeBases.obtenir('A'), FabriqueDeBases.obtenir('C'));
        assertEquals('G', FabriqueDeBases.obtenir('G').symbole());
    }

    @Test
    void q6_la_fabrique_refuse_une_lettre_inconnue() {
        assertThrows(IllegalArgumentException.class, () -> FabriqueDeBases.obtenir('X'));
    }

    @Test
    void q6_un_long_brin_ne_cree_que_quatre_bases() {
        int avant = Base.creees();
        Brin brin = new Brin("GATTACA".repeat(10_000));
        brin.muter(3, 'G');
        assertTrue(Base.creees() - avant <= 4,
                "un brin de 70 000 bases a créé " + (Base.creees() - avant) + " objets Base");
    }
}
