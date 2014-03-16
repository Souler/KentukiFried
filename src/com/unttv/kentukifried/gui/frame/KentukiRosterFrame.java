package com.unttv.kentukifried.gui.frame;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.unttv.kentukifried.gui.components.KentukiTemplateText;

import java.awt.Font;

@SuppressWarnings("serial")
public class KentukiRosterFrame extends KentukiTemplateFrame
{
	private KentukiTemplateText txtMemberName1;
	private JTextField txtTemplateName;
	private KentukiTemplateText txtBasepath;
	private JLabel lblCarpetaDeLos;
	private JPanel panel;
	private JTextField txtIp;
	private KentukiTemplateText txtGame;
	private JLabel lblFotoJug;
	private KentukiTemplateText txtMemberFoto1;
	private KentukiTemplateText txtMemberFoto2;
	private JLabel lblFotoJug_1;
	private JLabel lblJugador;
	private KentukiTemplateText txtMemberName2;
	private JLabel lblJugador_1;
	private KentukiTemplateText txtMemberName3;
	private KentukiTemplateText txtMemberFoto3;
	private JLabel lblFotoJug_2;
	private JLabel lblFotoJug_3;
	private KentukiTemplateText txtMemberFoto4;
	private KentukiTemplateText txtMemberName4;
	private JLabel lblJugador_2;
	private KentukiTemplateText txtMemberFoto5;
	private KentukiTemplateText txtMemberName5;
	private JLabel lblJugador_3;
	private JLabel lblFotoJug_4;
	private JLabel lblLogoPeque;
	private JLabel lblLogoFondo;
	private KentukiTemplateText txtLogoBig;
	private KentukiTemplateText txtLogoSmall;

