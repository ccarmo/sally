/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author Administrador
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JanelaPrincipal extends JFrame {
    
    JLabel lblTitulo, lblHora, lblData;
    public JButton btnPedidoRapido, btnCadastrar, btnListaDeClientes, btnAvancado,  btnAdicionar;
    public JMenuBar menuBar;
    public JMenu mnArquivos, mnProcessos, mnCadastros, mnPesquisas;
    public JMenuItem cdUsuarios, cdLivros, psUsuarios, psLivros, itDevolucao, exUsuarios, exLivros, imUsuarios, imLivros, itEmprestimo, itMulta;
    Date Data = new Date();
    DateFormat FormatoHorario = new SimpleDateFormat("HH:mm");
    String HorarioSistema = FormatoHorario.format(Data);
    SimpleDateFormat FormatoData= new SimpleDateFormat("dd/MM/yyyy");
    public String DataSistema = FormatoData.format(Data);
    
    
    
    public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SALLY - Sistema de Empréstimo de Livros");
		
		iniciarTela();
		
                
		setSize(900, 700);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}  
    private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(192,192,192));
		
                /*
		lblTitulo = new JLabel("Sally");
		lblTitulo.setForeground(new Color(25,25,112)); 
		lblTitulo.setBounds(120,15,100,20);
		add(lblTitulo);
                */
                // Cria uma barra de menu para o JFrame
                JMenuBar menuBar = new JMenuBar();
                
                // Adiciona a barra de menu ao  frame
                setJMenuBar(menuBar);
                
                
             
                
                //Menu Processos
                mnProcessos = new JMenu("Processos");
                menuBar.add(mnProcessos);
                
               
                
                //Menu Cadastros
                mnCadastros = new JMenu("Cadastros");
                mnProcessos.add(mnCadastros);
             
                //Menu Pesquisa
                mnPesquisas = new JMenu("Pesquisas");
                mnProcessos.add(mnPesquisas);
                
                //Menu Emprestimo
                itEmprestimo = new JMenuItem("Empréstimo");
                mnProcessos.add(itEmprestimo);
                
                
                //Menu Devolução
                itDevolucao = new JMenuItem("Devolução");
                mnProcessos.add(itDevolucao);
                
                 //Menu Multa
                itMulta = new JMenuItem("Multa");
                mnProcessos.add(itMulta);
                
                //Sub-item Cadastro-Clientes
                cdUsuarios = new JMenuItem("Usuários");
                mnCadastros.add(cdUsuarios);
                
                
                //Sub-item Cadastro-Livros
                cdLivros = new JMenuItem("Livros");
                mnCadastros.add(cdLivros);
               
                //Sub-item Pesquisa-Usuario
                psUsuarios = new JMenuItem("Usuários");
                mnPesquisas.add(psUsuarios);   
              
                
                //Sub-item Pesquisa-Livro
                psLivros = new JMenuItem("Livros");
                mnPesquisas.add(psLivros);   
                
                lblHora = new JLabel(HorarioSistema);
		lblHora.setForeground(new Color(105,105,105));
		lblHora.setBounds(750, 600, 100, 20);
		add(lblHora);
                
                lblData = new JLabel(DataSistema);
		lblData.setForeground(new Color(105,105,105));
		lblData.setBounds(800, 600, 100, 20);
		add(lblData);
                
                
              
           
                
                
              
                 
                
                 
}

}
