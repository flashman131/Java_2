package java11_24;

public class Versenyzo {
	
	private String nev;
	private String orszag;
	private double technikaiPontszam;
	private double komponensPontszam;
	private double hibapont;
	
	
	public Versenyzo(String nev, String orszag, double technikaiPontszam, double komponensPontszam, double hibapont) {
		super();
		this.nev = nev;
		this.orszag = orszag;
		this.technikaiPontszam = technikaiPontszam;
		this.komponensPontszam = komponensPontszam;
		this.hibapont = hibapont;
	}
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public String getOrszag() {
		return orszag;
	}
	public void setOrszag(String orszag) {
		this.orszag = orszag;
	}
	public double getTechnikaiPontszam() {
		return technikaiPontszam;
	}
	public void setTechnikaiPontszam(double technikaiPontszam) {
		this.technikaiPontszam = technikaiPontszam;
	}
	public double getKomponensPontszam() {
		return komponensPontszam;
	}
	public void setKomponensPontszam(double komponensPontszam) {
		this.komponensPontszam = komponensPontszam;
	}
	public double getHibapont() {
		return hibapont;
	}
	public void setHibapont(double hibapont) {
		this.hibapont = hibapont;
	}
	@Override
	public String toString() {
		return "Versenyzo [nev=" + nev + ", orszag=" + orszag + ", technikaiPontszam=" + technikaiPontszam
				+ ", komponensPontszam=" + komponensPontszam + ", hibapont=" + hibapont + "]";
	}

	
	
	
}
