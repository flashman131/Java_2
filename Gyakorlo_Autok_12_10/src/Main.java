import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static List<Autok> listCars() {
		List<Autok> vurdikLista = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("autok.csv"));
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(";");

				Autok o = new Autok(split[0],split[1],split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5]);

				vurdikLista.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasásnál!");
		}
		return vurdikLista;
	}

	
	public static void main(String[] args) {
		List<Autok> autolista= listCars();
		autolista.forEach(System.out :: println);
		
		System.out.println("A listában "+autolista.size()+" db elem van.");
		
		
		for(Autok a : autolista)
		{
			if(a.getMarka().equals("BMW"))
				System.out.println(a.getUzeme());
		}
		
		
	}

}
