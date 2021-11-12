package Entity.Destructible;

public class Monsters extends Destructible {
	
	final double ratio = 1.2;
	private double damage;

	public Monsters(double damage) {
		super(100, "m", 50);
		this.damage = damage;
	}
	
	public double getDamage() {
		return this.damage;
	}
	
	public void loseLife(double damage) {
		this.life -= damage * this.ratio;
	}

}