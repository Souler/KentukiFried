package com.unttv.kentukifried.gui.frame;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.unttv.kentukifried.gui.components.KentukiTemplateSpinner;
import com.unttv.kentukifried.gui.components.KentukiTemplateText;

import java.awt.Font;

@SuppressWarnings("serial")
public class KentukiMatchFrame extends KentukiTemplateFrame
{
	private KentukiTemplateText txtTeamName1;
	private KentukiTemplateSpinner txtTeamScore1;
	private KentukiTemplateText txtTeamName2;
	private KentukiTemplateSpinner txtTeamScore2;
	private KentukiTemplateText txtBasepath;
	private JTextField txtTemplateName;
	private KentukiTemplateText txtTeamLogo1;
	private KentukiTemplateText txtTeamLogo2;
	private JLabel lblLogoopcional;
	private JLabel lblLogoopcional_1;
	private KentukiTemplateText txtInfo;
	private JLabel lblInfo;
	private JLabel lblPunt;
	private JLabel label;
	private JPanel panel;
	private JTextField txtIp;
	private KentukiTemplateText txtGame;

	/**
	 * Create the application.
	 */
	public KentukiMatchFrame()
	{
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		this.setName("Matcher");
		this.setTitle("Kentuki Fried Matcher");
		this.setBounds(100, 100, 274, 490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del template", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 250, 327);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtTeamName1 = new KentukiTemplateText("team1");
		txtTeamName1.setBounds(26, 29, 86, 20);
		panel.add(txtTeamName1);
		txtTeamName1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTeamName1.setColumns(10);
		
		txtTeamName2 = new KentukiTemplateText("team2");
		txtTeamName2.setBounds(132, 29, 86, 20);
		panel.add(txtTeamName2);
		txtTeamName2.setColumns(10);
		
		txtTeamScore1 = new KentukiTemplateSpinner("score1");
		txtTeamScore1.setBounds(72, 60, 40, 33);
		panel.add(txtTeamScore1);
		
		txtTeamScore2 = new KentukiTemplateSpinner("score2");
		txtTeamScore2.setBounds(142, 60, 38, 33);
		panel.add(txtTeamScore2);
		
		JLabel lblNewLabel = new JLabel("Equipo 1");
		lblNewLabel.setBounds(26, 16, 86, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_1 = new JLabel("Equipo 2");
		lblNewLabel_1.setBounds(132, 16, 86, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblBasePath = new JLabel("Carpeta de los logos [opcional]");
		lblBasePath.setBounds(6, 240, 238, 14);
		panel.add(lblBasePath);
		
		txtBasepath = new KentukiTemplateText("basePath");
		txtBasepath.setText("S:/Kentuki/EGO_STADIUM/templates_assets/");
		txtBasepath.setBounds(6, 254, 238, 20);
		panel.add(txtBasepath);
		txtBasepath.setColumns(10);
		
		JButton btnSwitch = new JButton("Intercambiar equipos");
		btnSwitch.setBounds(6, 206, 238, 23);
		panel.add(btnSwitch);
		
		txtTeamLogo1 = new KentukiTemplateText("logo1");
		txtTeamLogo1.setText("TeamLogoMedium/");
		txtTeamLogo1.setBounds(6, 128, 106, 20);
		panel.add(txtTeamLogo1);
		txtTeamLogo1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTeamLogo1.setColumns(10);
		
		txtTeamLogo2 = new KentukiTemplateText("logo2");
		txtTeamLogo2.setText("TeamLogoMedium/");
		txtTeamLogo2.setBounds(132, 128, 112, 20);
		panel.add(txtTeamLogo2);
		txtTeamLogo2.setColumns(10);
		
		lblLogoopcional = new JLabel("Logo1 [opcional]");
		lblLogoopcional.setBounds(6, 114, 106, 14);
		panel.add(lblLogoopcional);
		lblLogoopcional.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblLogoopcional_1 = new JLabel("Logo2 [opcional]");
		lblLogoopcional_1.setBounds(132, 114, 112, 14);
		panel.add(lblLogoopcional_1);
		
		txtInfo = new KentukiTemplateText("info");
		txtInfo.setBounds(6, 175, 238, 20);
		panel.add(txtInfo);
		txtInfo.setColumns(10);
		
		lblInfo = new JLabel("Info");
		lblInfo.setBounds(6, 159, 238, 14);
		panel.add(lblInfo);
		
		lblPunt = new JLabel("Punt.");
		lblPunt.setBounds(26, 69, 46, 14);
		panel.add(lblPunt);
		lblPunt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		label = new JLabel("Punt.");
		label.setBounds(183, 69, 46, 14);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblGame = new JLabel("Juego");
		lblGame.setBounds(6, 285, 238, 14);
		panel.add(lblGame);
		
		txtGame = new KentukiTemplateText("logo0");
		txtGame.setText("game/");
		txtGame.setColumns(10);
		txtGame.setBounds(6, 299, 238, 20);
		panel.add(txtGame);
		btnSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String team1Name  = txtTeamName1.getText();
				int team1Score = Integer.parseInt(txtTeamScore1.getTemplateVarValue());
				String team1Logo  = txtTeamLogo1.getText();
				
				txtTeamName1.setText(txtTeamName2.getText());
				txtTeamScore1.setTemplateVarValue(txtTeamScore2.getTemplateVarValue());
				txtTeamLogo1.setText(txtTeamLogo2.getText());
				
				txtTeamName2.setText(team1Name);
				txtTeamScore2.setValue(team1Score);
				txtTeamLogo2.setText(team1Logo);
				
				sendTemplateDataOrError(txtTemplateName.getText());
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Kentuki", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 340, 250, 117);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(168, 81, 76, 23);
		panel_1.add(btnEnviar);
		
		txtTemplateName = new JTextField();
		txtTemplateName.setBounds(6, 82, 152, 20);
		panel_1.add(txtTemplateName);
		txtTemplateName.setText("data");
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
			
			if (c instanceof KentukiTemplateSpinner)
			{
				((KentukiTemplateSpinner)c).addChangeListener(new ChangeListener() {
	
					@Override
					public void stateChanged(ChangeEvent arg0) {
						sendTemplateDataOrError(txtTemplateName.getText());
					}
	
				});
			}
		}
	}
	
}
