package Map;

import java.util.Random;
import java.util.Scanner;

import Entity.Entity;
import Entity.perso.Personnages;
import Entity.Destructible.Monsters;
import Entity.Destructible.Obstacle;

public class Map {
	
	public final int MONSTERS = 22;
	public final int OBSTACLES = 38;
	private Scanner scan;
	
	private Tile [][] map = new Tile[20][20];
	private Tile joueur;

	public Map(Scanner scan, Personnages joueur) {
		this.scan = scan;
		for (int y=0; y < this.map[0].length; y++) {
			for (int x=0; x < this.map.length; x++) {
				this.map[x][y] = new Tile(x, y, ".");
			}
		}
		this.monstersGeneration();
		this.obstaclesGeneration();
		this.joueur = new Tile(0, this.map[0].length-1, joueur);
		this.map[0][this.map[0].length-1] = this.joueur;
		this.fight();
	}
	
	private void monstersGeneration() {
		int occupiedSpots = 0;
		Random random = new Random();

		while(occupiedSpots < this.MONSTERS){
		    int x = random.nextInt(this.map.length);
		    int y = random.nextInt(this.map[0].length);
		    if(this.map[x][y].getType() == "."){
		        this.map[x][y] = new Tile(x, y, new Monsters(30));
		        occupiedSpots++;
		    }
		}
	}
	
	private void obstaclesGeneration() {
		int occupiedSpots = 0;
		Random random = new Random();

		while(occupiedSpots < this.OBSTACLES){
		    int x = random.nextInt(this.map.length);
		    int y = random.nextInt(this.map[0].length);
		    if(this.map[x][y].getType() == "."){
		        this.map[x][y] = new Tile(x, y, new Obstacle());
		        occupiedSpots++;
		    }
		}
	}
	
	public void displayMap() {
		for (int y=0; y < this.map[0].length; y++) {
			for (int x=0; x < this.map.length; x++) {
				System.out.print(this.map[x][y].getType());
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean movePlayer(String direction) {
		if (this.joueur.canMove(direction)) {
			int x = this.joueur.getX();
			int y = this.joueur.getY();
			int newX = x;
			int newY = y;
			switch (direction) {
				case "z":
					this.map[x][y-1] = this.joueur;
					newY--;
					break;
				case "s":
					this.map[x][y+1] = this.joueur;
					newY++;
					break;
				case "q":
					this.map[x-1][y] = this.joueur;
					newX--;
					break;
				case "d":
					this.map[x+1][y] = this.joueur;
					newX++;
					break;
				
				default:
					break;
			}
			this.map[x][y] = new Tile(x, y, ".");
			this.joueur.move(newX, newY);
			if (newX == 19 && newY == 0) {
				System.out.println("Fin de la partie");
				return true;
			}
			this.fight();
			return true;
		} else if (direction != "start"){
			System.out.println("Pas de déplacement possible dans se sens");
			return false;
		} else {
			return false;
		}
	}
	
	public void fight() {
		Personnages p = (Personnages) this.joueur.getEntity();
		if (this.joueur.getX()+1 <= 19) {
			int x = this.joueur.getX()+1;
			int y = this.joueur.getY();
			Entity e = this.getEntityXY(x, y);
			if (e != null) {
				System.out.println("Un monstre/obstacle, il faut se  battre");
				if (p.fight(this.scan, e)) {
					this.map[x][y] = new Tile(x, y, "X");
				}
			}
		}
		if (this.joueur.getX()-1 >= 0) {
			int x = this.joueur.getX()-1;
			int y = this.joueur.getY();
			Entity e = this.getEntityXY(x, y);
			if (e != null) {
				System.out.println("Un monstre/obstacle, il faut se  battre");
				if (p.fight(this.scan, e)) {
					this.map[x][y] = new Tile(x, y, "X");
				}
			}
		}
		if (this.joueur.getY()+1 <= 19) {
			int x = this.joueur.getX();
			int y = this.joueur.getY()+1;
			Entity e = this.getEntityXY(x, y);
			if (e != null) {
				System.out.println("Un monstre/obstacle, il faut se  battre");
				if (p.fight(this.scan, e)) {
					this.map[x][y] = new Tile(x, y, "X");
				}
			}
		}
		if (this.joueur.getY()-1 >= 0) {
			int x = this.joueur.getX();
			int y = this.joueur.getY()-1;
			Entity e = this.getEntityXY(x, y);
			if (e != null) {
				System.out.println("Un monstre/obstacle, il faut se  battre");
				if (p.fight(this.scan, e)) {
					this.map[x][y] = new Tile(x, y, "X");
				}
			}
		}
	}
	
	private Entity getEntityXY(int x, int y) {
		return this.map[x][y].getEntity();
	}
}