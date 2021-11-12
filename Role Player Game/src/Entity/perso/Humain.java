package Entity.perso;

public class Humain extends Personnages{
	public Humain(String name) {
		super(name, 200, 200, 100, "H");
	}

	@Override
	public String toString() {
		return "Humain [" + this.name + ", " + this.life + "hp, " + this.money + "€, " + this.xp + "xp]";
	}
}
