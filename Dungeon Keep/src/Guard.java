
public class Guard extends Characters {
	public Guard() {
		// TODO Auto-generated constructor stub
	}

	public static boolean catchHero(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'G') {
					if (map[i - 1][j] == 'H' || map[i][j - 1] == 'H' || map[i + 1][j] == 'H' || map[i][j + 1] == 'H') {
						System.out.println("***********");
						System.out.println("*GAME OVER*");
						System.out.println("***********");
						System.out.println("You just got caught!");
						return true;
					}
				}
			}
		}
		return false;
	}
}
