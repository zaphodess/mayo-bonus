package de.telekom.mayo.bonus.service;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {

	try
	{
		File myObj = new File("filename.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();
	}catch(
	FileNotFoundException e)
	{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	image1 = Image.builder().pictureName("Bild1").product(product1).build();