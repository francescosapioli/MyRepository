package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;

/*Le prestazioni sono misurate in base alla media aritmetica di un campione di 20 elementi.
 * 
 *
 *
 *Modello e controller implementati con le LinkedList(ricerca classica):         1.689477635E7
 * 
 * Modello e controller implementati con le LInkedLIst(ricerca dicotomica):      2.401303805E7
 * 
 * Modello e controller implementati con le HashSet(ricerca classica):           1.42149589E7
 * Non posso usare solo HashSet, devo usare anche delle liste altrimenti
 * mi da l'output in ordine casuale, l'unica HAshSet è quella delle
 * parole del dizionario     
 * 
 * Non è possibile utilizzare la ricerca dicotomica perchè con le 
 * HashSet non c'e' alcun ordinamento
 * 
 * liste + estraggo dati da db + ricerca diccotomica:                            1.43625811145E9   
 * 
 * facendo le query al db:                                                       5.373644708E8 
 * 
 */



import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		//RichWord w = new RichWord("parola");
		//w.setCorrect(true);
		//System.out.println(w.toString());
		
		Dictionary d1 = new ItalianDictionary();
		Dictionary d2 = new EnglishDictionary();
		System.out.println(d1+"-"+d2);
		System.out.println("cacca");
		d1.loadDictionary();
		d2.loadDictionary();
		System.out.println("cacca");
		List<String> l1 = new LinkedList<String>();
		List<String> l2 = new LinkedList<String>();
		System.out.println("cacca");
		//l1.add("ciaoooooo");
		l1.add("io");
		l1.add("sono");
		l1.add("frank");
		l1.add("caccaaaaa");
		l2.add("hellooooo");
		l2.add("world");
		l2.add("just");
		l2.add("trust");
		l2.add("meeeeee");
		System.out.println("caccaaaaaaa");
	//	List<RichWord> l1c = d1.spellCheckText(l1);
	//	List<RichWord> l2c = d2.spellCheckText(l2);
		System.out.println("ccccccccccccacca");
		System.out.println("cacca");
		System.out.println("parti");
//		 System.out.println(l1c.toString());
	//     System.out.println(l2c.toString());
		
		
		String s1 = "";
		String s2 = "";
		
	//	for(RichWord rw : l1c){
		//	if(rw.isCorrect())
			//	s1 +=" "+rw.getWord().toLowerCase();
		//	else
			//	s1 +=" "+rw.getWord().toUpperCase();
			
	//	}
      //  for(RichWord rw : l2c){
        //	if(rw.isCorrect())
			//	s2 = s2+" "+rw.getWord().toLowerCase();
		//	else
			//	s2 = s2+" "+rw.getWord().toUpperCase();
			
    //    }
        
        System.out.println("inizio");
       System.out.println(s1);
       System.out.println(s2);
       System.out.println("fine");

	}

}
