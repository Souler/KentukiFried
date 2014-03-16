package com.unttv.kentukifried;

import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

import com.unttv.kentukifried.gui.frame.KentukiMatchFrame;
import com.unttv.kentukifried.gui.frame.KentukiRosterFrame;
import com.unttv.kentukifried.gui.frame.KentukiTemplateFrame;


public class KentukiFriedSomething
{
	public static void main(String[] args) throws SocketException, IOException
	{
		KentukiTemplateFrame window = null;
		
		// Primero comprobamos si nos han pasado la orden de ejeucion por
		// la linea de comandos al ejecutar el programa
		if (args.length > 0)
			window = processOrder(args[0]);
		
		// Si el usario nos paso la orden pro linea de comandos el while no
		// entrara en ejecicion y directamente lanzaremos la orden pasada
		// por el CLI. En caso contrario mostramos la interfaz de ayuda
		// ---
		// Esperamos a que el usuario escriba algo y lo interpretamos
		// TODO: Tal vez una implementacion mas generica de esto fuera de ayuda
		// en un futuro, pero ahora mismo NO es prioritario
		Scanner sc = new Scanner(System.in);
		while (window == null)
		{
			window = processOrder(sc.nextLine());
		}
		
		// Cerramos el IS para evitar leak de memoria
		sc.close();
		
		// Mostramos la ventana
		window.setVisible(true);
	}
	
	private static KentukiTemplateFrame processOrder(String order)
	{
		KentukiTemplateFrame window = null;
		
		switch (order)
		{
			case "match":
				window = new KentukiMatchFrame();
				break;
			case "roster":
				window = new KentukiRosterFrame();
				break;
		}
		
		return window;
	}
}
