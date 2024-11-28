package it.corsoAccenture.Interfaces;

import java.util.List;

import it.corsoAccenture.Entities.Genere;

public interface GenereDAO {

	public void addGenere(Genere g);
	public List<Genere> readGenere(); 
	public void updateGenere(); 
	public void deleteGenere(); 
}
