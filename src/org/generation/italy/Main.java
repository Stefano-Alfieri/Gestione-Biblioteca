package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Libro;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
	public String url = "jdbc:mysql://localhost:3306/biblioteca";
	public String sql;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sceltaMenu, sceltaMenuLibri;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int idLibr = 0;
		System.out.println("Benvenuto nella Bibilioteca comunale Acclavio");
		System.out.println(
				"inserire (1) per la Gestione dei Libri, (2) per la Gestione degli utenti:, (3) per la Gestione del Magazzino, (4) per Ricerca e Filtraggi, (5) Reportistica.");
		sceltaMenu = sc.nextLine();
		switch (sceltaMenu) {
		case "1":
			System.out.println("Benvenuto nel menu della gestione dei libri");
			System.out.println(
					"inserire (1) per inserire un nuovo libro, (2) visualizzare la lista di libri, (3) per cancellare un libro, (4) per modificare libro, (5) esci.");
			Libro libro = new Libro();
			sceltaMenuLibri = sc.nextLine();
			switch (sceltaMenuLibri) {
			case "1":
				String nomeAutore;
				String nomeGenere;
				// inserimento libro
				System.out.println("inserisci il titolo del libro da  aggiungere");
				libro.nome = sc.nextLine();
				System.out.println("inserisci la data di uscita del libro");
				libro.anno = LocalDate.parse(sc.nextLine(), df);
				System.out.println("inserisci il codice ISBN");
				libro.codice = sc.nextLine();
				System.out.println("inserisci la quantità di copie");
				libro.giacenza = sc.nextInt();
				sc.nextLine();
				System.out.println("inserisci il nome dell'autore");
				nomeAutore = sc.nextLine();
				Libro.ricercaAutori(nomeAutore);
				System.out.println("inserisci l'id dell'autore");
				libro.id_autore = sc.nextInt();
				sc.nextLine();
				System.out.println("inserisci il genere");
				nomeGenere = sc.nextLine();
				Libro.ricercaGenere(nomeGenere);
				System.out.println("inserisci l'id del genere");
				libro.id_genere = sc.nextInt();
				sc.nextLine();
				Libro.InserisciLibro(libro);
				System.out.println("libro aggiunto");
				break;
			// stampa libri
			case "2":
				System.out.println("visualizzare la lista dei libri");
				Libro.stampaLibri();
				break;
			// eliminazione libro
			case "3":
				String nomeLib;
				System.out.println("inserisci il nome del libro per visualizzarne l'id");
				nomeLib = sc.nextLine();
				Libro.ricercaLibro(nomeLib);
				System.out.println("inserisci l'id del libro da eliminare");
				libro.id = sc.nextInt();
				sc.nextLine();
				Libro.eliminazioneLibro(libro.id);
				// modifica libro
			case "4":
				String nomeLibMod;
				System.out.println("inserisci il nome del libro per visualizzarne l'id");
				nomeLibMod = sc.nextLine();
				Libro.ricercaLibro(nomeLibMod);
				System.out.println("inserisci l'id del libro da modificare");
				libro.id = sc.nextInt();
				sc.nextLine();
				System.out.println("inserisci il titolo del libro");
				libro.nome = sc.nextLine();
				System.out.println("inserisci la data di uscita del libro");
				libro.anno = LocalDate.parse(sc.nextLine(), df);
				System.out.println("inserisci il codice ISBN");
				libro.codice = sc.nextLine();
				System.out.println("inserisci la quantità di copie");
				libro.giacenza = sc.nextInt();
				sc.nextLine();
				System.out.println("inserisci il nome dell'autore");
				nomeAutore = sc.nextLine();
				Libro.ricercaAutori(nomeAutore);
				System.out.println("inserisci l'id dell'autore");
				libro.id_autore = sc.nextInt();
				sc.nextLine();
				System.out.println("inserisci il genere");
				nomeGenere = sc.nextLine();
				Libro.ricercaGenere(nomeGenere);
				System.out.println("inserisci l'id del genere");
				libro.id_genere = sc.nextInt();
				sc.nextLine();
				Libro.modificaLibro(libro, libro.id);
				break;
			case "5":
				System.out.println("Uscita in corso...");
				break;
			}
			break;
		}
	}

}
