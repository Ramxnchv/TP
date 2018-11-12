package tp.p1.zombies;
import tp.p1.game.Game;
import tp.p1.objects.Zombie;

public class ZombieComun extends Zombie {
	private int healthPoints = 5;
	private int speed=1;
	private int damage=1;
	private int internalCycle;
	private int x;
	private int y;
	private Game game;

	
	public ZombieComun(int x,int y,Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
		this.internalCycle=0;
	}

	public void update() {
		//aumentamos su ciclo
		internalCycle +=1;
		
		//si esta vacia la casilla
		if(game.checkEmpty(x, y-1)&&internalCycle%2==0) {
			//avanzar
			this.y=this.y-speed;
		}
		else if (game.checkEmpty(x, y-1) && internalCycle%2!=0 ){
			this.y = this.y;
		} else {
			if(!game.checkZombie(x, y-1)) {
				//atacar
				game.attackPlant(x,y-1,damage);
			}
		}

	}
	
	public void decreaseHealth(int damage)
	{
		healthPoints -= damage;
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
		String 	str = "Z ["  + this.healthPoints + "]";
		
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
