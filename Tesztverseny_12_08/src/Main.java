import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static Scanner sc= new Scanner(System.in);
	public static String helyes;
	
	
	public static List<Versenyzo> versenyzok() {
		List<Versenyzo> versenyzok = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("valaszok.txt"));
			helyes=beolvas.get(0);
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(" ");

				Versenyzo o = new Versenyzo(split[0],split[1]);

				versenyzok.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvas�sn�l!");
		}
		return versenyzok;
	}

	
	public static void main(String[] args) {
		List<Versenyzo> versenyzok= versenyzok();
		
		versenyzok.forEach(System.out :: println);
		
		System.out.println("2. feladat: A vet�lked�n "+versenyzok.size()+" versenyz� indult!");
		
		System.out.println("K�rem adjon meg egy azonos�t�t: ");
		String azon=sc.nextLine();
		String eredmeny=null;
		for(Versenyzo v: versenyzok)
		{
			if(v.getAzon()==azon)
			{
				eredmeny=v.getValasz();
			}
		}
		System.out.println("3. feladat: A versenyz� azonos�t�ja: "+azon+"\n"+ eredmeny + "\t(a versenyz� v�lasza)");
		
		System.out.println("Helyes v�lasz: "+helyes);
		
	}

}
