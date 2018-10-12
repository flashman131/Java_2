package java_TobbDimenziosTomb;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner beolvas=new Scanner(System.in);
	
			public static void main(String[] args)
			{
				try
				{
					int[] szamok=new int[10];
					for(int i=0;i<szamok.length;i++)    //Körbejárás
					{
						System.out.print((i+1)+"Adj egy számot:");  // felhasználó számára szöveg
						szamok[i]=beolvas.nextInt();  // tömb értékadás
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
