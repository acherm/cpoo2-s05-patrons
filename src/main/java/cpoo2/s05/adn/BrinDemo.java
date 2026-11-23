package cpoo2.s05.adn;

/** À lancer avant et après l'exercice 3 : combien d'objets Base pour un long brin ? */
public class BrinDemo {

    public static void main(String[] args) {
        int avant = Base.creees();
        Brin brin = new Brin("GATTACA".repeat(150_000));
        System.out.println("Un brin de " + brin.taille() + " bases");
        System.out.println("Objets Base créés : " + (Base.creees() - avant));
        System.out.println(brin.decrire(0));
        System.out.println(brin.decrire(4));
    }
}
