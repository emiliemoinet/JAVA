package Entity.perso;

public class Alien extends Personnages {

	public Alien(String name) {
		super(name, 230, 150, 150, "A");
	}

	@Override
	public String toString() {
		return "Alien [" + this.name + ", " + this.money + "€, " + this.xp + "xp]";
	}
}