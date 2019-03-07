/*
 *autor = RICARDO-PC
 *A tela é só pra inserir os dados. Os resultados saem no console..
 */


package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//imports para a tela e formulario.
import javax.swing.JTextField;

import controller.Financeiro;
import controller.Mascaras;
//controlador de mascara
import controller.MetodosData;
import model.Datas;

public class TelaPrincipal implements ActionListener{
	
	
	JFrame janela = new JFrame("Avaliação Questão 1 - Cálculo de Dívidas:");
	JPanel painel = new JPanel();
	JLabel lbdatapagamento = new JLabel("Data de pagamento da parcela: ");
	JLabel lbdatavencimento = new JLabel("Vencimento da parcela: ");
	JLabel lbprazo = new JLabel();
	JLabel lbvalorparcela = new JLabel("Valor da Parcela: ");
	JLabel lbdesconto = new JLabel("Desconto por mes: 1,5%");
	JLabel lbjuros = new JLabel("Juros por mes: 11%");
	
	private JFormattedTextField txtdatapagamento;
	private JFormattedTextField txtdatavencimento;
	private JTextField txtvalorparcela = new JTextField();
	private JTextField txttaxa = new JTextField();
	
	JButton btcalcular = new JButton("Calcular");
	
	Mascaras mask = new Mascaras();
	//METODO DA TELA
	public void criarTela(){
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sem isso a JVM acumula dezenas de instancias...
		//parsexception adicionado p aceitar criacao de mascara inline.
		janela.setSize(800, 600);
		painel.setLayout(null);
		
		lbdatapagamento.setBounds(30, 60, 200, 20);
		txtdatapagamento = new JFormattedTextField(mask.geraMascaraData());
		txtdatapagamento.setBounds(250, 60, 60, 20);
		
		lbdatavencimento.setBounds(30, 20, 200, 20);
		txtdatavencimento = new JFormattedTextField(mask.geraMascaraData());
		txtdatavencimento.setBounds(250, 20, 60, 20);
		
		lbvalorparcela.setBounds(30,100,100,20);
		txtvalorparcela.setBounds(250,100,100,20);
		
		btcalcular.setBounds(250, 140, 100, 30);
		btcalcular.addActionListener(this);
		
		lbprazo.setBounds(250, 200, janela.getWidth()/2, 30); //sua parcela vence em... sua parcela está xx atrasada
		lbdesconto.setBounds(50, janela.getHeight()-100, 200, 30);
		lbjuros.setBounds(250, janela.getHeight()-100, 200, 30);
	
		painel.add(lbdatapagamento);
		painel.add(txtdatapagamento);
		
		painel.add(lbdatavencimento);
		painel.add(txtdatavencimento);
		
		painel.add(lbvalorparcela);
		painel.add(txtvalorparcela);
		
		painel.add(btcalcular);
		
		painel.add(lbprazo);
		painel.add(lbdesconto);
		painel.add(lbjuros);
		janela.setLocationRelativeTo(null); //inicia a janela centrada na tela.
		janela.getContentPane().add(painel);
		janela.setVisible(true);
	
	}

	public static void main(String[] args) {
		TelaPrincipal t = new TelaPrincipal();
		t.criarTela();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MetodosData md = new MetodosData(); //testando o validador
		Financeiro fnc = new Financeiro();
		Datas dt = new Datas();
		
		try {
			
			if(md.validaData(txtdatavencimento.getText(),txtdatapagamento.getText())){
				//check datas validas
				dt = md.salvaData(txtdatavencimento.getText(),txtdatapagamento.getText());
				//converte as Strings para Date e joga no objeto dt
				
				double parcela = Double.parseDouble(txtvalorparcela.getText());
				double taxa = fnc.calcTaxa(dt,parcela);
                double dias = md.diferencaDatas(dt);
                
                txttaxa.setText(Double.toString(taxa));
				if(dias>0){
					System.out.println("Atrasada!");
					System.out.println("Valor Juros: "+taxa);
					System.out.println("Valor parcela atualizada: "+(taxa+parcela));
				}
				else if(dias<0){
					
                                    System.out.println("pagará com desconto");
                                    System.out.println("Valor Desconto:"+taxa);
                                    System.out.println("Valor parcela atualizada:"+(taxa+parcela));
                                    //Atribuirei os valores a labels da janela em outra versão, já são 1:30 da manhã.
				}
				else {
					System.out.println("Nenhuma taxa será aplicada.");
				}
				//System.out.println("Dias: "+md.diferencaDatas(dt)); TESTE
			}
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println("Erro na validacao - catch botao");
			e1.printStackTrace();
		}
		
	}
	
}

