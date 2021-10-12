import java.util.ArrayList;
import java.util.Collections;

public class Joueur {

	private int comptPoints;
	private ArrayList<Carte> paquet;

	ArrayList<String> tabCartes = new ArrayList<String>();
	
	public Joueur(ArrayList<Carte> paquet) {
		this.comptPoints = 0; 
		this.paquet = paquet; 
	} 
	
	
	public int getPoints() {
		return this.comptPoints;
	}
	
	public ArrayList<Carte> getPaquet() {
		return this.paquet;
	}
	
	
	/** 
	  * Tire au hasard une carte du paquet
	  *  
	  * @return Carte
	  *
	  */
	public Carte tireCarte() {
		Collections.shuffle(paquet);
		Carte carteTiree = paquet.get(0);
		this.paquet.remove(0);
		return carteTiree;
	}
	
	/** 
	  * Ajoute la carte gagn�e
	  *  
	  * @param Carte 	
	  *
	  */
	public void ajouteCarte(Carte saCarte, Carte carteGagnee) {
		this.paquet.add(saCarte);
		this.paquet.add(carteGagnee);
		this.comptPoints ++;
	}
	
	/** 
	  * Ajoute la carte courante lorsque l'on arrive � une �galit� lors de la deuxi�me bataille
	  *  
	  * @param Carte 	
	  *
	  */
	public void ajouteCarteEgalite(Carte saCarte) {
		this.paquet.add(saCarte);
	}
	
	/** 
	  * Sais s'il reste des cartes dans le paquet du joueur
	  *  
	  * @return boolean
	  *
	  */
	public boolean resteDansPaquet() {
		if(this.paquet.size() > 0) {
			return true;
		}else{
			return false;
		}
	}	
}