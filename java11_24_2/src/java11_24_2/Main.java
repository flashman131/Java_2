package java11_24_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	

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
		System.out.println(sikeres);
		System.out.println(sikertelen);
		
		
	}

}
