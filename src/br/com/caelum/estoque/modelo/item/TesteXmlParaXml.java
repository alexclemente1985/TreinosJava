package br.com.caelum.estoque.modelo.item;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class TesteXmlParaXml {

	static final String XML_PATH = "C:\\Users\\Alexandre\\treino\\workspaces\\alura\\soap\\estoquews\\item.xml";
	static final String XML = getFileName(XML_PATH);
	static final String CPD_XML = getCpFileName(XML);//"item_copy.xml";

	public static void main(String[] args) throws JAXBException, FileNotFoundException {

		try {
			System.out.println("Início do programa");
			InputStream stream = getStream(XML_PATH);
			
			//Leitura do xml existente
			Item cp = xml_reader(stream);
			System.out.println("Arquivo "+ XML + " lido com sucesso!");
			
			//Criação da cópia do xml
			xml_writer(cp);
			System.out.println("Arquivo "+ CPD_XML + " criado com sucesso!");

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		} catch (JAXBException e) {
			System.out.println("Erro no processamento do JAXB: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro genérico: " + e.getMessage());
		} finally {
			System.out.println("Programa encerrado!");
		}

	}

	private static InputStream getStream(String xmlPath) throws FileNotFoundException {

			File xml = new File(xmlPath);
			InputStream stream = new FileInputStream(xml);

			return stream;

	}
	
	private static Item xml_reader(InputStream stream) throws JAXBException{
		
		JAXBContext context = JAXBContext.newInstance(Item.class);
		Unmarshaller unmarsh = context.createUnmarshaller();
		Item copy = (Item) unmarsh.unmarshal(stream);
		
		return copy;
	}
	
	private static void xml_writer(Item item) throws JAXBException{
		
		File copy = new File(CPD_XML);
		
		JAXBContext context = JAXBContext.newInstance(Item.class);
		Marshaller marsh = context.createMarshaller();
		marsh.marshal(item, copy);

	}
	
	private static String getFileName(String xml_path) {
		
		
		String[] splitted = xml_path.split("["+Pattern.quote("\\")+"]");
		
		//System.out.println("file path dividido: "+ Arrays.toString(splitted));
		
		String filename = splitted[splitted.length -1];
		
		//System.out.println("Arquivo: "+ filename);
		
		return filename;
	}
	
	private static String getCpFileName(String xml) {
		String[] splitted = xml.split("["+Pattern.quote(".")+"]");
		//System.out.println("file path dividido: "+ Arrays.toString(splitted));
		
		String cpFileName = splitted[0]+"_copy."+splitted[1];
		return cpFileName;
	}

}
