package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;

public class TestModel {

	public static void main(String[] args) {
		
		Dictionary d;
		LinkedList<String> l = new LinkedList<String>();
		
		d = new EnglishDictionary();
		
		System.out.println(d.toString());
		
		d.loadDictionary();
		
		l.add("the");
		l.add("only");
		l.add("wai");
		l.add("is");
		l.add("the");
		l.add("loove");
		
		
		
		
		System.out.println(d.spellCheckText(l).toString());
		
		
		System.out.println("");
		d = new ItalianDictionary();
		
		System.out.println(d.toString());
		
		d.loadDictionary();
		
		l.clear();
		
		l.add("ciao");
		l.add("io");
		l.add("mi");
		l.add("chiaamo");
		l.add("noewfp");
		l.add("vnois");
		
		System.out.println(d.spellCheckText(l).toString());

	}

}
