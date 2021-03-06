package dkeep.cli;

import java.util.Arrays;
import java.util.Scanner;

import dkeep.logic.Game;
import dkeep.logic.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Menu.
 */
public class Menu {
	
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		System.out.println("*******");
		System.out.println("*START*");
		System.out.println("*******");
		System.out.println("Play with the keys a,w,s,d.");
		Game g = new Game();
		boolean nextLevel=true;
		nextLevel = level1(g);
		if (nextLevel) 
			level2(g);
	}
	
	/**
	 * Calls level 1 dealing with input and output (interface).
	 *
	 * @param g
	 *            the g
	 * @return true, if successful
	 */
	public static boolean level1(Game g)
	{
		boolean nextLevel = true; // permission to play level 2
		System.out.println("-----LEVEL 1-----");
		g.loadElementsLevel1();
		printMap(g.getMap());
		Scanner s = new Scanner(System.in);
		boolean end = false;
		while (end != true) {
			char direction = s.next().charAt(0);
			g.logicLevel1(direction);
			printMap(g.getMap());
			nextLevel = levelEnd(g);
			if (nextLevel) break;
		}
		return nextLevel;
	}
	
	/**
	 * Calls level 2 dealing with input and output (interface).
	 *
	 * @param g
	 *            the g
	 */
	public static void level2(Game g)
	{	
		System.out.println("-----LEVEL 2-----");
		g.loadElementsLevel2();
		printMap(g.getMap());
		Scanner s = new Scanner(System.in);
		boolean end = false;
		int[] i = new int[g.getOgres().size()];
		Arrays.fill(i, 0);
		while (end != true) {
			char direction = s.next().charAt(0);
			end = g.logicLevel2(direction, i);
			printMap(g.getMap());
			for (int w = 0; w < g.getOgres().size(); w++) {
				if (!g.getOgres().get(w).getStunned()) {
					i[w] = 0;
				} else {
					i[w]++;
				}
			}
			levelEnd(g);
		}
	}
	
	/**
	 * Tests for victory and loss.
	 *
	 * @param g
	 *            the g
	 * @return true, if successful
	 */
	public static boolean levelEnd(Game g)
	{
		if (g.getGameOver())
		{
			System.out.println("***********");
			System.out.println("*GAME OVER*");
			System.out.println("***********");
			System.out.println("You just got caught!");
			return false;
		}
		if (g.checkVictory()) {
			System.out.println("YOU WIN");
			return true;
		}
		return false;
	}
	
	/**
	 * Prints map.
	 *
	 * @param map
	 *            the map
	 */
	public static void printMap(Map map)
	{
		for (int i = 0; i < map.getMap().length; i++) {
			for (int j = 0; j < map.getMap()[i].length; j++) {
				System.out.print(map.getMap()[i][j] + " ");
			}
			System.out.println();
		}
	}
}
