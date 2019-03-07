package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Datas;
public class MetodosData{

private Datas datas = new Datas();	
private static DateFormat maskData = new SimpleDateFormat("dd/MM/yyyy");

	
	//Valida as datas
	public boolean validaData(String dataVenc, String dataPag) {//tambem posso criar metodos separados para refinar msg erro

		try {
	            maskData.setLenient(false); //Para so aceitar o formato especificado
	            maskData.parse(dataPag);
	            maskData.parse(dataVenc);
	            return true;
	        } catch (ParseException e) {
	        	JOptionPane.showMessageDialog(new JFrame(), "Data invalida","aviso",JOptionPane.WARNING_MESSAGE);
	            System.out.println(e.getMessage());
	        	return false;
	        }
	        
	}
	
	//valida e salva
	public Datas salvaData(String dataVenc, String dataPag) throws ParseException {

			if(validaData(dataVenc,dataPag)){
                                datas.setDataVencimento(maskData.parse(dataVenc));
                                datas.setDataPagamento(maskData.parse(dataPag));
				System.out.println(datas.getDataVencimento());
				System.out.println(datas.getDataPagamento());
				System.out.println("Objeto Datas gravado com sucesso");
			}
			return datas;
			
	}

	
	//Funcao contadora de dias entre datas
	public long diferencaDatas(Datas data) throws ParseException {
	//ChronoUnit nao aceita Date, somente LocalDate ou Instant.
		return ChronoUnit.DAYS.between(data.getDataVencimento().toInstant(), data.getDataPagamento().toInstant());
	
	}
	
}
