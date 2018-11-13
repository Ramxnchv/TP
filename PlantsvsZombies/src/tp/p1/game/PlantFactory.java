package tp.p1.game;

import tp.p1.objects.Plant;
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
		StringBuilder sb = new StringBuilder();
		String sf = buildSfInfo();

		String ps = buildPsInfo();

		String pC = buildsPcInfo();

		String nuez = buildNuezInfo();

		sb.append(sf).append(ps).append(pC).append(nuez);

		return sb.toString();
	}

	private String buildSfInfo(){

		StringBuilder sb = new StringBuilder();

		String sf = "[S]unflower: Cost: ";
		String harm = "suncoins  Harm: ";
		int sfCost = SunFlower.getCost();
		int sfDmg = SunFlower.getDamage();

		sb.append(sf).append(sfCost).append(harm).append(sfDmg).append("\n");

		return sb.toString();
	}

	private String buildPsInfo(){

		StringBuilder sb = new StringBuilder();

		String ps = "[P]eashooter: Cost: ";
		String harm = "suncoins  Harm: ";
		int psCost = PeaShooter.getCost();
		int psDmg = PeaShooter.getDamage();

		sb.append(ps).append(psCost).append(harm).append(psDmg).append("\n");

		return sb.toString();

	}

	private String buildPcInfo() {

		StringBuilder sb = new StringBuilder();

		String pc = "Peta[c]ereza: Cost: ";
		String harm = "suncoins Harm: ";
		int pcCost = PetaCereza.getCost();
		int pcDmg = PetaCereza.getDamage();

		sb.append(pc).append(harm).append(pcCost).append(pcDmg).append("\n");

		return sb.toString();
	}

	private String buildNuezInfo() {
		StringBuilder sb = new StringBuilder();

		String nuez = "[N]uez: Cost: ";
		String harm = "suncoins Harm: ";
		int nuezCost = Nuez.getCost();
		int nuezDmg = Nuez.getDamage();

		sb.append(nuez).append(harm).append(nuezCost).append(nuezDmg).append("\n");

		return sb.toString();

	}

}
