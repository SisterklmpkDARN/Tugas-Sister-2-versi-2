/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author hades
 */
public class ImplementasiCuaca extends UnicastRemoteObject implements CuacaInterfaces {
int nama;
private String Cuaca;
    public ImplementasiCuaca(int i) throws RemoteException{
        this.nama = i;
    }

    public int getNamaClient(){
        return this.nama;
    }
    @Override
    public String cekCuacaDunia(String url) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cekCuacaHarian(String url) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cekCuacaIndo(String url,String Kota) throws RemoteException {
       
       try {
 
	
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(url);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
           System.out.println("Client meminta info cuaca indonesia di kota "+Kota);
	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("Row");
 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;/*
			System.out.println("Kota : " + eElement.getElementsByTagName("Kota").item(0).getTextContent());
			System.out.println("Cuaca : " + eElement.getElementsByTagName("Cuaca").item(0).getTextContent());
			System.out.println("Suhu min : " + eElement.getElementsByTagName("SuhuMin").item(0).getTextContent());
			System.out.println("Suhu max : " + eElement.getElementsByTagName("SuhuMax").item(0).getTextContent());
                        */
                        if(eElement.getElementsByTagName("Kota").item(0).getTextContent().equalsIgnoreCase(Kota))
                        {   
                            setCuaca(eElement.getElementsByTagName("Cuaca").item(0).getTextContent());
                        }
 
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
        return ("Cuaca: "+getCuaca());
    }

    @Override
    public String cekCuacaJabodetabek(String url) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cekCuacaWisata(String url) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the City
     */
   

    /**
     * @return the Cuaca
     */
    public String getCuaca() {
        return Cuaca;
    }

    /**
     * @param Cuaca the Cuaca to set
     */
    public void setCuaca(String Cuaca) {
        this.Cuaca = Cuaca;
    }
    
}
