package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.net.httpserver.Filter;

public class AppListas {
	public static void main(String[] args) {
		//lista não aceita tipos primitivos, apenas Wrapper classes
		List<String> list = new ArrayList<String>();
		
		list.add("maria");
		list.add("alex");
		list.add("bob");
		list.add("ana");
		
		
		list.add(2, "marco");
		
		for(String lista:list) {
			
			System.out.println(lista);
		}
		
		System.out.println(list.size());
		System.out.println("--------------");
		
		list.remove("alex");
		
		for(String lista:list) {
			
			System.out.println(lista);
		}
		
		System.out.println(list.size());
		System.out.println("--------------");
		
		list.remove(2);
		
		for(String lista:list) {
			
			System.out.println(lista);
		}
		
		System.out.println(list.size());
		System.out.println("--------------");
		list.removeIf(x -> x.charAt(0)=='m');//função lambda -> disponível a partir do java 8
		
		for(String lista:list) {
			
			System.out.println(lista);
		}
		
		System.out.println(list.size());
		System.out.println("--------------");
		
		System.out.println("Index of Ana: "+ list.indexOf("ana"));
		
		System.out.println("--------------");
		
		list.add("mateus");
		list.add("marcos");
		
		List<String> result = list.stream().filter(x -> x.charAt(0)=='m').collect(Collectors.toList()); 
		
		for(String lista : result) {
			System.out.println(lista);
		}
		System.out.println("--------------");
		
		String name = list.stream().filter(x-> x.charAt(0)=='a').findFirst().orElse(null);
		
		System.out.println(name);
		System.out.println("--------------");
		
	    name = list.stream().filter(x-> x.charAt(0)=='j').findFirst().orElse(null);
		
	}
}
