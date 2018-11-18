package tp.p1.objects;

import tp.p1.game.Game;

public abstract class Zombie extends GameObject{
	protected int damage;
	protected int internalCycle;
	protected int speed;
	
	public Zombie(int x,int y,int healthPoints,int frequency,int damage, int speed,Game game) {
		super(x,y,healthPoints,frequency,game);
		this.damage=damage;
		this.internalCycle=0;
		this.speed=speed;
	}
	
	public abstract String toString();
	
	public void update() {
		//aumentamos su ciclo
		internalCycle +=1;
	
		//si esta vacia la casilla
		if(game.checkEmpty(x, y-1)&&internalCycle%frequency==0) {
			//avanzar
			this.y=this.y-speed;
		}
		else if (game.checkEmpty(x, y-1) && internalCycle%frequency!=0 ){
			this.y = this.y;
		} 
		else {
			if(!game.checkZombie(x, y-1)) {
				//atacar
				game.attackPlant(x,y-1,damage);
			}
		}
	}
	
	protected int timeToNextAction() {
		return frequency-internalCycle;
	}
}

