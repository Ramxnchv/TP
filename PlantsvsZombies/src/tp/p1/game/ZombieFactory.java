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
	public static Zombie getZombie (String zombieName) {
		Zombie z;
		if(zombieName.equals("caracubo")||zombieName.equals("w")) {
			z=new Caracubo();
		}
		else if(zombieName.equals("deportista")||zombieName.equals("x")) {
			z=new Deportista();
		} else {
			z=new ZombieComun();
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
		
		String caraCubo = "Name: Caracubo - Health: 8 - Frecuencia: 4 - Daño: 1 - Speed: 1"; 
		String Deportista = "Name: Deportista - Health: 2 - Frequency: 1 - Damage: 1 - Speed: 1"; 
		String ZombieComun = "Name: Zombie Comun - Health: 5 - Frecuencia: 1 - Daño: 1 - Velocidad: 1"; 
		
		sb.append(caraCubo).append("\n!").append(Deportista).append("\n").append(ZombieComun).append("\n");
		
		return sb.toString();
	}
	

}
