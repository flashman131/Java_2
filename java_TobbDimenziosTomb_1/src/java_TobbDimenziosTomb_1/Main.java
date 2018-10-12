package java_TobbDimenziosTomb_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner beolvas=new Scanner(System.in);
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Adja meg a tömb hosszát");
			int hossz=beolvas.nextInt();
			
			float[] szamok=new float[hossz];
			
			for(int i=0;i<szamok.length;i++)    //Körbejárás
			{
				System.out.print((i+1)+"Adj egy számot:");  // felhasználó számára szöveg
				szamok[i]=beolvas.nextFloat();  // tömb értékadás
			}
			
			System.out.println("A számok amiket bekértünk: ");
			for(int i=0;i<szamok.length;i++)
			{
				System.out.println(szamok[i]+", ");
			}
		}
		catch(InputMismatchException e)
		{
			System.err.println("Nem számot adtál meg!");
		}
		catch(Exception e)
		{
			System.err.println("Hiba a program közben");
		}
	}
}
