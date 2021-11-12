package Weapon;
import Entity.Entity;

public abstract class Weapon {
	
	private String name;
	private float price;
	private int damage;

	public Weapon(String name, float price, int damage) {
		this.name = name;
		this.price = price;
		this.damage = damage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public float getDamage() {
		return this.damage;
	}

	public void attack(Entity e) {	
		e.loseLife(this.damage);
 	}
	
	public abstract String ascii_art();
	
	
	
}
