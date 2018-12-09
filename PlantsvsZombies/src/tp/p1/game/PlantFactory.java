package tp.p1.game;

import tp.p1.objects.Plant;
import tp.p1.plants.*;

public class PlantFactory {

	private static Plant[] avaiablePlants = {
		new PeaShooter(),
		new SunFlower(),
		new PetaCereza(),
		new Nuez()
	};

	public static Plant getPlant (String plantName,int x,int y,Game game) {
		Plant p;
		if(plantName.equals("peashooter")||plantName.equals("p")) {
			p=new PeaShooter(x,y,game);
		}
		else if(plantName.equals("sunflower")||plantName.equals("s")) {
			p=new SunFlower(x,y,game);
		}
		else if(plantName.equals("petacereza")||plantName.equals("c")) {
			p=new PetaCereza(x,y,game);
		}
		else if(plantName.equals("nuez")||plantName.equals("n")){
			p=new Nuez(x,y,game);
		}
		else {
			p=null;
		}
		return p;
	}

	public static String listOfAvaiablePlants() {
		StringBuilder sb = new StringBuilder();
		String sf = buildSfInfo();

		String ps = buildPsInfo();

		String pC = buildPcInfo();

		String nuez = buildNuezInfo();

		sb.append(sf).append(ps).append(pC).append(nuez);

		return sb.toString();
	}

	private static String buildSfInfo(){

		StringBuilder sb = new StringBuilder();

		String sf = "[S]unflower: Cost: ";
		String harm = " suncoins  Harm: ";
		int sfCost = SunFlower.getCost();
		int sfDmg = 0;

		sb.append(sf).append(sfCost).append(harm).append(sfDmg).append("\n");

		return sb.toString();
	}

	private static String buildPsInfo(){

		StringBuilder sb = new StringBuilder();

		String ps = "[P]eashooter: Cost: ";
		String harm = " suncoins  Harm: ";
		int psCost = PeaShooter.getCost();
		int psDmg = PeaShooter.getDamage();

		sb.append(ps).append(psCost).append(harm).append(psDmg).append("\n");

		return sb.toString();

	}

	private static String buildPcInfo() {

		StringBuilder sb = new StringBuilder();

		String pc = "Peta[c]ereza: Cost: ";
		String harm = " suncoins Harm: ";
		int pcCost = PetaCereza.getCost();
		int pcDmg = PetaCereza.getDamage();

		sb.append(pc).append(pcCost).append(harm).append(pcDmg).append("\n");

		return sb.toString();
	}

	private static String buildNuezInfo() {
		StringBuilder sb = new StringBuilder();

		String nuez = "[N]uez: Cost: ";
		String harm = " suncoins Harm: ";
		int nuezCost = Nuez.getCost();
		int nuezDmg = 0;

		sb.append(nuez).append(nuezCost).append(harm).append(nuezDmg).append("\n");

		return sb.toString();

	}

}
