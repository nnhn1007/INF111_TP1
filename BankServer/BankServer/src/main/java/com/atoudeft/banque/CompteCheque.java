package com.atoudeft.banque;

public class CompteCheque extends CompteBancaire{
    /**
     * Crée un compte chèque.
     *
     * @param numero numéro du compte
     * @param type   type du compte
     */
    private static final double ZERO =0.00;

    public CompteCheque(String numero, TypeCompte type) {
        super(numero, type);
    }

    /** Méthode qui réalise un dépot d'argent dans le solde d'un compte-chèque
     *
     * @param montant Variable double qui représente le  montant à ajouter au solde.
     * @return True si le solde initial était strictement positive, sinon retourne false.
     */
    @Override
    public boolean crediter(double montant) {
    double solde = getSolde();
        if(solde>ZERO){ // Strictement positive ?
            solde+= montant; // Inutile ?
         }
        return false;
    }

    /** Méthode qui réalise un retrait d'argent dans le solde d'un compte-chèque
     *
     * @param montant Variable double qui représente le  montant à débiter du solde.
     * @return True si le solde initial était strictement positive et que
     * le solde initiale est plus grand ou égal au montant à retirer, sinon retourne false.
     */
    @Override
    public boolean debiter(double montant) {
        double solde =getSolde();
        if(solde>ZERO && solde>=montant){ // Strictement positive et solde > montant à debiter
            solde-=montant; // Inutile ?
        }
        return false;
    }

    /**
     *
     * @param numeroFacture Variable string qui définit le numéro de facture.
     * @param montant Variable double qui représente le montant à facturer de la facture.
     * @param description
     * @return
     */
    @Override
    public boolean payerFacture(String numeroFacture, double montant, String description) {
        return false;
    }

    /**
     *
     * @param montant Variable double qui représente le montant transferé.
     * @param numeroCompteDestinataire
     * @return
     */
    @Override
    public boolean transferer(double montant, String numeroCompteDestinataire) {
        return false;
    }
}
