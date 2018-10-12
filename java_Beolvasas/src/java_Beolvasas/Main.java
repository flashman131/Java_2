package java_Beolvasas;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
		public static void main(String[] args)
		{
			Scanner beolvas=new Scanner(System.in);
//			System.out.println("Kérek egy szó");
//			String beolvasottadat=beolvas.nextLine();  //<-több adat, 1db esetén .next();
//			System.out.println(beolvasottadat);
//			beolvas.close();
			
			try
			{
				System.out.print("Kérek egy számot: ");
				int szam=beolvas.nextInt();
				double eredmeny= (double)1/szam;
				System.out.println("A szám reciproka:");
				System.out.println(eredmeny);
			}
			catch(InputMismatchException e)
			{
				System.out.println("Hibás szám formátum! \n Számot kérek!");
			}
			beolvas.close();
			
		}

}
