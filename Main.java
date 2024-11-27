package test;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.function.Predicate;

public class Main {
	// méthode pour ajouter un livre 
	private static Livre ajouterLivre(Scanner sc) {
		System.out.println("Entrer le titre du livre :");
		String titre = sc.nextLine();
		System.out.println("Entrer le nom de l'auteur du livre :");
		String auteur = sc.nextLine();
		System.out.println("Entrer l'année de publication du livre :");
		int anneePublication = sc.nextInt();
		sc.nextLine(); 
		        
		return new Livre(titre, auteur, anneePublication);
	
	}
	// methode pour enregistrer les livres dans un fichier
	private static void saveLivre(List<Livre> livres) {
		File file = new File("livreinfos");
		Livre.ecrireLivresDansFichier(livres, file);
	}
	//main methode	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		List<Livre> livres = new ArrayList<Livre>();
		
		
		
		while(true) {
			System.out.println("ajouter un livre : Oui :1 , Non :2");
			int nbr = sc.nextInt();
			sc.nextLine();
			if(nbr == 1) {
				Livre livreAjoutee = Main.ajouterLivre(sc);
				livres.add(livreAjoutee);
				System.out.println("Ajouter un autre livre");
			}else {
				break;
			}
			
		}
		System.out.println("Voulez vous enregistrer ces livres dans un fichiers , oui : 1 , Non : 2");
		int save = sc.nextInt();
		sc.nextLine();
		if(save == 1) {
			Main.saveLivre(livres);
			System.out.println("Livres enregistré avec succés");
		}else {
			System.out.println("Livres n'ont pas enregistés avec succée");
		}
		// Ajouter un livre dans la bibliothèque.
		Livre livre1 = new Livre("L'Enfant de sable","Tahar Ben Jelloun",1987);
		Bibliotheque<Livre> bibliotheque1 = new Bibliotheque<Livre>();
		bibliotheque1.ajouter(livre1);
		// Rechercher les livres publiés après une certaine année.
		Predicate<Livre> critereDatePub = livre -> livre1.getAnnePublication() > 1980;
		List<Livre> list = bibliotheque1.rechercherParCritere(critereDatePub);
		// Supprimer les livres d’un auteur donné.
		Predicate<Livre> critereAuteur = livre -> livre1.getAuteur() == "Tahar Ben Jelloun";
		bibliotheque1.supprimer(critereAuteur);
		
	}
}























