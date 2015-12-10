package ex6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FuckingEatItNeighbors {
	
	static boolean[][] ligths = new boolean[1000][1000];
	
	public static void main(String args[]) throws FileNotFoundException{
		
		File toRead = new File("./src/ex6/test.txt");
		Scanner scf = null;
		
		scf = new Scanner(toRead);
		
		while(scf.hasNextLine()){
			String[] splited = scf.nextLine().split("[ ,]");
			if(splited[0].equalsIgnoreCase("toggle"))
					toggle(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]),
							Integer.parseInt(splited[4]), Integer.parseInt(splited[5]));
			else 
				if(splited[1].equalsIgnoreCase("on"))
					turnON(Integer.parseInt(splited[2]), Integer.parseInt(splited[3]), 
							Integer.parseInt(splited[5]), Integer.parseInt(splited[6]));
				else
					turnOFF(Integer.parseInt(splited[2]), Integer.parseInt(splited[3]), 
							Integer.parseInt(splited[5]), Integer.parseInt(splited[6]));
		}
		int lit = 0;
		for(int i = 0; i < ligths.length; i++)
			for(int j = 0; j < ligths[i].length; j++)
				if(ligths[i][j] == true)
					lit++;
		System.out.println(lit);
		
		
		
	}
	private static void toggle(int x1, int y1, int x2, int y2){
		for(int i = x1; i <= x2; i++)
			for(int j = y1; j<= y2; j++)
				ligths[i][j] = !ligths[i][j];
	}
	private static void turnON(int x1, int y1, int x2, int y2){
		for(int i = x1; i <= x2; i++)
			for(int j = y1; j<= y2; j++)
				ligths[i][j] = true;
	}
	private static void turnOFF(int x1, int y1, int x2, int y2){
		for(int i = x1; i <= x2; i++)
			for(int j = y1; j<= y2; j++)
				ligths[i][j] = false;
	}
}
