package it.corsoAccenture.Entities;

public class Album {
	private int id_album;
	private String nomeAlbum;
	private String titolo; 

	public Album(int id_album, String nomeAlbum, String titolo ) {
		super(); 
		this.id_album = id_album; 
		this.nomeAlbum = nomeAlbum; 
		this.titolo = titolo; 	
	}
	
	public Album() {
			
	}
	

	public int getId_album() {
		return id_album;
	}

	public void setId_album(int id_album) {
		this.id_album = id_album;
	}

	public String getNomeAlbum() {
		return nomeAlbum;
	}

	public void setNomeAlbum(String nomeAlbum) {
		this.nomeAlbum = nomeAlbum;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "\n id_album:" + id_album + "\n nomeAlbum:" + nomeAlbum + "\n titolo:" + titolo;
	}
	
	
}