	/**
	 * Create the application.
	 */
	public KentukiRosterFrame()
	{
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setName("Roster");
		this.setTitle("Kentuki Fried Roster");
		this.setBounds(100, 100, 404, 587);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del template", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 377, 410);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtMemberName1 = new KentukiTemplateText("member1");
		txtMemberName1.setBounds(94, 13, 256, 20);
		panel.add(txtMemberName1);
		txtMemberName1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberName1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Jugador 1");
		lblNewLabel.setBounds(6, 16, 86, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtBasepath = new KentukiTemplateText("basePath");
		txtBasepath.setText("S:/Kentuki/EGO_STADIUM/templates_assets/");
		txtBasepath.setBounds(94, 336, 256, 20);
		panel.add(txtBasepath);
		txtBasepath.setColumns(10);
		
		lblCarpetaDeLos = new JLabel("BasePath");
		lblCarpetaDeLos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarpetaDeLos.setBounds(6, 339, 86, 14);
		panel.add(lblCarpetaDeLos);
		
		JLabel lblGame = new JLabel("Juego");
		lblGame.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGame.setBounds(16, 366, 72, 14);
		panel.add(lblGame);
		
		txtGame = new KentukiTemplateText("logo0");
		txtGame.setText("game/");
		txtGame.setColumns(10);
		txtGame.setBounds(94, 363, 252, 20);
		panel.add(txtGame);
		
		lblFotoJug = new JLabel("Foto Jug. 1");
		lblFotoJug.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFotoJug.setBounds(6, 39, 86, 14);
		panel.add(lblFotoJug);
		
		txtMemberFoto1 = new KentukiTemplateText("logo3");
		txtMemberFoto1.setText("Players/");
		txtMemberFoto1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberFoto1.setColumns(10);
		txtMemberFoto1.setBounds(94, 36, 256, 20);
		panel.add(txtMemberFoto1);
		
		txtMemberFoto2 = new KentukiTemplateText("logo4");
		txtMemberFoto2.setText("Players/");
		txtMemberFoto2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberFoto2.setColumns(10);
		txtMemberFoto2.setBounds(94, 93, 256, 20);
		panel.add(txtMemberFoto2);
		
		lblFotoJug_1 = new JLabel("Foto Jug. 2");
		lblFotoJug_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFotoJug_1.setBounds(6, 96, 86, 14);
		panel.add(lblFotoJug_1);
		
		lblJugador = new JLabel("Jugador 2");
		lblJugador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJugador.setBounds(6, 73, 86, 14);
		panel.add(lblJugador);
		
		txtMemberName2 = new KentukiTemplateText("member2");
		txtMemberName2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberName2.setColumns(10);
		txtMemberName2.setBounds(94, 70, 256, 20);
		panel.add(txtMemberName2);
		
		lblJugador_1 = new JLabel("Jugador 3");
		lblJugador_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJugador_1.setBounds(6, 124, 86, 14);
		panel.add(lblJugador_1);
		
		txtMemberName3 = new KentukiTemplateText("member3");
		txtMemberName3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberName3.setColumns(10);
		txtMemberName3.setBounds(94, 121, 256, 20);
		panel.add(txtMemberName3);
		
		txtMemberFoto3 = new KentukiTemplateText("logo5");
		txtMemberFoto3.setText("Players/");
		txtMemberFoto3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberFoto3.setColumns(10);
		txtMemberFoto3.setBounds(94, 144, 256, 20);
		panel.add(txtMemberFoto3);
		
		lblFotoJug_2 = new JLabel("Foto Jug. 3");
		lblFotoJug_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFotoJug_2.setBounds(6, 147, 86, 14);
		panel.add(lblFotoJug_2);
		
		lblFotoJug_3 = new JLabel("Foto Jug. 4");
		lblFotoJug_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFotoJug_3.setBounds(6, 201, 86, 14);
		panel.add(lblFotoJug_3);
		
		txtMemberFoto4 = new KentukiTemplateText("logo6");
		txtMemberFoto4.setText("Players/");
		txtMemberFoto4.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberFoto4.setColumns(10);
		txtMemberFoto4.setBounds(94, 198, 256, 20);
		panel.add(txtMemberFoto4);
		
		txtMemberName4 = new KentukiTemplateText("member4");
		txtMemberName4.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberName4.setColumns(10);
		txtMemberName4.setBounds(94, 175, 256, 20);
		panel.add(txtMemberName4);
		
		lblJugador_2 = new JLabel("Jugador 4");
		lblJugador_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJugador_2.setBounds(6, 178, 86, 14);
		panel.add(lblJugador_2);
		
		txtMemberFoto5 = new KentukiTemplateText("logo7");
		txtMemberFoto5.setText("Players/");
		txtMemberFoto5.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberFoto5.setColumns(10);
		txtMemberFoto5.setBounds(94, 249, 256, 20);
		panel.add(txtMemberFoto5);
		
		txtMemberName5 = new KentukiTemplateText("member5");
		txtMemberName5.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMemberName5.setColumns(10);
		txtMemberName5.setBounds(94, 226, 256, 20);
		panel.add(txtMemberName5);
		
		lblJugador_3 = new JLabel("Jugador 5");
		lblJugador_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJugador_3.setBounds(6, 229, 86, 14);
		panel.add(lblJugador_3);
		
		lblFotoJug_4 = new JLabel("Foto Jug. 5");
		lblFotoJug_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFotoJug_4.setBounds(6, 252, 86, 14);
		panel.add(lblFotoJug_4);
		
		lblLogoPeque = new JLabel("Logo Peque");
		lblLogoPeque.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogoPeque.setBounds(6, 285, 86, 14);
		panel.add(lblLogoPeque);
		
		lblLogoFondo = new JLabel("Logo Fondo");
		lblLogoFondo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogoFondo.setBounds(6, 308, 86, 14);
		panel.add(lblLogoFondo);
		
		txtLogoBig = new KentukiTemplateText("logo1");
		txtLogoBig.setText("TeamLogoBig/");
		txtLogoBig.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLogoBig.setColumns(10);
		txtLogoBig.setBounds(94, 305, 256, 20);
		panel.add(txtLogoBig);
		
		txtLogoSmall = new KentukiTemplateText("logo2");
		txtLogoSmall.setText("TeamLogoSmall/");
		txtLogoSmall.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLogoSmall.setColumns(10);
		txtLogoSmall.setBounds(94, 282, 256, 20);
		panel.add(txtLogoSmall);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Kentuki", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(137, 432, 250, 117);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(168, 81, 76, 23);
		panel_1.add(btnEnviar);
		
		txtTemplateName = new JTextField();
		txtTemplateName.setBounds(6, 82, 152, 20);
		panel_1.add(txtTemplateName);
		txtTemplateName.setText("roster");
		txtTemplateName.setColumns(10);
		
		txtIp = new JTextField();
		txtIp.setBounds(6, 37, 152, 20);
		panel_1.add(txtIp);
		txtIp.setText("192.168.1.11");
		txtIp.setColumns(10);
		
		JButton btnNewButton = new JButton("Conectar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				connectToKentukiOrError(txtIp.getText(), 5250);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(165, 37, 76, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblStoredDataName = new JLabel("Stored Data Name");
		lblStoredDataName.setBounds(6, 68, 152, 14);
		panel_1.add(lblStoredDataName);
		
		JLabel lblIpDelServidor = new JLabel("IP del servidor de Kentuki");
		lblIpDelServidor.setBounds(10, 22, 148, 14);
		panel_1.add(lblIpDelServidor);
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				sendTemplateDataOrError(txtTemplateName.getText());
			}
		});
		
		for (Component c : this.getContentPane().getComponents())
		{
			if (c instanceof KentukiTemplateText)
			{
				if (c == txtTemplateName)
					continue;
				
				((KentukiTemplateText)c).getDocument().addDocumentListener(new DocumentListener()
				{

					@Override
					public void changedUpdate(DocumentEvent arg0) {
						sendTemplateDataOrError(txtTemplateName.getText());
					}

					@Override
					public void insertUpdate(DocumentEvent arg0) {
						sendTemplateDataOrError(txtTemplateName.getText());
					}

					@Override
					public void removeUpdate(DocumentEvent arg0) {
						sendTemplateDataOrError(txtTemplateName.getText());
					}
					
				});
			}
			
			if (c instanceof JSpinner)
			{
				((JSpinner)c).addChangeListener(new ChangeListener() {
	
					@Override
					public void stateChanged(ChangeEvent arg0) {
						sendTemplateDataOrError(txtTemplateName.getText());
					}
	
				});
			}
		}
	}
}
