package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FuckingPaper {
	
	public static void main(String args[]){
		
		File toRead = new File("./src/ex2/test.txt");
		Scanner scf = null;
		
		try {
			scf = new Scanner(toRead);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int paper = 0;
		while(scf.hasNextLine()){
			int min = Integer.MAX_VALUE;
			String[] splited = scf.nextLine().split("x");
			if(Integer.parseInt(splited[0])*Integer.parseInt(splited[1]) < min)
				min = Integer.parseInt(splited[0])*Integer.parseInt(splited[1]);
			if(Integer.parseInt(splited[0])*Integer.parseInt(splited[2]) < min)
				min = Integer.parseInt(splited[0])*Integer.parseInt(splited[2]);
			if(Integer.parseInt(splited[1])*Integer.parseInt(splited[2]) < min)
				min = Integer.parseInt(splited[1])*Integer.parseInt(splited[2]);
			
			paper += min + 2*Integer.parseInt(splited[0])*Integer.parseInt(splited[1]) + 2*Integer.parseInt(splited[0])*Integer.parseInt(splited[2])
					+ 2*Integer.parseInt(splited[1])*Integer.parseInt(splited[2]);
		}
		System.out.println(paper);
	}
}
