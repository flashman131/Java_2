package java_Beolvasas_3;

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
				
				int max=sz1;
				if(sz2>max)
					max=sz2;
				if(sz3>max)
					max=sz3;
				
				System.out.println("A legnagyobb szám: "+max);
				
				if(sz1%3==0 && sz2 % 3==0 && sz3 % 3==0)
				{
					System.out.println("Mind a három szám osztható 3-mal");
				}
				else
				{
					System.out.println("Nem osztható mind 3-mal!");
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
