package com.atoudeft.banque;

public class CompteCheque extends CompteBancaire{
    /**
     * Crée un compte chèque.
     *
     * @param numero numéro du compte
     * @param type   type du compte
     */
    private static double ZERO =0.00;

    public CompteCheque(String numero, TypeCompte type) {
        super(numero, type);
    }

    /**
     *
     * @param montant Variable double qui représente le  montant à ajouter au solde.
     * @return
     */
    @Override
    public boolean crediter(double montant) {
    double solde = getSolde();
        if(solde>ZERO){ // Strictement positive ?
            solde+= montant; // Inutile ?
         }
        return false;
    }

    /**
     *
     * @param montant Variable double qui représente le  montant à débiter du solde.
     * @return
     */
    @Override
    public boolean debiter(double montant) {
        double solde =getSolde();
        if(solde>ZERO && solde>montant){ // Strictement positive et solde > montant à debiter
            solde-=montant; // Inutile ?
        }
        return false;
    }

    /**
     *
     * @param numeroFacture
     * @param montant
     * @param description
     * @return
     */
    @Override
    public boolean payerFacture(String numeroFacture, double montant, String description) {
        return false;
    }

    /**
     *
     * @param montant
     * @param numeroCompteDestinataire
     * @return
     */
    @Override
    public boolean transferer(double montant, String numeroCompteDestinataire) {
        return false;
    }
}
