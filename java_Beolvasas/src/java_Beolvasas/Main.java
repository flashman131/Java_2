package java_Beolvasas;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
		public static void main(String[] args)
		{
			Scanner beolvas=new Scanner(System.in);
//			System.out.println("K�rek egy sz�");
//			String beolvasottadat=beolvas.nextLine();  //<-t�bb adat, 1db eset�n .next();
//			System.out.println(beolvasottadat);
//			beolvas.close();
			
			try
			{
				System.out.print("K�rek egy sz�mot: ");
				int szam=beolvas.nextInt();
				double eredmeny= (double)1/szam;
				System.out.println("A sz�m reciproka:");
				System.out.println(eredmeny);
			}
			catch(InputMismatchException e)
			{
				System.out.println("Hib�s sz�m form�tum! \n Sz�mot k�rek!");
			}
			beolvas.close();
			
		}

}
