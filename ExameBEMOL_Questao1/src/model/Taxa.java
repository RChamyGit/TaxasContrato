package model;

public class Taxa {
	private final double taxaJuros = 0.00367;  
	private final double taxaDesconto = 0.00050;
	//não permito a alteração dessas taxas durante a execução.
	public double getTaxaDesconto() {
		return taxaDesconto;
	}
	public double getTaxaJuros() {
		return taxaJuros;
	}
}
