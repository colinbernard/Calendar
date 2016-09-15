package bernard.colin.calendar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Employee {
	private String firstname, lastname;
	private int id;
	private String filename;
	private String path;
	
	public Employee (String firstname, String lastname, int id) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		
		filename = firstname + "_" + id + ".txt"; // create a unique filename
		// init path where employee file is stored
		path = "C:" + File.separator + "users" + File.separator + "Colin"
				+ File.separator + "Desktop" + File.separator + "data" + File.separator
				+ filename;
		File f = new File(path);
		if(!f.exists()) { // if the file does not exist, create it
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Error creating employee file.");
				e.printStackTrace();
			}
		}
	}
	
	// add an event to employee file
	public void addEvent(int month, int day, int year, double start, double end) {
		String text = String.format("%d/%d/%d %.2f %.2f\n", month, day, year, start, end);
		try {
			// append event to file
			Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Error writing to employee file.\n");
			e.printStackTrace();
		}
	}
	
	public void removeEvent(int month, int day, int year) {
		
	}
	
	/*
	 * GETTERS AND SETTERS 
	 */
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public int getID() {
		return id;
	}
	
	public String getFilename() {
		return filename;
	}
}
