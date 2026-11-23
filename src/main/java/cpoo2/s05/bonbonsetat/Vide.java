package cpoo2.s05.bonbonsetat;

class Vide implements Etat {

    @Override public void insererPiece(Distributeur distributeur) {
        distributeur.dire("Il n'y a plus de bonbons, gardez votre pièce");
    }

    @Override public void rendrePiece(Distributeur distributeur) {
        distributeur.dire("Vous n'avez pas mis de pièce");
    }

    @Override public void tournerPoignee(Distributeur distributeur) {
        distributeur.dire("Vous tournez, mais il n'y a plus de bonbons");
    }

    @Override public void distribuer(Distributeur distributeur) { }

    @Override public String nom() { return "vide"; }
}
