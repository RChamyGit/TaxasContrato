package model;

public class Taxa {
	private final double taxaJuros = 0.00367;  
	private final double taxaDesconto = 0.00050;
	//n�o permito a altera��o dessas taxas durante a execu��o.
	public double getTaxaDesconto() {
		return taxaDesconto;
	}
	public double getTaxaJuros() {
		return taxaJuros;
	}
}
