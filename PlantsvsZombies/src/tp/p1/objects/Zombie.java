package tp.p1.objects;

import tp.p1.game.Game;

public abstract class Zombie extends GameObject{
	protected int damage;
	protected int internalCycle;
	protected int speed;
	
	public Zombie(int x,int y,int healthPoints,int frequency,int damage, int internalCycle, int speed,Game game) {
		super(x,y,healthPoints,frequency,game);
		this.damage=damage;
		this.internalCycle=0;
		this.speed=speed;
	}
	
	public abstract void update();
	
	public String toString() {
		return super.toString();
	}
	
}
