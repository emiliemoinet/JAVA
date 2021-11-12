import java.util.ArrayList;
import java.util.Scanner;

import Entity.perso.Alien;
import Entity.perso.Personnages;
import Entity.perso.Humain;
import Map.Map;
import Weapon.Weapon;
import Weapon.Sword;
import Weapon.Shop;

public class Game {
	
	private Scanner scan;
	private Map map;
	private Shop shop;
	private Personnages joueur;

	public Game(Scanner scan, ArrayList<Weapon> w) {
		this.scan = scan;
		System.out.println("Bienvenue, commençons la partie");
		
		this.joueur = this.persoCreation();
		this.joueur.buy(new Sword(20, 25));
		System.out.println(this.joueur);
		
		this.map = new Map(this.scan, this.joueur);
		this.map.displayMap();
		this.shop = new Shop();
	}

	public Personnages persoCreation() {
		int character = 0;
		Personnages joueur = null;
		do {
			System.out.println("Choisi un personnage :");
			System.out.println(" 1 - Humain");
			System.out.println(" 2 - Alien");
			character = this.scan.nextInt();
		} while (character != 1 && character != 2);
		System.out.println("Choisi un nom de personnage : ");
		this.scan.nextLine();
		String name = this.scan.nextLine();
		switch (character) {
			case 1:
				joueur = new Humain(name);
				break;
	
			case 2:
				joueur = new Alien(name);
				break;
			default:
				System.out.println("Choisi le nombre correspondant à un personnage");
				break;
		}
		return joueur;
	}
	
	public void play() {
		System.out.println("Début de la partie !");
		while (this.joueur.getLife() > 0) {		
			int action;
			do {
				System.out.println("Action suivante :");
				System.out.println(" 1 - Acheter des armes");
				System.out.println(" 2 - Se déplacer");
				action = this.scan.nextInt();
			} while (action != 1 && action != 2);
			this.scan.nextLine();
			
			if (action == 1) {
				this.shop();
			}
			
			if (action == 2) {
				this.move();
			}
		}
		System.out.println("Fin de la partie");
	}
	
	private void shop() {
		int action;
		do {
			this.shop.displayShop();
			System.out.println("Quelle arme voulez-vous acheter :");
			action = this.scan.nextInt();
		} while (action < 0 || action > this.shop.getNumberOfItems());
		this.scan.nextLine();
		this.joueur.buy(this.shop.getWeapon(action));
		System.out.println("Achat d'une arme pour " + this.shop.getWeapon(action).getPrice() + "€");
		System.out.println("Il reste " + this.joueur.getMoney() + "€");
	}
	
	private void move() {
		String direction = "start";
		while (!this.map.movePlayer(direction)) {
			do {
				System.out.println("Choisi une direction :");
				System.out.println(" z - Haut");
				System.out.println(" q - Gauche");
				System.out.println(" s - Droite");
				System.out.println(" d - Bas");
				direction = this.scan.nextLine();
			} while (direction == "z" || direction == "q" || direction == "s" || direction == "d");
		}
		this.map.displayMap();
		System.out.println(this.joueur);
	}
}