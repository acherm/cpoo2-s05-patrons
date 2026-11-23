package cpoo2.s05.galettes;

import java.util.ArrayList;
import java.util.List;

/** Une recette. Comparez sa méthode monter() à celle de GaletteCaramel. */
public class GaletteSaucisse {

    public List<String> monter() {
        List<String> etapes = new ArrayList<>();
        // 1. la pâte
        etapes.add("pâte de sarrasin étalée sur le bilig");
        // 2. la garniture
        etapes.add("saucisse grillée");
        // 3. l'emballage
        etapes.add("galette roulée dans une feuille de papier");
        return etapes;
    }
}
