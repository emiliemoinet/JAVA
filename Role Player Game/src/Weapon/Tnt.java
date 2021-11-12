package Weapon;

public class Tnt extends Weapon{

	public Tnt(float price, int damage) {
		super("TNT", price, damage);
		
	}
	
	public String ascii_art() {
	return "      ,--.!, \n"
		 + "   __/   -*- \n"
		 + "  ,d08b.  '|` \n"
		 + "  0088MM     \n"
		 + "  `9MMP'      \n"; 
	}
	
}