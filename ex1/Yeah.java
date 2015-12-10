package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Yeah {

	public static void main(String args[]){
		
		int floor = 0;
		
		
		File toRead = new File("./src/ex1/test.txt");
		Scanner scf = null;
	
		try {
			scf = new Scanner(toRead);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scf.hasNextLine()){
			String line = scf.nextLine();
			int i = 0;
			for(i = 0; i < line.length(); i++){
				if(line.charAt(i) == '(')
					floor++;
				if(line.charAt(i) == ')')
					floor--;
				if(floor == -1)
					System.out.println(i);
			}
		}
		System.out.println(floor);
	}
}
