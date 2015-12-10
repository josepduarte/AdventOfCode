package ex4;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FuckingAdventCoins {
	
	public static void main(String args[]) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		StringBuilder sbuilder;
		boolean discovered = false;
		int toAdd = 0;
		String s;
		StringBuffer sb;
		do{
			System.out.println(toAdd);
			toAdd++;
			sbuilder = new StringBuilder("yzbqklnj");
			s = sbuilder.append(Integer.toString(toAdd)).toString();
			//System.out.println(s);
			MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(s.getBytes());

		    byte byteData[] = md.digest();

		    sb = new StringBuffer();
		    for (int i = 0; i < byteData.length; i++)
		        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		    
		    
		    if(sb.toString().substring(0, 6).equals("000000"))
		    	discovered = true;
		 
		}while(!discovered);
		
		System.out.println(sb.toString()); //in hex
		System.out.println(toAdd);
	}
}
