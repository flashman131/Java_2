package java_Beolvasas_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
		public static void main(String[] args)
		{
			Scanner beolvas=new Scanner(System.in);
			try
			{
				System.out.println("1) sz�m: ");
				int sz1=beolvas.nextInt();
				
				System.out.println("2) sz�m: ");
				int sz2=beolvas.nextInt();
				
				System.out.println("3) sz�m: ");
				int sz3=beolvas.nextInt();
				
				int max=sz1;
				if(sz2>max)
					max=sz2;
				if(sz3>max)
					max=sz3;
				
				System.out.println("A legnagyobb sz�m: "+max);
				
				if(sz1%3==0 && sz2 % 3==0 && sz3 % 3==0)
				{
					System.out.println("Mind a h�rom sz�m oszthat� 3-mal");
				}
				else
				{
					System.out.println("Nem oszthat� mind 3-mal!");
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Hib�s sz�m form�tum! \n Sz�mot k�rek!");
			}
			catch(Exception e)
			{
				System.err.println("Hiba t�rt�nt a programban.");
			}
		}

}
