
public class Versenyzo {
	public String azon;
	public String valasz;
	
	
	public Versenyzo(String azon, String valasz) {
		super();
		this.azon = azon;
		this.valasz = valasz;
	}
	public String getAzon() {
		return azon;
	}
	public void setAzon(String azon) {
		this.azon = azon;
	}
	public String getValasz() {
		return valasz;
	}
	public void setValasz(String valasz) {
		this.valasz = valasz;
	}
	
	
	@Override
	public String toString() {
		return "Versenyzo [azon=" + azon + ", valasz=" + valasz + "]";
	}
	
}
