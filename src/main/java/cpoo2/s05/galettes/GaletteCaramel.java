package cpoo2.s05.galettes;

import java.util.ArrayList;
import java.util.List;

/** Une autre recette. Comparez sa méthode monter() à celle de GaletteSaucisse. */
public class GaletteCaramel {

    public List<String> monter() {
        List<String> etapes = new ArrayList<>();
        // 1. la pâte
        etapes.add("pâte de sarrasin étalée sur le bilig");
        // 2. la garniture
        etapes.add("caramel au beurre salé");
        // 3. l'emballage
        etapes.add("galette roulée dans une feuille de papier");
        return etapes;
    }
}
