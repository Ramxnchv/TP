package tp.p1;

import tp.p1.game.*;
import java.util.Random;
import java.util.Scanner;

public class PlantsVsZombies {

	public static void main(String[] args) {
		
		if((args.length>0)||(args.length<3)) {
			LEVEL level;
			int seed;
			Scanner scanner=new Scanner(System.in);
			
			args[0].toUpperCase();
			
			if(args[0].equals("EASY")) {
				level=LEVEL.EASY;
			}
			else if(args[0].equals("HARD")) {
				level=LEVEL.HARD;
			}
			else if(args[0].equals("INSANE")) {
				level=LEVEL.INSANE;
			}
			else {
				System.out.println("El nivel introducido es incorrecto, por defecto se asigna EASY");
				level=LEVEL.EASY;
			}
			
			if(args.length==1) {
				seed=new Random().nextInt(10);
			}
			else {
				seed=Integer.parseInt(args[1]);
			}
			
			Game game = new Game(level,seed);
			Controller controller = new Controller(game,scanner);
			controller.run();
		}	
	}
}
