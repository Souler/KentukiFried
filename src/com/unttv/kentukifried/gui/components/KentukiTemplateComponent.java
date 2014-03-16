package com.unttv.kentukifried.gui.components;

/**
 * Clase que representa de forma abstracta cada uno de los elementos del formulario que
 * se utilizaran para popular un template Flash de Kentuki.
 * 
 * Cualquier componente que agreguemos a forumlarios orientados a rellenar templates
 * deberian implementar esta clase.
 * 
 * @author Juan Jose Herrero Barbosa
 * 
 */
public interface KentukiTemplateComponent
{
	/**
	 * Devuelve el nombre de la variable del template
	 * @return String nombre de la variable del template.
	 */
	public String getTemplateVarName();
	
	/**
	 * Devuelve el contenido de la variable para rellenar el template 
	 * @return String contenido de la variable.
	 */
	public String getTemplateVarValue();
	
	/**
	 * Establece un nuevo valor para el contenido de la variable del template. 
	 */
	public void setTemplateVarValue(String value);
	
	/**
	 * Devuelve un xml que contiene el nombre de la variable y su contenido en el
	 * formato standar que acepta Kentuki.
	 * @return String XML con toda la informacion de la variable.
	 */
	public String getXML();
}
