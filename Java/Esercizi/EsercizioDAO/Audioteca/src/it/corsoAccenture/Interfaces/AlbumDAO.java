package it.corsoAccenture.Interfaces;

import java.util.List;

import it.corsoAccenture.Entities.Album;

public interface AlbumDAO {
	
	public void addAlbum(Album a);
	public List<Album> readAlbum(); 
	public void updateAlbum(); 
	public void deleteAlbum(); 

}
