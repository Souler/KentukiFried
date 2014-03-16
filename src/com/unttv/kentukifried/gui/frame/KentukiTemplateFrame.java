package com.unttv.kentukifried.gui.frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.net.telnet.TelnetClient;

import com.unttv.kentukifried.gui.components.KentukiTemplateComponent;

@SuppressWarnings("serial")
public class KentukiTemplateFrame extends JFrame
{	
	/**
	 * Cliente de telnet para la conexion con el servidor de Kentuki
	 */
	private TelnetClient telnetClient;
	
	/**
	 * Constructor.
	 * Llamamos al constructor de {@code JFrame} y inicializamos el cliente telnet.
	 */
	public KentukiTemplateFrame()
	{
		super();
		telnetClient = new TelnetClient();
		
		addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
			  try {
				saveFormDataToFile("config.ini");
			} catch (IOException e1) {
				showErrorMessageBox("No se pudo guardar la configuracion");
			}
		  }
		});
	}
	
	/**
	 * Connectamos con el servidor de Kentuki.
	 * 
	 * @param host IP del servidor
	 * @param port Puerto para la conexion
	 * @throws IOException Cuando ocurren problemas en la conexion
	 */
	public void connectToKentuki(String host, int port) throws IOException
	{
		telnetClient.connect(host, port);
	}
	
	/**
	 * Intenta conectar con el servidor de Kentuki. En caso de que haya un error de
	 * conexion muestra una ventana de error con una descripcion sobre el mismo.
	 * 
	 * La llamda a este metodo es equivalente a llamar a {@code connectToKentuki} capturando
	 * las excepciones y mostrando la ventana de error en caso de que ocurran.
	 *  
	 * @param host IP del servidor
	 * @param port Puerto para la conexion
	 */
	public void connectToKentukiOrError(String host, int port)
	{
		try
		{
			connectToKentuki(host, port);
		}
		catch (IOException e)
		{
			showErrorMessageBox(e.getMessage());
		}
	}
	
	/** 
	 * Determina si actualmente estamos conectados al servidor de Kentuki
	 * 
	 * @return true si estamos conectados, false en caso contrario.
	 */
	public boolean isConnectedToKentuki()
	{
		return telnetClient.isConnected();
	}
	
	/**
	 * Envia la orden de almacenamiento de los datos del template al servidor.
	 * 
	 * @param templateDataName Nombre con el que guardar los datos en el servidor.
	 * @throws IOException Si hay algun error de comunicacion con el servidor.
	 */
	public void sendTemplateData(String templateDataName) throws IOException
	{
		OutputStream outstr = telnetClient.getOutputStream();
		
		if (outstr == null)
			throw new IOException("Not connected to server.");
		
		StringBuilder commandBuilder = new StringBuilder("data store ");
		commandBuilder.append(templateDataName);
		commandBuilder.append(" ");
		commandBuilder.append("\"");
		commandBuilder.append(getTemplateXML());
		commandBuilder.append("\"");
		commandBuilder.append("\r\n");
        String str = commandBuilder.toString();
        
		outstr.write(str.getBytes(), 0 , str.getBytes().length);
		outstr.flush();
	}
	
	/**
	 * Intenta enviar los datos del template al servidor.
	 * En caso de que haya error muestra un cuadro de dialogo con una descripcion
	 * del mismo
	 * 
	 * La llamada a este metodo es equivalente a llamar a {@code sendTemplateData} y
	 * al capturar una excepcion mostrar el cuadro de dialogo.
	 * 
	 * @param templateDataName nombre con el que guardar los datos del template
	 */
	public void sendTemplateDataOrError(String templateDataName)
	{
		try
		{
			sendTemplateData(templateDataName);
		}
		catch (IOException e)
		{
			showErrorMessageBox(e.getMessage());
		}
	}
	
	/**
	 * Guarda el valor todos los campos del formulario relacionados con el template
	 * en un archivo para su posterior uso.
	 * 
	 * @param filename Archivo de destino
	 * @throws IOException Errores de escritura en el archivo.
	 * 
	 */
	public void saveFormDataToFile(String filename) throws IOException
	{
		Properties prop = new Properties();
		
		for (Component c : getAllComponents())
			if (c instanceof KentukiTemplateComponent)
				if (c != null)
					prop.setProperty(this.getName() + '.' +((KentukiTemplateComponent) c).getTemplateVarName(), ((KentukiTemplateComponent) c).getTemplateVarValue());

		
		OutputStream os = new FileOutputStream("config.ini");
		prop.store(os, filename);
	}
	
	/**
	 * Carga desde un archivo el valor de los componentes del formulario relacionados
	 * con el template.
	 * 
	 * @param filename Archivo de origen de datos
	 * @throws IOException Errores de lectura del archivo
	 * 
	 */
	public void loadFormDataFromFile(String filename) throws IOException
	{
		Properties prop = new Properties();
		
		InputStream input = new FileInputStream(filename);
		prop.load(input);
		
		for (Component c : getAllComponents())
			if (c instanceof KentukiTemplateComponent)
				if (prop.containsKey(this.getName() + '.' +((KentukiTemplateComponent) c).getTemplateVarValue()))
					((KentukiTemplateComponent) c).setTemplateVarValue(prop.getProperty(this.getName() + '.' +((KentukiTemplateComponent) c).getTemplateVarValue()));
	}
	
	/**
	 * Recopila los datos de todos los elementos del formulario relacionados con
	 * el template y genera el XML completo asociado.
	 * 
	 * @return el XML completo asociado.
	 */
	public String getTemplateXML()
	{
		StringBuilder resultBuilder = new StringBuilder();
		
		resultBuilder.append("<templateData>");
		for (Component c : getContentPane().getComponents())
			if (c instanceof KentukiTemplateComponent)
				resultBuilder.append(((KentukiTemplateComponent)c).getXML());

		resultBuilder.append("</templateData>");
		
		return resultBuilder.toString();
	}
	
	// TODO: Terminar de implementar
	public String getRemoteXMLData(String dataName)
	{
		
		OutputStream outstr = null;//tc.getOutputStream();
		StringBuilder commandBuilder = new StringBuilder("data retrieve ");
		commandBuilder.append(dataName);
		
        String str = commandBuilder.toString();
        
        System.out.println(str);
        try
        {
			outstr.write(str.getBytes(), 0 , str.getBytes().length);
			outstr.flush();
		}
        catch (IOException e1) {
			e1.printStackTrace();
		}
        
        InputStream instr = null;//tc.getInputStream();

        try
        {
            byte[] buff = new byte[1024];
            int ret_read = 0;

            for (int i=0; i<3; i++)
            {
                ret_read = instr.read(buff);
                if(ret_read > 0)
                {
                    System.out.print(new String(buff, 0, ret_read));
                }
            }
            //while (false);
        }
        catch (IOException e)
        {
            System.err.println("Exception while reading socket:" + e.getMessage());
        }
        
        return "";
	}
	
	/**
	 * Metodo suplementario para mostrar dialogos de error de forma rapida.
	 * 
	 * @param error
	 */
	protected void showErrorMessageBox(String error)
	{
		JOptionPane.showMessageDialog(this,
				error,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Metodo de llamada inicial al metodo recursivo de listado de elemntos.
	 * 
	 * @return Lista que contiene todos los componentes del formulario
	 */
	public List<Component> getAllComponents() {
		return getAllComponents(getContentPane());
	}
	
	/**
	 * Metodo recursivo que devuelve TODOS los elementos del formulario.
	 * Es necesario si queremos poder iterar por todos los elementos del form y estos
	 * estan metidos dentro de paneles anidados.
	 * 
	 * @param c componente que vamos a recorer
	 * @return Lista que contiene todos los elementos del contenedor pasado como parametro
	 */
	private List<Component> getAllComponents(Container c)
	{
	    Component[] comps = c.getComponents();
	    List<Component> compList = new ArrayList<Component>();
	    for (Component comp : comps) {
	        compList.add(comp);
	        if (comp instanceof Container)
	            compList.addAll(getAllComponents((Container) comp));
	    }
	    return compList;
	}
}
