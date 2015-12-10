package ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FuckingLostElf {

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
		int i = 150;
		int j = 150;
		cenas[i][j] = true;
		int distributed = 1;
		while(scf.hasNextLine()){
			String line = scf.nextLine();
			for(int k = 0; k < line.length(); k++){
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
			}
		}
		System.out.println(distributed);
	}
}
