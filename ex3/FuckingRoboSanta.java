package ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FuckingRoboSanta {
public static void main(String args[]){
		
		File toRead = new File("./src/ex3/test.txt");
		Scanner scf = null;
		
		try {
			scf = new Scanner(toRead);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean[][] cenas = new boolean[10000][10000];
		//SANTA POSITIONS
		int i = 150;
		int j = 150;
		//ROBOT POSITION
		int ir = 150;
		int jr = 150;
		cenas[i][j] = true;
		int distributed = 1;
		while(scf.hasNextLine()){
			String line = scf.nextLine();
			for(int k = 0; k < line.length(); k += 2){
				switch(line.charAt(k)){
					case '^':
						j++;
						if(!cenas[i][j]){
							cenas[i][j] = true;
							distributed++;
						}
						break;
					case 'v':
						j--;
						if(!cenas[i][j]){
							cenas[i][j] = true;
							distributed++;
						}
						break;
					case '>':
						i++;
						if(!cenas[i][j]){
							cenas[i][j] = true;
							distributed++;
						}
						break;
					case '<':
						i--;
						if(!cenas[i][j]){
							cenas[i][j] = true;
							distributed++;
						}
						break;
				}
				switch(line.charAt(k+1)){
				case '^':
					jr++;
					if(!cenas[ir][jr]){
						cenas[ir][jr] = true;
						distributed++;
					}
					break;
				case 'v':
					jr--;
					if(!cenas[ir][jr]){
						cenas[ir][jr] = true;
						distributed++;
					}
					break;
				case '>':
					ir++;
					if(!cenas[ir][jr]){
						cenas[ir][jr] = true;
						distributed++;
					}
					break;
				case '<':
					ir--;
					if(!cenas[ir][jr]){
						cenas[ir][jr] = true;
						distributed++;
					}
					break;
			}
			}
		}
		System.out.println(distributed);
	}
}
