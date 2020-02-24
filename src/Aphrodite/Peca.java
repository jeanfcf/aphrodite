package Aphrodite;

public class Peca implements Comparable<Peca> {
	
	private String peca;

	public Peca(String peca) {
		
		this.peca = peca;
	}

	public String getPeca() {
		return peca;
	}

	public void setPeca(String peca) {
		this.peca = peca;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getPeca();
	}

	public boolean equals1(Peca p) {
		
		if(p == null) {
			return false;
		}
		
		if(this.peca.equals(p.getPeca())) {
			return true;
		}else {
			return false;
		}
		
		
	}


	@Override
	public int compareTo(Peca o) {
		
		if(o.getPeca().startsWith("C")) {
			return -1;
		}
	
		return 0;
	}

	
	

}
