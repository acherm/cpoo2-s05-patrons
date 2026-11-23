package cpoo2.s05.bonbonsetat;

class SansPiece implements Etat {

    @Override public void insererPiece(Distributeur distributeur) {
        distributeur.dire("Pièce acceptée");
        distributeur.changerEtat(new AvecPiece());
    }

    @Override public void rendrePiece(Distributeur distributeur) {
        distributeur.dire("Vous n'avez pas mis de pièce");
    }

    @Override public void tournerPoignee(Distributeur distributeur) {
        distributeur.dire("Vous tournez, mais il faut d'abord une pièce");
    }

    @Override public void distribuer(Distributeur distributeur) { }

    @Override public String nom() { return "sans pièce"; }
}
