package com.kodnest.example.userrepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.example.userentity.playList;
@Repository
public interface PlaylistRepository extends JpaRepository<playList, Integer> {

	playList findByName(String name);

	

	

	
}
