package tp.p1.game;

import tp.p1.plants.*;

public class PlantFactory {
	private static Plant[] avaiablePlants = {
		new PeaShooter(),
		new SunFlower(),
		new Petacereza(),
		new Nuez()
	}
	
	public static Plant getPlant (String plantName) {
		
	}
	
	public static String listOfAvaiablePlants() {
		System.out.println("[S]unflower: Cost: "+SunFlower.getCost()+"suncoins  Harm: "+SunFlower.getDamage());
		System.out.println("[N]uez: Cost: "+Nuez.getCost()+"suncoins  Harm: "+Nuez.getDamage());
		System.out.println("Peta[c]ereza: Cost: "+PetaCereza.getCost()+"suncoins  Harm: "+PetaCereza.getDamage());
		System.out.println("[P]eashooter: Cost: "+PeaShooter.getCost()+"suncoins  Harm: "+PeaShooter.getDamage()+"\n");
	}
}