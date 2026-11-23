package cpoo2.s05.telecommande;

public class AllumerLampe implements Commande {

    private final Lampe lampe;

    public AllumerLampe(Lampe lampe) { this.lampe = lampe; }

    @Override public void executer() { lampe.allumer(); }

    @Override public void annuler() { lampe.eteindre(); }
}
