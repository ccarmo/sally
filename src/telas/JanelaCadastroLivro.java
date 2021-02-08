
package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import excecoes.*;


public class JanelaCadastroLivro extends JFrame  {
 
 public JLabel lblTitulo, lblAutor, lblEdicao, lblAno, lblDispo;
 public JTextField txtCodigo, txtTitulo, txtAutor, txtEdicao;
 public JFormattedTextField txtAno, txtDispo;
 public JButton btnCadastrar, btnLimpar, btnCancelar;   
 
 MaskFormatter mskAno, mskDispo;
 
    public JanelaCadastroLivro(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Livro");
		
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
		
		
                
                
                
                
                
                
                
                
                
                
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color (240,248,255)); 
		btnCadastrar.setBounds(270,300, 95, 25);
		btnCadastrar.setToolTipText("Clique para concluir cadastro");
		add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color (240,248,255));
		btnLimpar.setBounds(370, 300, 95, 25);
		btnLimpar.setToolTipText("Clique para limpar todos os campos");
		add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color (240,248,255));
		btnCancelar.setBounds(470, 300, 95, 25);
		btnCancelar.setToolTipText("Clique para cancelar o cadastro");
		add(btnCancelar);
		
	}

public void iniciarEventos(){
		btnLimpar.addActionListener(new ActionListener() { //Limpar campos
			@Override
			public void actionPerformed(ActionEvent arg0) {

				txtTitulo.setText("");
				txtDispo.setText("");
                txtEdicao.setText("");
                txtAno.setText("");
                txtDispo.setText("");
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




