package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	//
	private int nbretals;
	private Marche marche = new Marche(nbretals);

	public Village(String nom, int nbVillageoisMaximum, int nbr_etals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		this.nbretals = nbr_etals;
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	public void utiliserEtal(int indiceEtal, Gaulois vendeur,String produit, int nbProduit) {
		utiliserEtal( indiceEtal, vendeur,produit, nbProduit);
			
	}
	
	public String installerVendeur(Gaulois vendeur, String produit,int nbProduit) {
		StringBuilder chaine = new StringBuilder();
		chaine.append(vendeur.getNom() + "cherche un endroit pour vendre"+ nbProduit+ produit + ".\n");
		int verif = marche.trouverEtalLibre();
		
		return chaine.toString();
	}
	public String rechercherVendeursProduit(String produit) {
		StringBuilder chaine = new StringBuilder();
//		Etal[] etals =  
		//TODO
		return chaine.toString();
	}
	public Etal rechercherEtal(Gaulois vendeur) {
		for(int i=0; i<(this.marche.nbr_etals); i++) {
			if(this.marche.etals[i].getVendeur().equals(vendeur)) {
				return this.marche.etals[i];
			}
		}
		return null;
		
	}
	public String partirVendeur(Gaulois vendeur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Le vendeur"+ vendeur.getNom()+"quitte son étal, il a vendu"+ + produit + ".\n");
		return chaine.toString();
	}
	public String afficherMarche() {
		marche.afficherMarche();
	}
	
//Marche classe
	private static class Marche {
		private Etal etals[];
		private int nbr_etals = 0;
		
		public Marche(int nbr_etal) {
			for(int i=0; i<nbr_etal; i++) {
				this.etals[i] = new Etal();
				this.nbr_etals +=1;
			}
			
		}
		
		public void utiliserEtal(int indiceEtal, Gaulois vendeur,String produit, int nbProduit) {
			(this.etals[indiceEtal]).occuperEtal(vendeur, produit, nbProduit);
		}
		
		public int trouverEtalLibre() {
			int indice_libre = -1;
			for(int i=0; i<(this.nbr_etals); i++) {
				if(this.etals[i].isEtalOccupe() == false) {
					indice_libre=i;
					return indice_libre;
				}
			}
			return indice_libre;
		}
		
		public Etal[] trouverEtals(String produit) {
			int nbr_etals_libres = 0;
			for(int i=0; i<(this.nbr_etals); i++) {
				if(this.etals[i].contientProduit(produit) == true) {
					nbr_etals_libres++;
				}
			}
			
			Etal[] etals_occupes = new Etal[nbr_etals_libres];
			int parcours_tab = 0;
			for(int i=0; i<(this.nbr_etals); i++) {
				if(this.etals[i].contientProduit(produit) == true) {
					etals_occupes[parcours_tab] = this.etals[i];
					parcours_tab++;
				}
			}
			return etals_occupes;
		}
		
		public Etal trouverVendeur(Gaulois gaulois) {
			for(int i=0; i<(this.nbr_etals); i++) {
				if(etals[i].getVendeur().equals(gaulois)) {
					return etals[i];
				}
			}
			return null;
		}
		
		public void afficherMarche() {
			int nbEtalVide = 0;
			for(int i=0; i<(this.nbr_etals); i++) {
				if(etals[i].isEtalOccupe()) {
					etals[i].afficherEtal();
				}
				else {
					nbEtalVide++;
				}
			}
			if(nbr_etals>0) {
				System.out.println("Il reste " +
						nbEtalVide + " étals non utilisés dans le marché.\n");
			}
		}
//question 8 marche...
//Modifier le village pour implementer les fonctions marche
		
	}
}