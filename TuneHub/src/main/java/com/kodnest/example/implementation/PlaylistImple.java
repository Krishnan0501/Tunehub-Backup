package com.kodnest.example.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.example.userentity.playList;
import com.kodnest.example.userrepository.PlaylistRepository;
import com.kodnest.example.userservice.PlaylistService;

@Service
public class PlaylistImple implements PlaylistService{
	@Autowired
	PlaylistRepository playlistrepository;

	@Override
	public void getPlaylist(playList playlist) {
		
		playList name=playlistrepository.findByName(playlist.getName());
		if(name==null) {
			playlistrepository.save(playlist);
			
		}
		else {
		System.out.println("playlist already exist");
		}
		
	}

	@Override
	public List<playList> fetchAllplaylist() {
		List<playList> allplaylist = playlistrepository.findAll();	
		return allplaylist;
	}

	

	
	


}
