package com.Ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaylistService {

	@Autowired
	private SongService songService;
	
	public PlaylistService() {
		System.out.println("playlist initialize");
	}
	public void showDependecy() {
		System.out.println("song service dependency active");
	}
	
}
