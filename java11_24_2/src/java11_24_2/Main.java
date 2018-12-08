package java11_24_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {

	public static Scanner sc= new Scanner(System.in);
	
	

	public static <K, V extends Comparable<? super V>> Map<K, V> rendez(Map<K, V> a) {
		Map<K, V> sortByValue = new TreeMap<>(new Comparator<K>() {
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

	public static List<Nyelvek> listaNev(String fileNev) {
		List<Nyelvek> vizsgak = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get(fileNev));
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(";");
				
				List<Integer> evek=new ArrayList<>();
				for(int i=1; i<split.length; i++)
				{
					evek.add(Integer.parseInt(split[i]));
				}
				
				Nyelvek o = new Nyelvek(split[0], evek);

				vizsgak.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		return vizsgak;
	}

	public static void main(String[] args) {
		List<Nyelvek> sikeres=listaNev("sikeres.csv");
		List<Nyelvek> sikertelen=listaNev("sikertelen.csv");
		Map<String, Integer> szum= new LinkedHashMap<>();
		//sikertelen.forEach(System.out::println);
		
		
		System.out.println("2. Feladat: ");
		for(Nyelvek siker: sikeres) {
			for(Integer nyelv: siker.getEvek()) {
				szum.merge(siker.getNyelv(), nyelv, Integer::sum);
			}
		}
		
		for(Nyelvek telen: sikertelen) {
			for(Integer nyelv: telen.getEvek()) {
				szum.merge(telen.getNyelv(), nyelv, Integer::sum);
			}
		}
		
		szum=rendez(szum);
		int i=0;
		for(String nyelvizsga : szum.keySet())
		{
			if(i<3)
			{
				System.out.println(nyelvizsga);
				i++;
			}
		}
		
		
		
		int szam;
		boolean joszam=false;
		System.out.println("Kérek egy évszámot: ");
		do {
			szam= sc.nextInt();
			if(szam<2018 && szam>2008)
				joszam=true;
			
		} while(joszam!=true);
		
		System.out.println("3. Feladat: A beírt év:"+szam);
		
		
		for(Nyelvek)
	}

}
