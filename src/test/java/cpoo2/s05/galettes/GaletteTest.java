package cpoo2.s05.galettes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GaletteTest {

    // ------------------------------------------- verts au départ, à garder verts

    @Test
    void la_galette_saucisse_se_monte_en_trois_etapes() {
        assertEquals(List.of("pâte de sarrasin étalée sur le bilig",
                             "saucisse grillée",
                             "galette roulée dans une feuille de papier"),
                new GaletteSaucisse().monter());
    }

    @Test
    void la_galette_caramel_se_monte_en_trois_etapes() {
        assertEquals(List.of("pâte de sarrasin étalée sur le bilig",
                             "caramel au beurre salé",
                             "galette roulée dans une feuille de papier"),
                new GaletteCaramel().monter());
    }

    // ------------------------------------------------------- rouges au départ

    private static Class<?> galette() {
        try {
            return Class.forName("cpoo2.s05.galettes.Galette");
        } catch (ClassNotFoundException e) {
            return fail("la classe Galette n'existe pas encore");
        }
    }

    @Test
    void q5_galette_est_abstraite_et_son_montage_est_final() throws Exception {
        Class<?> galette = galette();
        assertTrue(Modifier.isAbstract(galette.getModifiers()), "Galette doit être abstraite");
        Method monter = galette.getDeclaredMethod("monter");
        assertTrue(Modifier.isFinal(monter.getModifiers()), "monter() doit être final");
    }

    @Test
    void q5_seule_la_garniture_est_abstraite() {
        List<String> abstraites = Arrays.stream(galette().getDeclaredMethods())
                .filter(m -> Modifier.isAbstract(m.getModifiers()))
                .map(Method::getName).toList();
        assertEquals(List.of("ajouterGarniture"), abstraites);
    }

    @Test
    void q5_les_recettes_sont_des_galettes_et_ne_remontent_rien() {
        for (Class<?> recette : List.of(GaletteSaucisse.class, GaletteCaramel.class)) {
            assertEquals(galette(), recette.getSuperclass(),
                    recette.getSimpleName() + " doit hériter de Galette");
            List<String> methodes = Arrays.stream(recette.getDeclaredMethods())
                    .filter(m -> !m.isSynthetic()).map(Method::getName).toList();
            assertEquals(List.of("ajouterGarniture"), methodes,
                    recette.getSimpleName() + " ne doit garder qu'une méthode");
        }
    }
}
