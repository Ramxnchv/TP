package tp.p1.zombies;

public class Zombie {
	private int healthPoints = 5;
	private int speed=1;
	private int damage=1;
	private int x;
	private int y;
	
	public Zombie(int x,int y) {
		this.x=x;
		this.y=y;
	}

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