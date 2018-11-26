package java11_26;

import java.io.IOException;
import java.io.LineNumberInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.INTERNAL;

public class Main {


	public static List<Uzemanyag> beolvasasLista(String filename) {
		List<Uzemanyag> listaArak = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get(filename));
			for (String sor : beolvas) {
				String[] split = sor.split(";");

				Uzemanyag o = new Uzemanyag(split[0].toString(), Integer.parseInt(split[1]), Integer.parseInt(split[2]));

				listaArak.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		return listaArak;
	}

	
	public static void main(String[] args) throws IOException {
		List<Uzemanyag> uzanyag= beolvasasLista("uzemanyag.txt");
		uzanyag.forEach(System.out::println);
		System.out.println("3. Feladat: Változások száma: "+uzanyag.size());
		
		
		//SAJÁT MEGOLDÁS
		/*int legkisebb=1000;
		int db=0;
		
		for(Uzemanyag uz : uzanyag)
		{
			
			if(Math.abs(uz.getBenzin()-uz.getDiesel())<legkisebb)
			{
				legkisebb=Math.abs(uz.getBenzin()-uz.getDiesel());
				if(Math.abs(uz.getBenzin()-uz.getDiesel())==legkisebb)
				{
					db++;
				}
			}
		}
		System.out.println("4.Feladat: A legkisebb különbség: "+legkisebb);
		System.out.println("5. Feladat: A legkisebb különbség("+legkisebb+") "+ db+" alkalommal fordult elõ!");*/
		
		int kulonbseg= Integer.MAX_VALUE;
		
		
		for(Uzemanyag uz: uzanyag)
		{
			if(Math.abs(uz.getBenzin()-uz.getDiesel())<kulonbseg)
			{
				kulonbseg=Math.abs(uz.getBenzin()-uz.getDiesel());
			}
		}
		System.out.println("4.Feladat: A legkisebb különbség: "+kulonbseg);
		int db=0;
		for(Uzemanyag uz: uzanyag)
		{
			if(Math.abs(uz.getBenzin()-uz.getDiesel())==kulonbseg)
				db++;
		}
		
		System.out.println("5. Feladat: A legkisebb különbség("+kulonbseg+") "+ db+" alkalommal fordult elõ!");
		
		boolean arvaltozas=false;
		for(Uzemanyag uz: uzanyag)
		{
			String[] datum = uz.getDatum().split("\\.");
			if(Integer.parseInt(datum[0])%4==0 && datum[1].equals("02") && datum[2].equals("24"))
				arvaltozas=true;
		}
		System.out.println(arvaltozas ?"6.Feladat: Volt változása szökõnapon!" : "6. Feladat: Nem volt változás szökõnapon!");
		
		final double EURO=307.7;
		String fajlba="";
		for(Uzemanyag uz:uzanyag)
		{
			fajlba+=uz.getDatum()+";"+new DecimalFormat("0.00").format((uz.getBenzin()/EURO))+";"+new DecimalFormat("0.00").format((uz.getDiesel()/EURO))+"\n";
		}
		Files.write(Paths.get("euro.txt"), fajlba.getBytes());
		
		int evszam=0;
		Scanner sc=new Scanner(System.in);
		do 
		{
			System.out.println("8. Feladat: Kérem adja meg az évszámot [2011..2016]: ");
			evszam=sc.nextInt();
		}
		while(evszam<2011 || evszam>2016);
		
		
		int max=Integer.MIN_VALUE;
		for (int i = 1; i < uzanyag.size(); i++) {

			if (Integer.parseInt(uzanyag.get(i).getDatum().substring(0, 4)) == evszam) {
				if (Integer.parseInt(uzanyag.get(i - 1).getDatum().substring(0, 4)) == evszam) {
					if (uzemanyagArValtozas(uzanyag.get(i), uzanyag.get(i - 1)) > max) {
						max = uzemanyagArValtozas(uzanyag.get(i), uzanyag.get(i - 1));
					}
				}
			}
		}
		
		
	}
	public static int uzemanyagArValtozas(Uzemanyag aktualis, Uzemanyag elozo) {

		int[] napokSzama = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] aktualisDatum = aktualis.getDatum().split("\\.");
		String[] elozoDatum = elozo.getDatum().split("\\.");

		int aktualisEv = Integer.parseInt(aktualisDatum[0]);
		int aktualisHonap = Integer.parseInt(aktualisDatum[1]);
		int aktualisNap = Integer.parseInt(aktualisDatum[2]);
		int elozoHonap = Integer.parseInt(aktualisDatum[1]);
		int elozoNap = Integer.parseInt(aktualisDatum[2]);

		if (aktualisEv % 4 == 0) {
			napokSzama[1] = 29;
		}

		if (aktualisHonap == elozoNap) {
			return aktualisNap - elozoNap;
		}

		return napokSzama[elozoHonap - 1] - elozoNap + aktualisNap;
	}

}
