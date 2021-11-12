package Weapon;
import java.util.ArrayList;

public class Shop {
	
	private ArrayList<Weapon> weapons;
	
	public Shop() {
		this.weapons = new ArrayList<Weapon>();
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	public Weapon getWeapon(int i) {
		return this.weapons.get(i);
	}
	
	public int getNumberOfItems() {
		return this.weapons.size();
	}
	
	public void displayShop() {
		int i = 0;
		for (Weapon weapon : this.weapons) {
			
			System.out.println(weapon.ascii_art());
			System.out.println("Choix n°" + i++ + " - " + weapon.getName());
		}
	}	
	
}
