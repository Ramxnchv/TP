package tp.p1.objects;

import tp.p1.game.Game;

public abstract class Zombie extends ActiveGameObject{
	protected int damage;
	protected int internalCycle;
	protected int speed;

	public Zombie(String symbol, int x,int y,int healthPoints,int frequency,int damage, int timeAction, int speed,Game game) {
		super(symbol,x,y,healthPoints,frequency, timeAction, game);
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
		if(frequency-internalCycle==-1) {
			internalCycle = 0;
		}
		return frequency-internalCycle;
	}

	public int getDamage() {
		return damage;
	}

	public int getInternalCycle() {
		return internalCycle;
	}

	public int getSpeed() {
		return speed;
	}

}