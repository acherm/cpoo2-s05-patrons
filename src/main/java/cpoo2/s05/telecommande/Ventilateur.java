package cpoo2.s05.telecommande;

/** Un autre appareil : il a trois vitesses, pas seulement marche et arrêt. */
public class Ventilateur {

    public enum Vitesse { ARRET, LENTE, RAPIDE }

    private Vitesse vitesse = Vitesse.ARRET;

    public void regler(Vitesse vitesse) { this.vitesse = vitesse; }

    public Vitesse vitesse() { return vitesse; }

    @Override public String toString() { return "ventilateur : " + vitesse; }
}
