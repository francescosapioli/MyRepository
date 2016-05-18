package it.polito.tdp.lab4.quadratoMagico;

import java.util.HashMap;
import java.util.Map;

public class Quad {
	
	private Map<Pos,Integer> quad;
	private Integer num;
	private static boolean flag = false;

	
	public Quad(Integer num) {
	
		this.num = num;
		quad = new HashMap<Pos,Integer>();
		
		for(int i=0; i<num; i++){
			for(int j=0; i<num;j++){
				Pos p = new Pos(i,j);
				quad.put(p, null);
			}
		}
		
	}
	
	public void ric(Integer step){
		
		if(flag == true)
			return;
		if(step == num){
			flag = this.verifica();
			return;
		}
		for(int i=step; i<num; i++){
			for(int j=step; j<num; j++){
				quad.put(new Pos(i,j), step+1);
				
				this.ric(step+1);
			}
			
			
		}
		
		
	}

	@Override
	public String toString() {
		String s = "";
		for(int i=0; i<num; i++){
			for(int j=0; j<num; j++){
				Pos p = new Pos(i,j);
				s += quad.get(p).toString()+"-";
			}
			s += "\n";
		}
		return s;
	}
	
	public boolean verifica(){
		int sommaPrimaRiga = 0;
		int sommaRiga = 0;
		int sommaColonna = 0;
		int sommaDiagSx = 0;
		int sommaDiagDx = 0;
		
		//uso il valore della prima riga per i confronti successivi
		for(int i=0; i<num;i++){
			sommaPrimaRiga += quad.get(new Pos(0,i));
		}
		//verifico le righe, le colonne e le diagonali
		for(int i=0; i<num; i++){
			sommaRiga = 0;
			sommaColonna = 0;
			sommaDiagSx = 0;
			sommaDiagDx = 0;
			for(int j=0; j<num; j++){
				sommaRiga += quad.get(new Pos(i,j));
				sommaColonna += quad.get(new Pos(j,i));
				sommaDiagSx += quad.get(new Pos(j,j));
				sommaDiagDx += quad.get(new Pos(j,num-j-1));
				
			}
			if(sommaPrimaRiga!=sommaRiga || sommaPrimaRiga!= sommaColonna || sommaPrimaRiga!=sommaDiagSx ||
					sommaPrimaRiga!=sommaDiagDx)
				return false;
		}
		return true;
	}
	
	
	

}
