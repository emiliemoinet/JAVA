public class Carte {
	
	 public static final String[] VALEURS = { null, "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame",
     "Roi" };
	 public static final String[] COULEURS = { "Tr�fle", "Carreau", "Coeur", "Pique" };
	 private int valeur;
	 private int couleur;

	 public Carte(int valeur, int couleur) {
	   this.valeur = valeur;
	   this.couleur = couleur; 
	 } 
	
	 /** 
	  * Renvoie cha�ne de caract�res d�crivant l'objet concern� 
	  * @return      String
	  */
	 public String toString() {
	   return VALEURS[this.valeur] + " de " + COULEURS[this.couleur];
	 }
	 
	 
 
	 /** 
	  * Compare la carte courante � celle pass� en param�tre
	  * Les deux premi�res comparaisons servent � g�rer le cas de "l'As" 
	  *  
	  * @return      int
	  * @param       autreCarte
	  *
	  */
	public int comparerA(Carte autreCarte) {
		
		if (this.valeur == 1 & autreCarte.valeur > 1) {
			return 1;
		}else if (this.valeur > 1 & autreCarte.valeur == 1 ) {
			return -1;
		}else if (this.valeur > autreCarte.valeur){
			return 1;
		}else if(this.valeur < autreCarte.valeur){
			return -1;
		}else {
			return 0;
		}
	}

}