/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Administrador
 */
public class JanelaEdicaoLivro extends JFrame {
 public JLabel lblCodigo, lblTitulo, lblAutor, lblEdicao, lblAno, lblDispo;
 public JTextField txtCodigo, txtTitulo, txtAutor, txtEdicao, txtDispo;
 public JFormattedTextField txtAno;
 public JButton btnSalvar, btnLimpar, btnCancelar;   

 MaskFormatter mskAno, mskDispo;
 
    public JanelaEdicaoLivro(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Editar Livros");
		
		iniciarTela();
	        iniciarEventos();
		
		setSize(700, 500);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
}
 
private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(192,192,192));
		
		lblCodigo = new JLabel("Codigo:"); 
		lblCodigo.setForeground(new Color(0,0,0));
		lblCodigo.setBounds(20, 50, 80, 20);
		add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(120, 50, 450, 20);
		add(txtCodigo);
		
		lblTitulo = new JLabel("Título:"); 
		lblTitulo.setForeground(new Color (0,0,0));
		lblTitulo.setBounds(20, 80, 100, 20);
		add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(120, 80, 450, 20);
		add(txtTitulo);
		
		
                lblEdicao = new JLabel("Edição:"); 
		lblEdicao.setForeground(new Color (0,0,0));
		lblEdicao.setBounds(20, 110, 100, 20);
		add(lblEdicao);
		
		txtEdicao = new JTextField();
		txtEdicao.setBounds(120,110, 450, 20);
		add(txtEdicao);
                
                
                
                lblAno = new JLabel("Ano:"); 
		lblAno.setForeground(new Color (0,0,0));
		lblAno.setBounds(20, 140, 100, 20);
		add(lblAno);
                
                
                try {
			mskAno = new MaskFormatter("####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtAno = new JFormattedTextField(mskAno);
		txtAno.setBounds(120, 140, 150, 20);
		add(txtAno);
		
                
                lblAutor = new JLabel("Autor:"); 
		lblAutor.setForeground(new Color (0,0,0));
		lblAutor.setBounds(20, 170, 100, 20);
		add(lblAutor);
                
                txtAutor = new JTextField();
		txtAutor.setBounds(120, 170, 150, 20);
		add(txtAutor);
		
		
                
                
                lblDispo = new JLabel("Quant.:"); 
		lblDispo.setForeground(new Color (0,0,0));
		lblDispo.setBounds(20, 200, 100, 20);
		add(lblDispo);
                
                try {
			mskDispo = new MaskFormatter("#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
                
                txtDispo = new JFormattedTextField(mskDispo);
		txtDispo.setBounds(120, 200, 150, 20);
		add(txtDispo);
		
		
                
                
                
                
                
                
                
                
                
                
		btnSalvar = new JButton("Salvar"); 
		btnSalvar.setBackground(new Color (240,248,255)); 
		btnSalvar.setBounds(380, 435, 95, 25);
		btnSalvar.setToolTipText("Clique para concluir cadastro");
		add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color (240,248,255));
		btnLimpar.setBounds(480, 435, 95, 25);
		btnLimpar.setToolTipText("Clique para limpar todos os campos");
		add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color (240,248,255));
		btnCancelar.setBounds(580, 435, 95, 25);
		btnCancelar.setToolTipText("Clique para cancelar o cadastro");
		add(btnCancelar);
		
	}

public void iniciarEventos(){
		btnLimpar.addActionListener(new ActionListener() { //Limpar campos
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setText("");
				txtTitulo.setText("");
				txtDispo.setText("");
                                txtAno.setText("");
                                txtAutor.setText("");
                                txtEdicao.setText("");
                                
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
