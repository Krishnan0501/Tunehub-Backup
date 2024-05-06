package com.kodnest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.example.userentity.Song;
import com.kodnest.example.userservice.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songservice;
	@PostMapping(value="/addsong")
	public String getSongDetail(@ModelAttribute Song song) {
		boolean existsong=songservice.songExist(song);
		if(existsong==false) {
			System.out.println("Song Added");
		songservice.addSongDetails(song);
		}else {
			System.out.println("Song Already Present");
		}
		return "adminhome";
	}
	
	@GetMapping(value="/playsongs")
	public String playSong(Model model) {
		boolean premium=true;
		if(premium) {
		List<Song> songlist=songservice.fetchAllSongs();
		model.addAttribute("songs", songlist);
		System.out.println(songlist);
		return "viewsongs";
		}
		else {
			System.out.println("Subscribe Please");
			return "pay";
		}
	}@GetMapping(value="/viewsongs")
	public String viewSong(Model model) {
	
		List<Song> songlist=songservice.fetchAllSongs();
		model.addAttribute("songs", songlist);
		System.out.println(songlist);
		return "viewsongs";
		
	}
	
	
	

}
