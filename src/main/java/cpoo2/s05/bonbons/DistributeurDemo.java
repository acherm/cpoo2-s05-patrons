package cpoo2.s05.bonbons;

/** À lancer pour voir le distributeur à `if` vivre : trois bonbons, quelques clients. */
public class DistributeurDemo {

    public static void main(String[] args) {
        Distributeur distributeur = new Distributeur(3);
        System.out.println(distributeur);

        distributeur.insererPiece();
        distributeur.tournerPoignee();
        System.out.println(distributeur);

        distributeur.tournerPoignee();          // sans pièce
        distributeur.insererPiece();
        distributeur.insererPiece();            // deux pièces de suite
        distributeur.rendrePiece();
        System.out.println(distributeur);

        distributeur.insererPiece();
        distributeur.tournerPoignee();
        distributeur.insererPiece();
        distributeur.tournerPoignee();
        System.out.println(distributeur);       // vide

        distributeur.insererPiece();
    }
}
