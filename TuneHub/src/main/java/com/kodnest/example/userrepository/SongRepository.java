package com.kodnest.example.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.example.userentity.Song;
@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{

	String getByName(Song song);

	Song findByName(String name);

}
