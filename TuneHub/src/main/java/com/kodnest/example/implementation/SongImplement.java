package com.kodnest.example.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.example.userentity.Song;
import com.kodnest.example.userrepository.SongRepository;
import com.kodnest.example.userservice.SongService;
@Service
public class SongImplement implements SongService {
	@Autowired
	SongRepository songrepository;

	@Override
	public void addSongDetails(Song song) {
		songrepository.save(song);

	}

	@Override
	public boolean songExist(Song song) {
		Song existSong=songrepository.findByName(song.getName());
		if(existSong!=null) {
			System.out.println("Song is Present");
			return true;
		}else {
			System.out.println("Song is Absent");
			return false;
		}

	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = songrepository.findAll();
		return songs;
	}

	@Override
	public void updatesong(Song song) {
		songrepository.save(song);
	}

	
	}
