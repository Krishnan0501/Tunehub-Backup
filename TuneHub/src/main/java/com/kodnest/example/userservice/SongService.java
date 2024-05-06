package com.kodnest.example.userservice;


import java.util.List;

import com.kodnest.example.userentity.Song;


public interface SongService {


	void addSongDetails(Song song);

	boolean songExist(Song song);

	List<Song> fetchAllSongs();

	void updatesong(Song song);

	

	

	

	

}
