package tp.p1.objects;

import tp.p1.game.Game;

public abstract class Zombie extends GameObject{
	private int damage;
	private int internalCycle;
	private int speed;
	
	public Zombie(int x,int y,int healthPoints,int frequency,int damage, int internalCycle, int speed,Game game) {
		super(x,y,healthPoints,frequency,game);
		this.damage=damage;
		this.internalCycle=internalCycle;
		this.speed=speed;
	}
	
	
	
}
