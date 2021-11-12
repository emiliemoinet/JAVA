package Entity.Destructible;
import Entity.Entity;

public class Destructible extends Entity {
	
	final double ratio = 1;

	public Destructible(double life, String type, double xp) {
		this.life = life;
		this.type = type;
		this.xp = xp;
	}
	
	public String getType() {
		return this.type;
	}

	@Override
	public void loseLife(double damage) {
		this.life -= damage;	
	}
}
