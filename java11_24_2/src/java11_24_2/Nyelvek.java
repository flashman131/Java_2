package java11_24_2;

import java.util.List;

public class Nyelvek {
	
	private String nyelv;
	private List<Integer> evek;
	
	public Nyelvek(String nyelv, List<Integer> evek) {
		super();
		this.nyelv = nyelv;
		this.evek = evek;
	}
	
	public String getNyelv() {
		return nyelv;
	}

	public void setNyelv(String nyelv) {
		this.nyelv = nyelv;
	}

	public List<Integer> getEvek() {
		return evek;
	}

	public void setEvek(List<Integer> evek) {
		this.evek = evek;
	}

	@Override
	public String toString() {
		return "Nyelvek [nyelv=" + nyelv + ", evek=" + evek + "]";
	}


	
}
