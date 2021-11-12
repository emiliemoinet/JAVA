package Entity.perso;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.Entity;
import Entity.Destructible.Monsters;
import Weapon.Weapon;

public class Personnages extends Entity {
	
	protected String name;
	protected double money;
	protected ArrayList<Weapon> inventory;

	public Personnages(String name, double life, double money, double xp, String type) {
		this.name = name;
		this.life = life;
		this.money = money;
		this.xp = xp;
		this.inventory = new ArrayList<Weapon>();
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getMoney() {
		return this.money;
	}

	public ArrayList<Weapon> getInventory() {
		return this.inventory;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void buy(Weapon w) {
		this.money -= w.getPrice();
		this.inventory.add(w);
	}

	@Override
	public String toString() {
		return "Personnage [" + this.name + ", " + this.money + "€, " + this.xp + "xp]";
	}

	@Override
	public void loseLife(double d) {
		this.life -= d;	
	}
	
	public boolean fight(Scanner scan, Entity e) {
		while (this.life > 0 && e.getLife() > 0) {
			this.inventory.get(this.inventory.indexOf(this.chooseWeapon(scan))).attack(e);
			if (e instanceof Monsters) {
				Monsters m = (Monsters) e;
				this.loseLife(m.getDamage());
			}
		}
		if (e.getLife() <= 0) {
			this.xp += e.getXp();
			System.out.println("Vous avez gagné le combat et remporté " + e.getXp() + "xp");
			return true;
		} else {
			System.out.println("Vous êtes mort avec " + this.xp + "xp");
			return false;
		}
	}
	
	private Weapon chooseWeapon(Scanner scan) {
		int action;
		do {
			System.out.println("Quel arme vouelez-vous utiliser :");
			int i = 0;
			for (Weapon w : this.inventory) {
				System.out.println(i++ + " - " + w.getName());
			}
			action = scan.nextInt();
		} while (action < 0 || action > this.inventory.size());
		return this.inventory.get(action);
	}
}