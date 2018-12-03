package tp.p1.game;

public enum LEVEL {
	EASY(3,0.1),
	HARD(5,0.2),
	INSANE(10,0.3);
	
	private int numeroZombies;
	private double frecuencia;
	
	LEVEL(int numeroZombies,double frecuencia) {
		this.numeroZombies=numeroZombies;
		this.frecuencia=frecuencia;
	}

	public int getNumeroZombies() {
		return numeroZombies;
	}


	public double getFrecuencia() {
		return frecuencia;
	}

	public static LEVEL parse(String inputString) {
		for (LEVEL level : LEVEL.values() )
		if (level . name().equalsIgnoreCase(inputString)) return level;
		return null;
	}
	
	public static String all (String separator) {
		StringBuilder sb = new StringBuilder();
		for (LEVEL level : LEVEL.values() )
		sb.append(level.name() + separator);
		String allLevels = sb.toString();
		int p=allLevels.length()-separator.length();
		return allLevels.substring(0, p);
	}
	
}