package tp.p1.zombies;
import tp.p1.game.Game;
import tp.p1.objects.Zombie;

public class ZombieComun extends Zombie {

	public ZombieComun(int x,int y,Game game) {
		//x,y,healthPoints,frequency,damage,speed,game
		super(x,y,5,2,1,1,game);
	}

	public ZombieComun() {
		//para avaiableZombies
		super(0,0,5,1,1,1,null);
	}
	public String toString()
	{
		String 	str = "Z ["  + this.healthPoints + "]";

		return str;
	}

	public String printInfo() {
	String str = "Z [l:" + this.healthPoints + ",x:" + this.getX() + ",y:" + this.getY() + ",t:"+ timeToNextAction() + " ]";

	return str;
	}

}
