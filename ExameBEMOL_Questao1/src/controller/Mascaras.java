//Funcao que cria a mascara de numeros a ser utilizada!

package controller;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Mascaras {
	MaskFormatter mascaraData = new MaskFormatter();
	MaskFormatter mascaraParcela = new MaskFormatter();
	public MaskFormatter geraMascaraData(){
	try {
		mascaraData.setMask("##/##/####");
		mascaraData.setPlaceholderCharacter('_');
	} catch (ParseException e) {
		e.printStackTrace();
		System.out.println("Erro na formatacao!"+e.getMessage());
	}
	return mascaraData;
	}
	/*
	public MaskFormatter geraMascaraParcela(){
		try {
			mascaraParcela.setMask("###.##"); //p aceitar somente numeros.
			mascaraParcela.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Erro na formatacao!"+e.getMessage());
		}
		return mascaraParcela;
		}eliminado pra agilizar.	*/
}
