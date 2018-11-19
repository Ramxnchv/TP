package tp.p1.game;


import tp.p1.zombies.*;
import tp.p1.objects.Zombie;

public class ZombieFactory {

	private static Zombie[] avaiableZombies = {
			new Caracubo(),
			new Deportista(),
			new ZombieComun(),
		};
	
	//Por si lo añadimos nosotros
	public static Zombie getZombie (String zombieName,int x,int y,Game game) {
		Zombie z;
		if(zombieName.equals("Caracubo")||zombieName.equals("w")) {
			z=new Caracubo(x,y,game);
		}
		else if(zombieName.equals("Deportista")||zombieName.equals("x")) {
			z=new Deportista(x,y,game);
		} else {
			z=new ZombieComun(x,y,game);
		}
		return z;
	}
	
	//Por si se añade de forma aleatoria (creo)
	public static Zombie getZombie() {
		
		Zombie z = null;
		
		return z;
	}
	
	
	public static String infoAvailableZombies() {
		
		StringBuilder sb = new StringBuilder();
		
		String caraCubo = "Name: Caracubo - Health: "+avaiableZombies[0].getHealthPoints()+" - Frecuencia:"+avaiableZombies[0].getFrequency()+"- Daño:"+avaiableZombies[0].getDamage()+" - Speed:"+avaiableZombies[0].getSpeed(); 
		String Deportista = "Name: Caracubo - Health: "+avaiableZombies[1].getHealthPoints()+" - Frecuencia:"+avaiableZombies[1].getFrequency()+"- Daño:"+avaiableZombies[1].getDamage()+" - Speed:"+avaiableZombies[1].getSpeed(); 
		String ZombieComun = "Name: Caracubo - Health: "+avaiableZombies[2].getHealthPoints()+" - Frecuencia:"+avaiableZombies[2].getFrequency()+"- Daño:"+avaiableZombies[2].getDamage()+" - Speed:"+avaiableZombies[2].getSpeed(); 
		
		sb.append(caraCubo).append("\n!").append(Deportista).append("\n").append(ZombieComun).append("\n");
		
		return sb.toString();
	}
	

}
