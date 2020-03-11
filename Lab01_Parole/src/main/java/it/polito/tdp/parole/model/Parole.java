package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	LinkedList<String> paroleDaOrdinare;
	ArrayList<String> paroleArray;
		
	public Parole() {
		paroleDaOrdinare = new LinkedList<String>();
		paroleArray = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		paroleDaOrdinare.add(p);
	}
	
	public void addParolaArray(String p) {
		paroleArray.add(p);
	}
	
	public void removeParola(String p) {
		paroleDaOrdinare.remove(p);
	}
	
	public void removeParolaArray(String p) {
		paroleArray.remove(p);
	}
	
	public List<String> getElenco() {
		LinkedList<String> ordinata = new LinkedList<String>(paroleDaOrdinare);
		Collections.sort(ordinata);
		return ordinata;
	}
	
	public List<String> getElencoArray() {
		ArrayList<String> ordinata = new ArrayList<String>(paroleArray);
		Collections.sort(ordinata);
		return ordinata;
	}
	
	public void reset() {
		paroleDaOrdinare.clear();
		paroleArray.clear();
	}

}
