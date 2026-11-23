package cpoo2.s05.telecommande;

public class EteindreLampe implements Commande {

    private final Lampe lampe;

    public EteindreLampe(Lampe lampe) { this.lampe = lampe; }

    @Override public void executer() { lampe.eteindre(); }

    @Override public void annuler() { lampe.allumer(); }
}
