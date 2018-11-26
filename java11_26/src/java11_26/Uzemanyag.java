package java11_26;

public class Uzemanyag {

	private String datum;
	private int benzin;
	private int diesel;
	
	
	public Uzemanyag(String datum, int benzin, int diesel) {
		super();
		this.datum = datum;
		this.benzin = benzin;
		this.diesel = diesel;
	}


	public String getDatum() {
		return datum;
	}


	public void setDatum(String datum) {
		this.datum = datum;
	}


	public int getBenzin() {
		return benzin;
	}


	public void setBenzin(int benzin) {
		this.benzin = benzin;
	}


	public int getDiesel() {
		return diesel;
	}


	public void setDiesel(int diesel) {
		this.diesel = diesel;
	}


	@Override
	public String toString() {
		return "Uzemanyag [datum=" + datum + ", benzin=" + benzin + ", diesel=" + diesel + "]";
	}
	
	
}
