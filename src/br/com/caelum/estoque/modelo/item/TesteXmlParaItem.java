package br.com.caelum.estoque.modelo.item;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TesteXmlParaItem {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Item.class);
		Unmarshaller unmarsh = context.createUnmarshaller();

		InputStream stream = new FileInputStream(
				new File("C:\\Users\\Alexandre\\treino\\workspaces\\alura\\soap\\estoquews\\item.xml"));
		
		Item item = (Item) unmarsh.unmarshal(stream);
		
		//Item item = JAXitem.getValue();
		
		
		
		System.out.println("Item: " + item.getCodigo());
		System.out.println("Nome: " + item.getNome());
		System.out.println("Tipo: " + item.getTipo());
		System.out.println("Quantidade: " + item.getQuantidade());

	}

}
