package footgolf;

import java.util.List;

public class Versenyzok {
	private String nev;
	private String kategoria;
	private String egyesulet;
	private List<Integer> fordulok;
	
	public Versenyzok(String nev, String kategoria, String egyesulet, List<Integer> fordulok) {
		super();
		this.nev = nev;
		this.kategoria = kategoria;
		this.egyesulet = egyesulet;
		this.fordulok = fordulok;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public String getEgyesulet() {
		return egyesulet;
	}

	public void setEgyesulet(String egyesulet) {
		this.egyesulet = egyesulet;
	}

	public List<Integer> getFordulok() {
		return fordulok;
	}

	public void setFordulok(List<Integer> fordulok) {
		this.fordulok = fordulok;
	}

	@Override
	public String toString() {
		return "Versenyzok [nev=" + nev + ", kategoria=" + kategoria + ", egyesulet=" + egyesulet + ", fordulok="
				+ fordulok + "]";
	}
	
	
	
	
}
