package java_TobbDimenziosTomb_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner beolvas=new Scanner(System.in);
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Adja meg a t�mb hossz�t");
			int hossz=beolvas.nextInt();
			
			float[] szamok=new float[hossz];
			
			for(int i=0;i<szamok.length;i++)    //K�rbej�r�s
			{
				System.out.print((i+1)+"Adj egy sz�mot:");  // felhaszn�l� sz�m�ra sz�veg
				szamok[i]=beolvas.nextFloat();  // t�mb �rt�kad�s
			}
			
			System.out.println("A sz�mok amiket bek�rt�nk: ");
			for(int i=0;i<szamok.length;i++)
			{
				System.out.println(szamok[i]+", ");
			}
		}
		catch(InputMismatchException e)
		{
			System.err.println("Nem sz�mot adt�l meg!");
		}
		catch(Exception e)
		{
			System.err.println("Hiba a program k�zben");
		}
	}
}
