package com.atoudeft.banque;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Banque implements Serializable {
    private String nom;
    private List<CompteClient> comptes;
    private static final int SIX = 6;
    private static final int HUIT= 8;

    public Banque(String nom) {
        this.nom = nom;
        this.comptes = new ArrayList<>();
    }

    /**
     * Recherche un compte-client à partir de son numéro.
     *
     * @param numeroCompteClient le numéro du compte-client
     * @return le compte-client s'il a été trouvé. Sinon, retourne null
     */
    public CompteClient getCompteClient(String numeroCompteClient) {
        CompteClient cpt = new CompteClient(numeroCompteClient,"");
        int index = this.comptes.indexOf(cpt);
        if (index != -1)
            return this.comptes.get(index);
        else
            return null;
    }

    /**
     * Vérifier qu'un compte-bancaire appartient bien au compte-client.
     *
     * @param numeroCompteBancaire numéro du compte-bancaire
     * @param numeroCompteClient    numéro du compte-client
     * @return  true si le compte-bancaire appartient au compte-client
     */
    public boolean appartientA(String numeroCompteBancaire, String numeroCompteClient) {
        throw new NotImplementedException();
    }

    /**
     * Effectue un dépot d'argent dans un compte-bancaire
     *
     * @param montant montant à déposer
     * @param numeroCompte numéro du compte
     * @return true si le dépot s'est effectué correctement
     */
    public boolean deposer(double montant, String numeroCompte) {
        throw new NotImplementedException();
    }

    /**
     * Effectue un retrait d'argent d'un compte-bancaire
     *
     * @param montant montant retiré
     * @param numeroCompte numéro du compte
     * @return true si le retrait s'est effectué correctement
     */
    public boolean retirer(double montant, String numeroCompte) {
        throw new NotImplementedException();
    }

    /**
     * Effectue un transfert d'argent d'un compte à un autre de la même banque
     * @param montant montant à transférer
     * @param numeroCompteInitial   numéro du compte d'où sera prélevé l'argent
     * @param numeroCompteFinal numéro du compte où sera déposé l'argent
     * @return true si l'opération s'est déroulée correctement
     */
    public boolean transferer(double montant, String numeroCompteInitial, String numeroCompteFinal) {
        throw new NotImplementedException();
    }

    /**
     * Effectue un paiement de facture.
     * @param montant montant de la facture
     * @param numeroCompte numéro du compte bancaire d'où va se faire le paiement
     * @param numeroFacture numéro de la facture
     * @param description texte descriptif de la facture
     * @return true si le paiement s'est bien effectuée
     */
    public boolean payerFacture(double montant, String numeroCompte, String numeroFacture, String description) {
        throw new NotImplementedException();
    }

    /**
     * Crée un nouveau compte-client avec un numéro et un nip et l'ajoute à la liste des comptes.
     *
     * @param numCompteClient numéro du compte-client à créer
     * @param nip nip du compte-client à créer
     * @return true si le compte a été créé correctement
     */
    public boolean ajouter(String numCompteClient, String nip) {
        int cptChar = 0;
        for (int i = 0; i <numCompteClient.length() ; i++) {
            //insère le caractère à la position i de la sting numCompteClient. Il manque la vérification de chiffre
            char caractere= numCompteClient.charAt(i);
            if(caractere>='a'&& caractere<='z'){ //
                cptChar++;
            }
            //Vérification de lettres minuscules dans le numéro de compte. Il manque la vérification de caracs spéciaux
            else if(caractere>='A'&& caractere<='Z'){
                return false;
            }
        }
        if(cptChar>=SIX && cptChar<=HUIT){
            return true;
        }
        else {
            return false;
        }



        // return this.comptes.add(new CompteClient(numCompteClient,nip)); //À modifier
    }

    /**
     * Retourne le numéro du compte-chèque d'un client à partir de son numéro de compte-client.
     *
     * @param numCompteClient numéro de compte-client
     * @return numéro du compte-chèque du client ayant le numéro de compte-client
     */
    public String getNumeroCompteParDefaut(String numCompteClient) {
        //À compléter : retourner le numéro du compte-chèque du compte-client.
         //return null; //À modifier

        //Rechercher numCompteClient du client
        CompteClient cptClient = getCompteClient(numCompteClient);

        if(cptClient != null){
            //parcourir la liste CompteClient
            for(CompteBancaire compte : cptClient.comptes){
                //verifier qu'il s'agit bien d'un compte-cheque
                if(compte.estCompteCheque()){ // j'ai créé un boolean estCompteCheque dans la classe CompteCheque, mais jsp trop si on peut faire ça
                    //retourne le numero du compte-cheque
                    return compte.getNumero();
                }
            }
        }
        return null; //retourne null si aucun compte-cheque a ete trouve
    }
}