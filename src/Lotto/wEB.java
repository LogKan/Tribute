package Lotto;

import java.net.URL;
import java.util.Scanner;

public class wEB {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	        Scanner scanner = new Scanner(new URL("http://www.lotto.ch/").openStream());
	        while(scanner.hasNextLine()){
	            System.out.println(scanner.nextLine());
	        }
	        scanner.close();
	    }
	}
	
	
