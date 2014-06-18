package launcher;

import parser.WriteXML;
import gui.Fenetre;
import gui.Test;

public class BIIIEditor {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Fenetre.init();
		new Fenetre().setVisible(true);
		//new Test();
		WriteXML.setFichierCible("test/arme.xml");
		
		System.out.println((double)5/2);
		
		try
		{
			//WriteXML.ecrireArme("1", "test");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
