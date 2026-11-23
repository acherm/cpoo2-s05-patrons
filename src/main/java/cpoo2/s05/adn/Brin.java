package cpoo2.s05.adn;

import java.util.ArrayList;
import java.util.List;

/**
 * Un brin d'ADN. Aujourd'hui, il crée un objet Base par lettre, et chaque
 * base connaît sa position. Q6 : il demande ses bases à FabriqueDeBases, et
 * c'est lui qui donne la position quand il demande à une base de se décrire.
 */
public class Brin {

    private final List<Base> bases = new ArrayList<>();

    public Brin(String sequence) {
        for (int position = 0; position < sequence.length(); position++) {
            bases.add(new Base(sequence.charAt(position), position));    // TODO S05 Q6
        }
    }

    public int taille() { return bases.size(); }

    public String sequence() {
        StringBuilder texte = new StringBuilder();
        for (Base base : bases) {
            texte.append(base.symbole());
        }
        return texte.toString();
    }

    public String decrire(int position) {
        return bases.get(position).decrire();                           // TODO S05 Q6
    }

    public void muter(int position, char symbole) {
        bases.set(position, new Base(symbole, position));                // TODO S05 Q6
    }

    @Override public String toString() { return sequence(); }
}
