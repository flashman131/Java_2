package biciklitura_Gyakorlas_12_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	private static Scanner sc=new Scanner(System.in);
	private static int magas;
	public static List<Helyszin> listHelyszin() {
		List<Helyszin> listHelyszin = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("kerekpar.csv"));
			magas=Integer.parseInt(beolvas.get(0));
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(";");

				Helyszin o = new Helyszin(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));

				listHelyszin.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		return listHelyszin;
	}

	public static void main(String[] args) throws IOException {
		List<Helyszin> listHelyek=listHelyszin();
		//listHelyek.forEach(System.out::println);
		System.out.println("2. feladat: Helyszínek száma: "+listHelyek.size()+" db.");
		
		int tav=0;
		for(Helyszin h : listHelyek)
		{
			tav+=h.getH1()+h.getH2()+h.getH3();
		}
		System.out.println("3. feladat: A versenysorozat teljes hossza: "+tav+" km.");
		System.out.println("4. feladat: Adjon meg egy (balatoni) városnevet: ");
		String varosnev=sc.nextLine();
		boolean van=false;
		int h1=0,h2=0,h3=0;
		for(Helyszin h : listHelyek)
		{
			if(h.getHnev().equals(varosnev))
			{
				van=true;
				h1=h.getH1();
				h2=h.getH2();
				h3=h.getH3();
			}				
		}
		if(!van)
		{
			System.out.println("Ez a város nem szerepel a verseny állomásai között!");
		}
		else
		{
			System.out.println("Az adott város versenyszakaszai: "+h1+"km, "+h2+"km, "+h3+" km.");
		}
		
		System.out.println("5. kimaradt láma vagyok!");
		
		double eredmeny=0;
		double szazalek=0;
		double max =0;
		String fajlba="";
		
		for(Helyszin h: listHelyek)
		{
			max+=h.getH1();
			eredmeny+=(h.getH1()+h.getH2()+h.getH3());
			szazalek=eredmeny/tav*100;
			fajlba+=h.getHnev()+szazalek+"\n";
			
		}
		double arany=max/listHelyek.size();
		System.out.println(new DecimalFormat("0.0").format(arany));
		
		
		Files.write(Paths.get("statisztika.txt"), fajlba.getBytes());
		

	}

}
