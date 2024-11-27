package test;

import java.io.File;
import java.util.List;

public class ApplicationBibliotheque {
	public static void main(String[] args) {
		File file = new File("fichier_livres.txt");
		Livre livre = new Livre();
		List<Livre> livreRechercher = livre.lireLivresDepuisFichier(file);
		System.out.println("Les livres diponibles , sont : ");
		for(Livre livre1:livreRechercher) {
			System.out.println(livre1.getTitre() +", l'auteur est "+livre1.getAuteur()+", date de pulication est : "+ livre1.getAnnePublication());
		}
		
		
		while(true) {
			System.out.println("""
					choisir un nombre pour effecuter une opération
					1 : ajouter un livre ,\n
					2 : chercher un livre , \n
					3 : supprimer un livre , \n
					4 : Sortir de programme ...
					""");
			System.out.println(" à continuer ...");
		}
	}
}
