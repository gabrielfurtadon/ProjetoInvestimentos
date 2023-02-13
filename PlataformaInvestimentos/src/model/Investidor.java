package model;


public class Investidor extends Usuario{
	
	private double patrimonio;
	private double aporte;
	

	public double getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(double patrimonio) {
		this.patrimonio = patrimonio;
	}
	
	public void aportar() {
		patrimonio += aporte;
	}
	
	
	
	
}
