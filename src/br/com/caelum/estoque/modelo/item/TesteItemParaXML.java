package br.com.caelum.estoque.modelo.item;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TesteItemParaXML {
	public static void main(String[] args) throws JAXBException {
		Item item = new Item.Builder().comCodigo("MEA").comNome("MEAN").comQuantidade(4).comTipo("Livro").build();

		try {

			JAXBContext context = JAXBContext.newInstance(Item.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(item, new File("item.xml"));

			testeXmlParaItem();
/*
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de leitura não encontrado. Erro: " + e.getMessage());
		} catch (JAXBException e) {
			System.out.println("Erro no processo do JAXB. Erro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro genérico: " + e.getMessage());
		}
*/
		} catch(Exception e) {
			if(e instanceof FileNotFoundException) {
				System.out.println("Arquivo de leitura não encontrado. Erro: " + e.getMessage());
			}else if(e instanceof JAXBException) {
				System.out.println("Erro no processo do JAXB. Erro: " + e.getMessage());
			}else {
				System.out.println("Erro genérico: " + e.getMessage());
			}
		}
	}

	private static void testeXmlParaItem() throws JAXBException, FileNotFoundException {

		JAXBContext context = JAXBContext.newInstance(Item.class);
		Unmarshaller unmarsh = context.createUnmarshaller();

		InputStream stream = new FileInputStream(
				new File("C:\\Users\\Alexandre\\treino\\workspaces\\alura\\soap\\estoquews\\item.xml"));

		Item item = (Item) unmarsh.unmarshal(stream);

		
		System.out.println("Item: " + item.getCodigo());
		System.out.println("Nome: " + item.getNome());
		System.out.println("Tipo: " + item.getTipo());
		System.out.println("Quantidade: " + item.getQuantidade());

	}

}
