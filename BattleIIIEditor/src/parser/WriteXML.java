package parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class WriteXML 
{
	
	private static String fichierCible;

	
	public static void setFichierCible(String cible)
	{
		fichierCible = cible;
	}
	
	public static String getFichierCible()
	{
		return fichierCible;
	}
	
	
	public static void ecrireArme(String id, String nom, int degPhy, int degMag, int defPhy, int defMag, String idImg, String img, String type) throws Exception
	{
		SAXBuilder sx = new SAXBuilder();
		
		Document doc = sx.build(new File(fichierCible));
		
		Element root = doc.getRootElement();
		Element arme = new Element("arme");
		Attribute idA = new Attribute("id", id);
		Attribute nomA = new Attribute("nom", nom);
		Attribute atqPhyA = new Attribute("degPhy", String.valueOf(degPhy));
		Attribute atqMagA = new Attribute("degMag", String.valueOf(degMag));
		Attribute defPhyA = new Attribute("defPhy", String.valueOf(defPhy));
		Attribute defMagA = new Attribute("defMag", String.valueOf(defMag));
		Attribute idImgA = new Attribute("idImg", String.valueOf(idImg));
		Attribute imgA = new Attribute("img", img);
		Attribute typeA = new Attribute("type", type);
		
		arme.setAttribute(idA);
		arme.setAttribute(nomA);
		
		root.addContent(arme);
		
		enregistreFichier(doc);
	}
	
	
   public static void enregistreFichier(Document document) throws Exception
   {
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(document, new FileOutputStream(fichierCible));
   }
}
