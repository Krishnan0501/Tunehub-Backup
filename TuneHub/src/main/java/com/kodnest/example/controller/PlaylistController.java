package com.kodnest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.kodnest.example.userentity.Song;
import com.kodnest.example.userentity.playList;
import com.kodnest.example.userservice.PlaylistService;
import com.kodnest.example.userservice.SongService;



@Controller
public class PlaylistController {
	@Autowired
	PlaylistService playlistservice;
	@Autowired
	SongService songservice;
	@GetMapping(value="/createplaylists")
	public String createPlaylist(Model model1) {
		List<Song> songlist=songservice.fetchAllSongs();
		model1.addAttribute("songs",songlist);
	
		return "createplaylist";
	}
	@PostMapping(value="addsongplaylist")
	public String addsongplaylist(@ModelAttribute playList playlist) {
		 playlistservice.getPlaylist(playlist);
		 
		 List<Song> songs = playlist.getSongs();
		 
		 for(Song song:songs) {
			 song.getPlaylists().add(playlist);
			 songservice.updatesong(song);
		 }
		
		return "adminhome";			
	}
	@GetMapping(value="/viewplaylist")
	public String viewplaylist(Model model) {
		List<playList> allplaylist = playlistservice.fetchAllplaylist();
				model.addAttribute("playlists", allplaylist);
		return "viewplaylist";
	}
	 
		
	

}

