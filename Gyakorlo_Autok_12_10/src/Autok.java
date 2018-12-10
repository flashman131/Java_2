
public class Autok {
	private String marka;
	private String tipusa;
	private String szine;
	private int kor;
	private int ar;
	private String uzeme;
	
	public Autok(String marka, String tipusa, String szine, int kor, int ar, String uzeme) {
		super();
		this.marka = marka;
		this.tipusa = tipusa;
		this.szine = szine;
		this.kor = kor;
		this.ar = ar;
		this.uzeme = uzeme;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getTipusa() {
		return tipusa;
	}

	public void setTipusa(String tipusa) {
		this.tipusa = tipusa;
	}

	public String getSzine() {
		return szine;
	}

	public void setSzine(String szine) {
		this.szine = szine;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getAr() {
		return ar;
	}

	public void setAr(int ar) {
		this.ar = ar;
	}

	public String getUzeme() {
		return uzeme;
	}

	public void setUzeme(String uzeme) {
		this.uzeme = uzeme;
	}

	@Override
	public String toString() {
		return "Autok [marka=" + marka + ", tipusa=" + tipusa + ", szine=" + szine + ", kor=" + kor + ", ar=" + ar
				+ ", uzeme=" + uzeme + "]";
	}
	
	
}
