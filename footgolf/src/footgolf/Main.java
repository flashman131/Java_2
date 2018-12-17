package footgolf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	

	public static List<Versenyzok> lista() {
		List<Versenyzok> lista = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("fob2016.txt"));
			for (String sor : beolvas) {
				String[] split = sor.split(";");
				
				List<Integer> fordulok=new ArrayList<>();
				for(int i=3; i<split.length;i++)
				{
					fordulok.add(Integer.parseInt(split[i]));
				}

				Versenyzok o = new Versenyzok(split[0],split[1],split[2],fordulok);

				lista.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		return lista;
	}

	public static int egyeniOsszpontszam(Versenyzok versenyzo)
	{
		int sum=0;
		List<Integer> rendezett = versenyzo.getFordulok();
		Collections.sort(rendezett);
		
		for(int i=2;i<rendezett.size();i++)
		{
			sum+=rendezett.get(i);
		}
		if(rendezett.get(0) !=0)
			sum+=10;
		if(rendezett.get(1)!=0)
			sum+=10;
		
		return sum;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		List<Versenyzok> a=lista();
		//a.forEach(System.out :: println);
		
		System.out.println("3. feladat: A versenyzõk száma: "+a.size());
		
		int nokdb=0;
		for(Versenyzok v : a)
		{
			if(v.getKategoria().equals("Noi"))
			{
				nokdb++;
			}
		}
		
		System.out.println("3. feladat: A nõi versenyzõk aránya: "
							+ new DecimalFormat("0.00").format(((double) nokdb/a.size())*100)+" %");
		
		int max=Integer.MIN_VALUE;
		Versenyzok noi=null;
		
		for(Versenyzok v: a) 
		{
			if(v.getKategoria().equals("Noi"))
				if(max<egyeniOsszpontszam(v))
				{
					max=egyeniOsszpontszam(v);
							noi=v;
				}
		}
		System.out.println("6. feladat: A bajnok nõi versenyzõ");
		System.out.println("\tNév: "+ noi.getNev());
		System.out.println("\tEgyesület: " + noi.getEgyesulet());
		System.out.println("\tÖsszpontszám: " +max);
		
		
		String fajlba="";
		for(Versenyzok v: a)
		{
			if(v.getKategoria().equals("Felnott ferfi"))
			{
				fajlba+=v.getNev()+";"+egyeniOsszpontszam(v)+"\n";
			}

		}
		Files.write(Paths.get("osszpontFF.txt"), fajlba.getBytes());
		
		TreeMap<String, Integer> statisztika = new TreeMap<>();
		for (Versenyzok v : a) {
			statisztika.merge(v.getEgyesulet(), 1, Integer::sum);
		}
		System.out.println("8.feladat: Egyesület statisztika");
		statisztika.remove("n.a.");
		for (Entry<String, Integer> v : statisztika.entrySet()) {
			if(v.getValue() >= 3) {
				System.out.println("\t" + v.getKey() + " - " + v.getValue());
			}
		}
	}

}
