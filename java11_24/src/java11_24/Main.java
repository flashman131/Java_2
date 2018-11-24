package java11_24;

import java.awt.FontFormatException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	
	
	public static <K, V extends Comparable<? super V>> TreeMap<K, V> rendez(TreeMap<K, V> a) {
		TreeMap<K, V> sortByValue = new TreeMap<>(new Comparator<K>() {
			@Override
			public int compare(K o1, K o2) {
				int compare = a.get(o2).compareTo(a.get(o1));
				if (compare == 0) {
					return 1;
				} else {
					return compare;
				}

			}
		});
		sortByValue.putAll(a);
		return sortByValue;
	}






	

	public static List<Versenyzo> listaNev(String filename) {
		List<Versenyzo> listaNev = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get(filename));
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(";");

				Versenyzo o = new Versenyzo(split[0].toString(), split[1].toString(),
						Double.parseDouble(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]));

				listaNev.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasásnál!"+e);
		}
		return listaNev;
	}

	public static double OsszPontszam(String versenyzoNev, List<Versenyzo> rovid,List<Versenyzo> donto)
	{
		double osszpont=0;
		for(Versenyzo v:rovid)
		{
			if(v.getNev().equals(versenyzoNev))
			{
				osszpont=v.getTechnikaiPontszam()+v.getKomponensPontszam()-v.getHibapont();
			}
		}
		for(Versenyzo v:donto)
		{
			if(v.getNev().equals(versenyzoNev))
			{
				osszpont+=v.getTechnikaiPontszam()+v.getKomponensPontszam()-v.getHibapont();
			}
		}
		
		return osszpont;
	}
	
	
	
	public static void main(String[] args) {
		//1. FELADAT
		List<Versenyzo> versenyzokLista = listaNev("rovidprogram.csv");
		List<Versenyzo> dontosokLista=listaNev("donto.csv");
		versenyzokLista.forEach(System.out::println);
		dontosokLista.forEach(System.out::println);
		
		//2.FELADAT
		System.out.println("2. feladat (Versenyzõk száma):"+ versenyzokLista.size());
		//3.FELADAT
		boolean magyar=false;
		
		for(Versenyzo versenyzo:dontosokLista)
		{
			if(versenyzo.getOrszag().equals("HUN"))
			{
				magyar=true;
			}
		}
		
		if(magyar)
		{
			System.out.println("3. feladat) Bejutott a magyar versenyzõ");
		}
		else
			System.out.println("3. feladat) Nem jutott be a magyar versenyzõ");
		//4.FELADAT OsszPont fgv
		//System.out.println(OsszPontszam("Ivett TOTH", versenyzokLista, dontosokLista));
		
		//5.FELADAT
		
		System.out.println("Adja meg a keresett versenyzõ nevét: ");
		Scanner scanner=new Scanner(System.in);
		
		String bekertNev=scanner.nextLine();
		boolean letezik=false;
		
		for(Versenyzo v:versenyzokLista)
		{
			if(v.getNev().equals(bekertNev))
				letezik=true;
		}
		if(letezik)
			System.out.println("Van ilyen versenyzõ!");
		else
			System.out.println("Nincs ilyen versenyzõ!");
		
		//6.FELADAT
		System.out.println(OsszPontszam(bekertNev, versenyzokLista, dontosokLista));
		
		
		//7.FELADAT
		
		Map<String, Integer> map=new HashMap<>();
		for(Versenyzo v: dontosokLista)
		{
			map.merge(v.getOrszag(), 1, Integer::sum);
		}
		
		map.forEach((k,v)->
		{
			if(v>1)
				System.out.println(k+ " : "+v);
		});
		
		//7.FELADAT 2. MEGOLDÁS
		Map<String, Integer> map2=new TreeMap<>();
		for(Versenyzo v : dontosokLista)
		{
			int szamol=map2.containsKey(v.getOrszag()) ? map2.get(v.getOrszag()) : 0;
			map2.put(v.getOrszag(), szamol+1);
		}
		map2.forEach((k,v)->
		{
			if(v>1)
				System.out.println(k+" : "+v);
		});		
		
		
		//8.FELADAT
		TreeMap<String, Double> vegeredmeny=new TreeMap<>();
		for(Versenyzo v: dontosokLista)
		{
			vegeredmeny.put(v.getNev()+";"+v.getOrszag(), OsszPontszam(v.getNev(), versenyzokLista, dontosokLista));
		}
		vegeredmeny=rendez(vegeredmeny);
		
		int i=1;
		String fajlba="";
		for(Map.Entry<String, Double> e : vegeredmeny.entrySet())
		{
			fajlba+=i++ +";"+e.getKey()+";"+ new DecimalFormat("0.00").format(e.getValue())+"\n";
		}
		try {
			Files.write(Paths.get("vegeredmeny.csv"), fajlba.getBytes());
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
	}

}
