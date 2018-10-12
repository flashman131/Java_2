package java_Beolvasas_5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
		public static void main(String[] args)
		{
			Scanner beolvas=new Scanner(System.in);
			try
			{
				System.out.println("1) szám: ");
				int sz1=beolvas.nextInt();
				
				System.out.println("2) szám: ");
				int sz2=beolvas.nextInt();
				
				System.out.println("3) szám: ");
				int sz3=beolvas.nextInt();
				
				System.out.println("4) szám: ");
				int sz4=beolvas.nextInt();
				
				System.out.println("5) szám: ");
				int sz5=beolvas.nextInt();
				
				double hanyados=(double)sz2/sz1;
				
				if(sz3/sz2==hanyados && sz4/sz3==hanyados && sz5/sz4==hanyados)
				{
					System.out.println("Mértani sorozat!");
				}
				else
				{
					System.out.println("Nem mértani sorozat!");
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Hibás szám formátum! \n Számot kérek!");
			}
			catch(Exception e)
			{
				System.err.println("Hiba történt a programban.");
			}
		}

}
