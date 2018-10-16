package tp.p1.zombies;

public class Zombie {
	private int healthPoints = 5;
	private int speed=1;
	private int damage=1;
	private int x;
	private int y;
<<<<<<< Updated upstream
=======
	boolean avanzar;
	private Game game;
>>>>>>> Stashed changes
	
	public Zombie(int x,int y) {
		this.x=x;
		this.y=y;
	}

<<<<<<< Updated upstream
=======
	public void avanzar() {
		if(game.checkEmpty(x-1, y)) {
			this.x--;
		}
	}
	
	public void atacar() {
		for(int i=0;i<game.getZombieList().getContador();i++) {
			for(int j=0;j<game.getSunflowerList().getContador();j++) {
				
			}
			for() {
				
			}
		}
	}
	
	//getters y setters
>>>>>>> Stashed changes
	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
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