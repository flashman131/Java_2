package java_Beolvasas_2;
import java.util.Scanner;

public class Main {
		public static void main(String[] args)
		{
			System.out.println("Adjon meg egy sz�mot: ");
			Scanner beolvas=new Scanner(System.in);
			int szam=beolvas.nextInt();
			boolean paros=(szam%2==0);
			if(szam%3==0)
			{
				if(paros)
				{
					System.out.println("A sz�m oszthat� 2-vel �s 3-mal is!");
				}
				else
				{
					System.out.println("A sz�m oszthat� 3-mal!");
				}
			}
			else
			{
				if(paros)
				{
					System.out.println("A sz�m oszthat� 2-vel");
				}
				else
				{
					System.out.println("A sz�m nem oszthat� 2-vel se 3-mal!");
				}
			}
			
		}

}