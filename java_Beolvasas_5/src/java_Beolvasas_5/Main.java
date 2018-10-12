package java_Beolvasas_5;

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
				
				System.out.println("4) sz�m: ");
				int sz4=beolvas.nextInt();
				
				System.out.println("5) sz�m: ");
				int sz5=beolvas.nextInt();
				
				double hanyados=(double)sz2/sz1;
				
				if(sz3/sz2==hanyados && sz4/sz3==hanyados && sz5/sz4==hanyados)
				{
					System.out.println("M�rtani sorozat!");
				}
				else
				{
					System.out.println("Nem m�rtani sorozat!");
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
