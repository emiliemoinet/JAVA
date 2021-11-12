import java.util.ArrayList;
import java.util.Scanner;
import Weapon.AK47;
import Weapon.Sword;
import Weapon.Tnt;
import Weapon.Weapon;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Weapon> w = new ArrayList<Weapon>();
		
		w.add(new AK47(60, 80));
		w.add(new Sword(45, 65));
		w.add(new Tnt(20, 25));
		
		Game g = new Game(scan, w);
		g.play();

	}

}
