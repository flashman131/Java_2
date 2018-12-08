package kektura_12_08;

public class Tura {
	private String kiindulopont;
	private String vegpont;
	private double hossz;
	private int emelkedo;
	private int lejto;
	private String pecsetelohely;
	
	
	public Tura(String kiindulopont, String vegpont, double hossz, int emelkedo, int lejto, String pecsetelohely) {
		super();
		this.kiindulopont = kiindulopont;
		this.vegpont = vegpont;
		this.hossz = hossz;
		this.emelkedo = emelkedo;
		this.lejto = lejto;
		this.pecsetelohely = pecsetelohely;
		
		
	}


	public String getKiindulopont() {
		return kiindulopont;
	}


	public void setKiindulopont(String kiindulopont) {
		this.kiindulopont = kiindulopont;
	}


	public String getVegpont() {
		return vegpont;
	}


	public void setVegpont(String vegpont) {
		this.vegpont = vegpont;
	}


	public double getHossz() {
		return hossz;
	}


	public void setHossz(double hossz) {
		this.hossz = hossz;
	}


	public int getEmelkedo() {
		return emelkedo;
	}


	public void setEmelkedo(int emelkedo) {
		this.emelkedo = emelkedo;
	}


	public int getLejto() {
		return lejto;
	}


	public void setLejto(int lejto) {
		this.lejto = lejto;
	}


	public String getPecsetelohely() {
		return pecsetelohely;
	}


	public void setPecsetelohely(String pecsetelohely) {
		this.pecsetelohely = pecsetelohely;
	}


	@Override
	public String toString() {
		return "Tura [kiindulopont=" + kiindulopont + ", vegpont=" + vegpont + ", hossz=" + hossz + ", emelkedo="
				+ emelkedo + ", lejto=" + lejto + ", pecsetelohely=" + pecsetelohely + "]";
	}
	

}
