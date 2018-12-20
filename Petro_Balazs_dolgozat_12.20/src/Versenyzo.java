
public class Versenyzo {
	private String konstruktor;
	private String auto;
	private String csapat;
	private String pilota;
	private int perc;
	private int masodperc;
	private int tizedmasodperc;
	
	public Versenyzo(String konstruktor, String auto, String csapat, String pilota, int perc, int masodperc,
			int tizedmasodperc) {
		super();
		this.konstruktor = konstruktor;
		this.auto = auto;
		this.csapat = csapat;
		this.pilota = pilota;
		this.perc = perc;
		this.masodperc = masodperc;
		this.tizedmasodperc = tizedmasodperc;
	}

	public String getKonstruktor() {
		return konstruktor;
	}

	public void setKonstruktor(String konstruktor) {
		this.konstruktor = konstruktor;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getCsapat() {
		return csapat;
	}

	public void setCsapat(String csapat) {
		this.csapat = csapat;
	}

	public String getPilota() {
		return pilota;
	}

	public void setPilota(String pilota) {
		this.pilota = pilota;
	}

	public int getPerc() {
		return perc;
	}

	public void setPerc(int perc) {
		this.perc = perc;
	}

	public int getMasodperc() {
		return masodperc;
	}

	public void setMasodperc(int masodperc) {
		this.masodperc = masodperc;
	}

	public int getTizedmasodperc() {
		return tizedmasodperc;
	}

	public void setTizedmasodperc(int tizedmasodperc) {
		this.tizedmasodperc = tizedmasodperc;
	}

	@Override
	public String toString() {
		return "Versenyzo [konstruktor=" + konstruktor + ", auto=" + auto + ", csapat=" + csapat + ", pilota=" + pilota
				+ ", perc=" + perc + ", masodperc=" + masodperc + ", tizedmasodperc=" + tizedmasodperc + "]";
	}
	
	
}
