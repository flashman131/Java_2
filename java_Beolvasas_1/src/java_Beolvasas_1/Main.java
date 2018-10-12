package java_Beolvasas_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
		public static void main(String[] args)
		{
			Scanner beolvas=new Scanner(System.in);
			int szam=0;
			int szamlalo=0;
			try 
			{
				while(szam!=11)
				{
					System.out.println("Adj meg számokat: ");
					szam=beolvas.nextInt();
					szamlalo++;
				}
				System.out.println("A 11 a(z)"+szamlalo+". volt!");
			}
			catch(InputMismatchException e)
			{
				System.err.println("Nem számot adtál meg!");
			}
			catch(Exception e)
			{
				System.out.println("Hiba történt a programban");
			}
		}

}
