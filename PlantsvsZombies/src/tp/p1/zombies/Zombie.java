package tp.p1.zombies;
import tp.p1.game.Game;

public class Zombie {
	private int healthPoints = 5;
	private int speed=1;
	private int damage=1;
	private int internalCycle;
	private int x;
	private int y;
	private Game game;

	
	public Zombie(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public void avanzar() {
		if(game.checkEmpty(x-1, y)) {
			this.x=this.x-speed;
		}
	}
	
	public void atacar() {
		for(int i=0;i<game.getZombieList().getContador();i++) {
			for(int j=0;j<game.getSunflowerList().getContador();j++) {
				if(game.getZombieList().getZombie(i).getX()-1==game.getSunflowerList().getSunFlower(j).getX()) {
					game.getSunflowerList().getSunFlower(j).setHealthPoints(game.getSunflowerList().getSunFlower(j).getHealthPoints()-game.getZombieList().getZombie(i).getDamage());
				}
			}
			for(int k=0;k<game.getPeashooterList().getContador();k++) {
				if(game.getZombieList().getZombie(i).getX()-1==game.getPeashooterList().getPeaShooter(k).getX()) {
					game.getPeashooterList().getPeaShooter(k).setHealthPoints(game.getPeashooterList().getPeaShooter(k).getHealthPoints()-game.getZombieList().getZombie(i).getDamage());	
				}
			}
		}
	}
	
	//getters y setters

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	
	public int getInternalCycle() {
		return internalCycle;
	}

	public void setInternalCycle(int internalCycle) {
		this.internalCycle = internalCycle;
	}
	
	public String toString()
	{
		String 	str = "Z ["  + healthPoints + "]";
		
		return str;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public int getDamage() {
		return damage;
	}
	
	
}
