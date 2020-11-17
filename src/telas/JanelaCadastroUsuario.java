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


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;






public class JanelaCadastroUsuario extends JFrame{
 
 public JLabel lblNome, lblEnd, lblTel, lblEmail, lblCPF, lblNasci;
 public JTextField txtNome, txtEnd, txtEmail,  txtNumeroMatricula, txtCPF;
 public JFormattedTextField txtTel, txtNasci;
 public JButton btnCadastrar, btnLimpar, btnCancelar, btnGerarNumeroMatricula;   
 MaskFormatter mskTel, mskNasci;
 
 
 public JanelaCadastroUsuario(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Usuário");
		
		iniciarTela();
	        iniciarEventos();
		
		setSize(600, 400);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
}
 
private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(192,192,192));
		
		lblNome = new JLabel("Nome:"); //Nome
		lblNome.setForeground(new Color(0,0,0));
		lblNome.setBounds(20, 50, 80, 20);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(120, 50, 450, 20);
		add(txtNome);
		
		lblEnd = new JLabel("Endereço:"); //Endereço
		lblEnd.setForeground(new Color(0,0,0));
		lblEnd.setBounds(20, 80, 100, 20);
		add(lblEnd);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(120, 80, 450, 20);
		add(txtEnd);
		
		
                lblEmail = new JLabel("Email:"); //Email
		lblEmail.setForeground(new Color(0,0,0));
		lblEmail.setBounds(20, 110, 100, 20);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(120,110, 450, 20);
		add(txtEmail);
                
                
                
                lblCPF = new JLabel("CPF:"); //CPF
		lblCPF.setForeground(new Color(0,0,0));
		lblCPF.setBounds(20, 140, 50, 20);
		add(lblCPF);
                
                txtCPF = new JTextField();
		txtCPF.setBounds(120,140, 130, 20);
		add(txtCPF);
                
                lblTel = new JLabel("Telefone:"); //Telefone
		lblTel.setForeground(new Color(0,0,0));
		lblTel.setBounds(20, 170, 80, 20);
		add(lblTel);
                
                try {
			mskTel = new MaskFormatter("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
                
		txtTel = new JFormattedTextField(mskTel);
		txtTel.setBounds(120, 170, 100, 20);
		add(txtTel);
		
                lblNasci = new JLabel("Data de nascimento:"); 
		lblNasci.setForeground(new Color(0,0,0));
		lblNasci.setBounds(20, 200, 200, 20);
		add(lblNasci);
                
                try {
			mskNasci = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
                
                txtNasci= new JFormattedTextField(mskNasci);
		txtNasci.setBounds(160, 200, 70, 20);
		add(txtNasci);                           
                
                
                txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setBounds(20, 230, 200, 20);
		add(txtNumeroMatricula);
                txtNumeroMatricula.setEditable(false); 
		
		
                
                
                
                
               
                
                
                
                
                
                
                
		btnCadastrar = new JButton("Cadastrar"); 
		btnCadastrar.setBackground(new Color (240,248,255)); 
		btnCadastrar.setBounds(270, 320, 95, 25);
		btnCadastrar.setToolTipText("Clique para concluir cadastro");
		add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color (240,248,255));
		btnLimpar.setBounds(370, 320, 95, 25);
		btnLimpar.setToolTipText("Clique para limpar todos os campos");
		add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color (240,248,255));
		btnCancelar.setBounds(470, 320, 95, 25);
		btnCancelar.setToolTipText("Clique para cancelar o cadastro");
		add(btnCancelar);
                
                btnGerarNumeroMatricula = new JButton("Gerar Número de Matricula");
		btnGerarNumeroMatricula.setBackground(new Color (240,248,255));
		btnGerarNumeroMatricula.setBounds(230, 230, 200, 20);
		btnGerarNumeroMatricula.setToolTipText("Clique para gerar o número de matrícula do cliente");
		add(btnGerarNumeroMatricula);
                
                
		
	}

public void iniciarEventos(){
		btnLimpar.addActionListener(new ActionListener() { //Limpar campos
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
                                txtEnd.setText("");
                                txtEmail.setText("");
                                txtNumeroMatricula.setText("");
                                txtCPF.setText("");
                                txtNasci.setText("");
                                txtTel.setText("");
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() { //Fechar janela
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}
}


