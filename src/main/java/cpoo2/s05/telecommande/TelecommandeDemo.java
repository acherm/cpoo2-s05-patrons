package cpoo2.s05.telecommande;

/** À lancer pour voir la télécommande : programmer, appuyer, reprogrammer, annuler. */
public class TelecommandeDemo {

    public static void main(String[] args) {
        Lampe salon = new Lampe("du salon");
        Lampe cuisine = new Lampe("de la cuisine");

        Telecommande telecommande = new Telecommande();
        telecommande.programmer(0, new AllumerLampe(salon));
        telecommande.programmer(1, new EteindreLampe(salon));
        System.out.println(telecommande);

        telecommande.appuyer(0);
        System.out.println("touche 0 : " + salon + ", " + cuisine);

        telecommande.annuler();                 // défait la touche 0
        System.out.println("annuler  : " + salon + ", " + cuisine);

        telecommande.programmer(0, new AllumerLampe(cuisine));   // la touche 0 change de rôle
        telecommande.appuyer(0);
        System.out.println("touche 0 : " + salon + ", " + cuisine);

        telecommande.appuyer(7);                // touche non programmée : rien
    }
}
