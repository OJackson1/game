package com.qa.adventuregame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class AdventureGame {
	
	Scanner scan = new Scanner(System.in);
	
	public void gameSystem() throws IOException {
		
	Scanner user_input = new Scanner(System.in);
	Random rando = new Random();
	
	String[] bosses = {"Nick", "Shafeeq", "Vinesh", "Adam", "Piers"};
	int maxBossHplvl1 = 30;
	int maxBossHplvl2 = 40;
	int maxBossHplvl3 = 50;
	int maxBossHplvl4 = 60;
	
	int bossAttacklvl1 = 10;
	int bossAttacklvl2 = 20;
	int bossAttacklvl3 = 30;
	int bossAttacklvl4 = 40;
	
	//user
	int hp = 100;
	int attack = 60;
	
	boolean running = true;
	
	System.out.println("Enter your Name if you dare......");
	
	String name = scan.nextLine();
	
	System.out.println("Hello " + name + "\n" + "WELCOME TO THE SWAMP!");
	
	System.out.println("Please enter your username: ");
	
	String userName = scan.nextLine();
	
	BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	g.setFont(new Font("Dialog", Font.PLAIN, 24));
	Graphics2D graphics = (Graphics2D) g;
	graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	graphics.drawString(userName, 6, 24);
	ImageIO.write(image, "png", new File("text.png"));

	for (int y = 0; y < 32; y++) {
	    StringBuilder sb = new StringBuilder();
	    for (int x = 0; x < 144; x++)
	        sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
	    if (sb.toString().trim().isEmpty()) continue;
	    System.out.println(sb);
	}
	
	System.out.println("You are about to take a perilous journey through the forgotten kingdom\nYou will cross many foe's so you must be careful.\nYou must defeat the Bosses that you meet and reach the end before it is too late!");
				
	
	ADVENTUREGAME:
		while(running) {
			System.out.println("------------------------------------------");
			
			int bossHealth = rando.nextInt(maxBossHplvl1);
			String boss = bosses[rando.nextInt(bosses.length)];
			System.out.println("\t# " + boss + " is here to face you! #\n");
			
			while(bossHealth > 0) { 
				System.out.println("\t" + userName + "'s health: " + hp);
				System.out.println("\t" + boss + "'s health:" + bossHealth);
				System.out.println("\t1. Attack");
				System.out.println("\t2. Go to the pub");
				
				String in = user_input.nextLine();
				if (in.equals("1")) {
					int dmgDealt = rando.nextInt(attack);
					int dmgTaken = rando.nextInt(bossAttacklvl1);
					
					bossHealth -= dmgDealt;
					hp -= dmgTaken;
					
					System.out.println("\t> You attacked " + boss + " and inflicted " +  dmgDealt + " damage");
					System.out.println("\t> In a retaliation " + boss + " took " + dmgTaken + " from you ");
					
					if(hp < 1 ) {
						System.out.println("\t"+userName + " has been defeated by " + boss);
					}
					
				} 
				else if(in.equals("2")) {
					System.out.println("\tYou ran to get away from " + boss + " to get a yummy ale. Good MAN!");
					System.out.println("SO LONG!");
					break;
					
				} else {
					System.out.println("\tMAKE SOME SENSE!");
				}
			}
			
 			if(hp < 1) {
 				System.out.println("\tYou have been forced to retire");
 				break;
 			}
 			
 			System.out.println("------------------------------------------");
 			System.out.println(" # " + boss + "was beaten!! #");
 			System.out.println(" # You have " + hp + " health left #");	
 			
 			System.out.println("WHAT WOULD YOU LIKE TO DO NOW?");
 			System.out.println("1. ONWARDS!");
 			System.out.println("2. GET ME OUT THIS SWAMP!");
 			
 			String input = user_input.nextLine();
 			
 			while (!input.equals("1") && !input.equals("2") ) {
 				System.out.println("MAKE SOME SENSE!");
 				input = user_input.nextLine();
 			}
 			
 			if(input.equals("1")) {
 				System.out.println(userName + " HEADS DEEPING INTO THE SWAMP");
 			} else if(input.equals("2")) {
 				System.out.println(userName + " HAS BEEN AIRLIFTED OUT THE SWAMP");
 				break;
 			}
		}
	
	System.out.println("------------------------------------------");
	
	BufferedImage image2 = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
	Graphics g2 = image.getGraphics();
	g.setFont(new Font("Dialog", Font.PLAIN, 24));
	Graphics2D graphics2 = (Graphics2D) g;
	graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	graphics.drawString("GOODBYE", 6, 24);
	ImageIO.write(image, "png", new File("text.png"));

	for (int y = 0; y < 32; y++) {
	    StringBuilder sb = new StringBuilder();
	    for (int x = 0; x < 144; x++)
	        sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
	    if (sb.toString().trim().isEmpty()) continue;
	    System.out.println(sb);
	}

	}
}
