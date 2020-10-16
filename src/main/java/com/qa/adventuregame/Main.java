package com.qa.adventuregame;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) throws IOException {
		AdventureGame adventureGame = new AdventureGame();
		adventureGame.gameSystem();
		LOGGER.info("SO LONG!");
	}

}
