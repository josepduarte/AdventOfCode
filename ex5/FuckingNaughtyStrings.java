package ex5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FuckingNaughtyStrings {

	@SuppressWarnings("resource")
	public static void main(String args[]) throws FileNotFoundException{
		
		File toRead = new File("./src/ex5/test.txt");
		Scanner scf = null;
		
		scf = new Scanner(toRead);
		
			
		int count = 0;
		
		while(scf.hasNextLine()){
			String s = scf.nextLine();
			if(isGoodString(s))
				count++;		
		}
		System.out.println("Parte 1");
		System.out.println(count);
		System.out.println("Parte 2");
		int count2 = 0;
		scf = new Scanner(toRead);
		while(scf.hasNextLine()){
			String s = scf.nextLine();
			if(isGoodStringPart2(s))
				count2++;		
		}
		System.out.println(count2);
	}
	private static boolean isGoodString(String s){
		if(s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy"))
				return false;
		
		int twiceInARow = 0;
		for(int i = 0; i < s.length() - 1;  i++)
			if(s.charAt(i) == s.charAt(i+1))
				twiceInARow++;
		if(twiceInARow == 0)
			return false;
		
		int vowels = 0;
		for(int i = 0; i < s.length();  i++)
			if(s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || 
					s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'o' || s.charAt(i) == 'O' ||
							s.charAt(i) == 'u' || s.charAt(i) == 'U')
				vowels++;
		if(vowels < 3)
			return false;
		
		return true;
		
	}
	private static boolean isGoodStringPart2(String s){
		//
		int count = 0;
		for(int i = 1; i < s.length()-1; i++){
			if(s.charAt(i-1) == s.charAt(i+1))
				count++;
		}
		if(count == 0)
			return false;
		count = 0;
		for(int i = 0; i < s.length() - 1; i++)
			if(s.substring(i+2).contains(Character.toString(s.charAt(i)) + Character.toString(s.charAt(i+1))))
				count++;
		if(count == 0)
			return false;
		
		return true;
	}
}
