package kektura_12_08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static int tengerszintfeletti;

	public static List<Tura> tura() {
		List<Tura> turaList = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("kektura.csv"));
			
			tengerszintfeletti= Integer.parseInt(beolvas.get(0));
			
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(";");

				Tura o = new Tura(split[0], split[1], 
						Double.parseDouble(split[2].replaceAll(",",".")),
						Integer.parseInt(split[3]), 
						Integer.parseInt(split[4]), 
						split[5]);

				turaList.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		return turaList;
	}
	
	public static boolean hianyosnev(Tura t)
	{		
		if(t.getPecsetelohely().equals("i"))
			if(!(t.getVegpont().contains("pecsetelohely")))
			{
				return true;
			}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		List<Tura> tura=tura();
		System.out.println(tengerszintfeletti);
		
		System.out.println("3. feladat: Szakaszok száma: "+tura.size()+" db");
		double sum=0.0;
		double min=Double.MAX_VALUE;
		Tura legrovidebb = null;
		String hianyosallomas="";
		
		int vegpontM=tengerszintfeletti;
		int max= Integer.MIN_VALUE;
		Tura legmagasabb=null;
		
		for(Tura t: tura)
		{
			sum+= t.getHossz();
			if(t.getHossz()<min)
			{
				min=t.getHossz();
				legrovidebb=t;
			}
			if(hianyosnev(t)==true)
			{
				hianyosallomas += "\t"+t.getKiindulopont()+"\n";
			}
			
			vegpontM+=t.getEmelkedo()-t.getLejto();
			if(vegpontM>max)
			{
				max=vegpontM;
				legmagasabb=t;
			}
			
		}
		System.out.println("4. feladat: A túra teljes hossza: "+new DecimalFormat("0.000").format(sum)+" km.");
		
		System.out.println("5. feladat: Legrövidebb szakasz adatai: ");
		System.out.println("\tKezdet: "+legrovidebb.getKiindulopont());
		System.out.println("\tVég: "+legrovidebb.getVegpont());
		System.out.println("\tTávolság: "+legrovidebb.getHossz());
		
		System.out.println("7. feladat: Hiányos állomás nevek: \n"+ ((hianyosallomas.length()==0) ? "Nincs hiányos állomásnév!" : hianyosallomas));
		
		System.out.println("8. feladat: A túra legmagasabban fekvõ végpontja: ");
		System.out.println("\tA végpont neve: "+legmagasabb.getVegpont());
		System.out.println("\tA végpont tengerszintfeletti magassága: "+ max);
		
		String fajlba="192 \n";
		for(Tura t: tura)
		{
			if(hianyosnev(t)==true)
			{
				t.setVegpont(t.getVegpont()+" pecsetelohely");
			}
			fajlba+=t.getKiindulopont()+";"+t.getVegpont()+";"+t.getHossz()+";"+t.getEmelkedo()+";"+t.getLejto()+";"+t.getPecsetelohely()+"\n";
		}
		
		Files.write(Paths.get("kektura2.csv"),fajlba.getBytes());
		
	}

}
