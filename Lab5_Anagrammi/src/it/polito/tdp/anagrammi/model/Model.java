package it.polito.tdp.anagrammi.model;

import java.util.*;
import java.util.stream.Collectors;

import it.polito.tdp.anagrammi.DAO.VocabolarioDAO;


public class Model {
	
	VocabolarioDAO vocabolarioDAO ;
	private List<String> paroleAnagrammi;
	private int n;
	
	public Model() {
		vocabolarioDAO = new VocabolarioDAO();
	}

	public List<String> doAnagramma(String parola) {
		paroleAnagrammi=new ArrayList<>();
		this.n=parola.length();
		List<Character> lista = parola.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		this.recursive("", lista, 0);
		return this.paroleAnagrammi;
	}
	
	public void recursive(String parziale, List<Character> parola, int livello) {
		if(livello>=n) {
			paroleAnagrammi.add(parziale);
			return;
		}
		StringBuilder sb = new StringBuilder(parziale);
		for(int i = 0; i < parola.size(); i++) {
			Character c = parola.get(i);
			sb.append(c);
			parola.remove(c);
			this.recursive(sb.toString(), parola, livello+1);
			sb.setLength(sb.length() - 1);
			parola.add(i, c);;
		}
		return;
	}
	
	public boolean isCorrect(String parola) {
		return vocabolarioDAO.isCorrect(parola);
	}
}
