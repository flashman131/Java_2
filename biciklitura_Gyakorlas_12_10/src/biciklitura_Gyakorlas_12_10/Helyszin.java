package biciklitura_Gyakorlas_12_10;

public class Helyszin {
	public String hnev;
	public int h1;
	public int h2;
	public int h3;
	public Helyszin(String hnev, int h1, int h2, int h3) {
		super();
		this.hnev = hnev;
		this.h1 = h1;
		this.h2 = h2;
		this.h3 = h3;
	}
	
	public String getHnev() {
		return hnev;
	}
	public void setHnev(String hnev) {
		this.hnev = hnev;
	}
	public int getH1() {
		return h1;
	}
	public void setH1(int h1) {
		this.h1 = h1;
	}
	public int getH2() {
		return h2;
	}
	public void setH2(int h2) {
		this.h2 = h2;
	}
	public int getH3() {
		return h3;
	}
	public void setH3(int h3) {
		this.h3 = h3;
	}
	
	@Override
	public String toString() {
		return "Helyszin [hnev=" + hnev + ", h1=" + h1 + ", h2=" + h2 + ", h3=" + h3 + "]";
	}
	

}
