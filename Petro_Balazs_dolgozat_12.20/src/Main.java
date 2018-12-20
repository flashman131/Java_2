import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	

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
	

	public static List<Versenyzo> lista() {
		List<Versenyzo> listaNev = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("forma1.csv"));
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(";");

				Versenyzo o = new Versenyzo(split[0],split[1],split[2],split[3],
						Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]));

				listaNev.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvas�sn�l!");
		}
		return listaNev;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("1. feladat: Az adatok beolvasva, elt�rolva.");
		List<Versenyzo> versenyzok= lista();
		//versenyzok.forEach(System.out :: println);
		System.out.println("2. feladat: �sszesen "+versenyzok.size()+" adatot tartalmaz az �llom�ny!");
		
		///////HARMADIK FELADAT!
		System.out.println("Az els� 10 aut� adatai:");
		int masodpercben;
		for(int i=0;i<10;i++)
		{
			masodpercben=(versenyzok.get(i).getPerc()*60)+(versenyzok.get(i).getMasodperc());
			String ido= masodpercben+"."+versenyzok.get(i).getTizedmasodperc();
			System.out.println(versenyzok.get(i).getAuto()+" - "+versenyzok.get(i).getCsapat()+" - "+ido);
			masodpercben=0;
			ido="";
		}
		////NEGYEDIK FELADAT!
		List<String> konstruktorok = new ArrayList<>();
		
		for(Versenyzo v : versenyzok)
		{
			if(!konstruktorok.contains(v.getKonstruktor()))
			{
				konstruktorok.add(v.getKonstruktor());
			}
		}
		System.out.println("A verseny konstruktorai: ");
		konstruktorok.forEach(System.out :: println);
		System.out.println("�sszesen: "+konstruktorok.size()+ " konstrukt�r szerepel az adatok k�z�tt.");
		
		///�T�DIK FELADAT!
		/*5.�A�versenyen�4.381�km�t�vols�got�teljes�tenek�k�r�nk�nt.�Adja�meg�a�3 leggyorsabb�pil�ta�nev�t��s��tlagsebess�g�t.�
		 * A�megold�s�t�km/h�(km/�ra) egys�gben�adja�meg,�a�sz�mol�sn�l�vegye�figyelembe�perc,�m�sodperc��s ezredm�sodperc��rt�keit�is!*/
		//// V=S/T 
		//s=4.381
		TreeMap<String, String> sebesseg = new TreeMap<>();
		for (Versenyzo v : versenyzok) {
			double ido=((v.getPerc()*60)+v.getMasodperc()+ (double)v.getTizedmasodperc()/1000)/3600;
			double atlseb=(4.381/ido);
			String seb= new DecimalFormat("0").format(atlseb);
			//int vegseb=(int) Math.ceil(atlseb);
			sebesseg.put(v.getPilota(),seb);
		}
		sebesseg=(TreeMap<String, String>) rendez(sebesseg);
		System.out.println("5.�feladat:�Az�els �3�leggyorsabb�aut�pil�t�ja��s� � �tlagsebess�ge:");
		int db=0;
		for(Map.Entry<String, String> entry : sebesseg.entrySet())
		{
			db++;
			if(db<4)
			{
				System.out.println(entry +"km/h");
			}
		}
		
		///HATODIK FELADAT
		String fajlba="";
		for(Versenyzo v: versenyzok)
		{
			double ido=((v.getPerc()*60)+v.getMasodperc()+ (double)v.getTizedmasodperc()/1000)/3600;
			double atlseb=(4.381/ido);
			String seb= new DecimalFormat("0").format(atlseb);
			
			fajlba+=v.getAuto()+";"+v.getKonstruktor()+";"+v.getCsapat()+";"+v.getPilota()+";"+seb+" km/h"+"\n";
		}
		Files.write(Paths.get("korido.txt"),fajlba.getBytes());
		System.out.println("A f�jlba �r�s megt�rt�nt!");
		
	}

}
