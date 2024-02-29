package model;

import java.util.ArrayList;

import model.NIT.AnimeNIT;

public class MostrarTodosAnimes {
	
	public static void main(String[] args) {
		
		AnimeNIT animeNIT = new AnimeNIT();
		ArrayList<Anime> animes = animeNIT.mostrarTodos();
		
		for(Anime anime:animes) {
			System.out.println("Nome: " + anime.getNome());
			System.out.println("Temporada: " + anime.getTemporada());
			System.out.println("Episodio: " + anime.getEpisodio());
			System.out.println("");
		}
	}
}
