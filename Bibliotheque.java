package test;

import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Iterator;

public class Bibliotheque<T> {
	
	private List<T> elements = new ArrayList<T>();
	
	public void ajouter(T item) {
		this.elements.add(item);
	}
	
	List<T> rechercherParCritere(Predicate<T> critere){
		List<T> resultats = new ArrayList<T>();
		for(T item: elements) {
			if(critere.test(item)) {
				resultats.add(item);
			}
		}
		return resultats;
	}
	
	public void supprimer(Predicate<T> critere) {
		Iterator<T> it = elements.iterator();
		while(it.hasNext()) {
			T item = it.next();
			if(critere.test(item)) {
				elements.remove(item);
			}
		}
	}
}
