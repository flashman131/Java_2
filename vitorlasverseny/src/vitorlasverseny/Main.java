package vitorlasverseny;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	

	public static List<Hajok> lista() {
		List<Hajok> lista = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("kekszalag.csv"));
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(";");

				Hajok o = new Hajok(Integer.parseInt(split[0]),split[1],split[2],
						split[3],split[4],Integer.parseInt(split[5]),
						Integer.parseInt(split[6]),Integer.parseInt(split[7]));

				lista.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		return lista;
	}

	
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



	
	public static void main(String[] args) throws IOException {
		List<Hajok> hajo=lista();
		//hajok.forEach(System.out :: println);
		
		System.out.println("1. feladat: A beolvasás és tárolás kész!");
		System.out.println("2. feladat: Összesn "+hajo.size()+" adatot tartalmaz az állomány!");
		
		System.out.println("3. feladat: Az elsõ 10 hajó adatai: ");
		for (int i = 0; i < 10; i++) {
			int nap=hajo.get(i).getNap()*24*60;
			int ora=hajo.get(i).getOra()*60;
			int perc=hajo.get(i).getPerc();
			int sum=nap+ora+perc;
			
			System.out.println(hajo.get(i).getHajo()+" - "+hajo.get(i).getKlub()+" - "+sum+" perc");
		}
		Set<String> kategoriak= new HashSet<>();
		for(Hajok h: hajo)
		{
			kategoriak.add(h.getKategoria());
		}
		System.out.println("4. feladat: A verseny kategóriái: ");
		for(String s:kategoriak)
		{
			System.out.println(s);
		}
		System.out.println("Összesen "+kategoriak.size()+ " kategória szerepel az adatok között!");
		
		
		System.out.println("5. feladat: Az elsõ három hajó átlagsebessége: ");
		TreeMap<Integer, Double> atlagsebesseg=new TreeMap<>();
		int i=1;
		for(Hajok h: hajo)
		{
			double nap= h.getNap()*24;
			double ora=h.getOra();
			double perc= h.getPerc()/60;
			double sum=nap+ora+perc;
			double v=160/sum;
			atlagsebesseg.put(i++, v);
		}
		atlagsebesseg= rendez(atlagsebesseg);
		int j=0;
		for(Double d : atlagsebesseg.values())
		{
			if(j<3) 
			{
				System.out.println((j+1)+". "+new DecimalFormat("0.00").format(d)+" km/h");
				j++;
			}
		}
		int valami= (int)(atlagsebesseg.firstEntry().getKey()*60-433); 
		System.out.println("6. feladat: A leggyorsabb hajó "+ valami+" perccel maradt el az abszolút rekordtól.");
		String fajlba="";
		System.out.println("7. feladat: A fájlba írás sikeresen megtörtént!");
		for(Hajok h: hajo)
		{
			fajlba+=h.getHajo()+" "+h.getKlub()+" "+h.getNap()+" "+h.getOra()+" "+h.getPerc()+"\n";
		}
		
		Files.write(Paths.get("hajonevek.txt"), fajlba.getBytes());
		
	}

}
