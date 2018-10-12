package java_Beolvasas_2;
import java.util.Scanner;

public class Main {
		public static void main(String[] args)
		{
			System.out.println("Adjon meg egy számot: ");
			Scanner beolvas=new Scanner(System.in);
			int szam=beolvas.nextInt();
			boolean paros=(szam%2==0);
			if(szam%3==0)
			{
				if(paros)
				{
					System.out.println("A szám osztható 2-vel és 3-mal is!");
				}
				else
				{
					System.out.println("A szám osztható 3-mal!");
				}
			}
			else
			{
				if(paros)
				{
					System.out.println("A szám osztható 2-vel");
				}
				else
				{
					System.out.println("A szám nem osztható 2-vel se 3-mal!");
				}
			}
			
		}

}