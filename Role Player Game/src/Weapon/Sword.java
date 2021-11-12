package Weapon;

public class Sword extends Weapon{

	public Sword(float price, int damage) {
		super("Sword", price, damage);
		
	}

	public String ascii_art() {
		return "====)------------- \n";
			
	}
}

