package com.unttv.kentukifried.gui.components;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
/**
 * Clase que representa valores seleccionables de una coleccion.
 * En este caso, numeros.
 * 
 * @see {@link KentukiTemplateComponent} 
 * @author Juan Jose Herrero Barbosa
 */
public class KentukiTemplateSpinner extends JSpinner implements KentukiTemplateComponent
{
	private String templateVariableName;
	
	public KentukiTemplateSpinner(String templateVariableName)
	{
		super(new SpinnerNumberModel(0, 0, 100, 1));
		this.templateVariableName = templateVariableName;
	}
	
	public String getTemplateVarValue()
	{
		return Integer.toString((Integer)super.getValue());
	}

	public void setTemplateVarValue(String value)
	{
		super.setValue(Integer.parseInt(value));
	}
	
	public String getTemplateVarName()
	{
		return templateVariableName;
	}
	
	public String getXML()
	{
		String xmlData = "<componentData id=\\\"%s\\\"><data id=\\\"text\\\" value=\\\"%s\\\" /></componentData>";
		String result = String.format(xmlData, this.getTemplateVarName(), this.getTemplateVarValue());
		
		return result;
	}
}
