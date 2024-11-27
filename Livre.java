package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livre {
	private String titre;
	private String auteur;
	private int anneePublication;
	
	public Livre() {};
	public Livre(String titre ,String auteur , int anneePublication) {
		this.titre  = titre;
		this.auteur = auteur;
		this.anneePublication = anneePublication;
	}
	public String getTitre() {
		return this.titre;
	}
	public String getAuteur() {
		return this.auteur;
	
	}
	public int getAnnePublication() {
		return this.anneePublication;
	}

	public static List<Livre> lireLivresDepuisFichier(File fichier) {
		List<Livre> livres = new ArrayList<Livre>();

		
		try (Scanner myReader = new Scanner(fichier)){
			
			int nbrLivre = 0;
			while(myReader.hasNextLine()) {
				nbrLivre++;
				String data = myReader.nextLine();
				String[] dataArrayFormat = data.split(";");
				if(dataArrayFormat.length != 3) {
					System.err.println("la format de livre dans la ligne "+nbrLivre+" est incorrect");
				}
				Livre livre = new Livre(dataArrayFormat[0],dataArrayFormat[1],Integer.valueOf(dataArrayFormat[2]));
				livres.add(livre);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		}
		
		
		return livres;
	}
	static void ecrireLivresDansFichier(List<Livre> livres, File fichier) {
		try (FileWriter myWriter = new FileWriter(fichier)){
			for(Livre livre:livres) {
				myWriter.write(livre.getTitre()+ ";"+livre.getAuteur()+";"+String.valueOf(livre.getAnnePublication())+ "\n");
			}
		} catch (IOException e) {
			System.err.println("Fichier introuvable");
		}
			
	
		
	}
}




























