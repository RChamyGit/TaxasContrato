package controller;

import model.Datas;
import model.Taxa;

import java.text.ParseException;


public class Financeiro {
private Taxa tax = new Taxa();
public double calcTaxa(Datas datas, double parcela) throws ParseException{
            
        MetodosData md = new MetodosData();
		double dias = md.diferencaDatas(datas);
		System.out.println(md.diferencaDatas(datas));
        if(dias>0){
                    System.out.println("aplicando juros");
                    
                    return parcela*tax.getTaxaJuros()*dias; //considero 1 mes = 30 dias
                }
		else if(dias<0){
                    
                    System.out.println("aplicando desconto");
                    return parcela*tax.getTaxaDesconto()*dias;
		}

		return 0;
		
	}

        
	
	
}
