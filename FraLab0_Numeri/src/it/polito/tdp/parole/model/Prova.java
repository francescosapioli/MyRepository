package it.polito.tdp.parole.model;

public class Prova {

	public static void main(String[] args) {
		
		Parole p=new Parole();
		
		p.addParola("papa");
		p.addParola("cacca");
		p.addParola("lollo");
		
		System.out.println(p.getElenco().toString());
		
		p.reset();
		
		System.out.println(p.getElenco().toString());
		
		

	}

}
