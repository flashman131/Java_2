package java_Beolvasas_4;

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
				
				if(sz3==sz1+sz2 && sz4==sz2+sz3 && sz5==sz3+sz4)
				{
					System.out.println("Fibonacci sorozat!");
				}
				else
				{
					System.out.println("Nem Fibonacci sorozat!");
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