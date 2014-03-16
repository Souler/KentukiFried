package com.unttv.kentukifried.gui.components;

import javax.swing.JTextField;

/**
 * Clase que representa textos editables en los formularios de generacion de 
 * templates.
 * 
 * @see KentukiTemplateComponent
 * @author Juan Jose Herrero Barbosa
 */
@SuppressWarnings("serial")
public class KentukiTemplateText extends JTextField implements KentukiTemplateComponent
{
	private String templateVariableName;
	
	public KentukiTemplateText(String templateVariableName)
	{
		super();
		this.templateVariableName = templateVariableName;
	}
	
	public String getTemplateVarValue()
	{
		return this.getText();
	}
	
	public void setTemplateVarValue(String value)
	{
		this.setText(value);
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
