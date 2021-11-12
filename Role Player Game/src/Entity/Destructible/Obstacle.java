package Entity.Destructible;

public class Obstacle extends Destructible {
	
	final double ratio = 1.5;

	public Obstacle() {
		super(70, "o", 20);
	}
	
	public void loseLife(double damage) {
		this.life -= damage * this.ratio;
	}
}