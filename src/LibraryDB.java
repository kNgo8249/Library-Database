import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * This class contains a database in the form of a {@code ArrayList} that stores
 * the all books.
 * 
 * @author Kenny
 * @version 1.0
 * 
 *
 */

public class LibraryDB {

	private static ArrayList<Book> books = new ArrayList<>();

	/**
	 * Returns the ArrayList which contains all of the books.
	 * 
	 * @return books
	 */
	public static ArrayList<Book> getBooks() {
		return books;
	}

	/**
	 * Constructs a new {@code LibraryDB} by taking the contents of the Books.txt
	 * file and placing them within the {@code ArrayList} by first generating their
	 * contents into a local {@code PriorityQueue} (for the purposes of sorting) and
	 * then migrating their contents into the global {@code ArrayList}.
	 */
	public LibraryDB() {
		try {
			PriorityQueue<Book> temp = new PriorityQueue<>();
			Scanner fin = new Scanner(new File("Books.txt"));
			while (fin.hasNextLine()) {
				String bookEntry = fin.nextLine();
				String[] entryParts = bookEntry.split("\\,\\s\\s\\s\\s");
				String name = entryParts[0];
				String author = entryParts[1];
				String genre = entryParts[2];
				String date = entryParts[3];
				boolean available = Boolean.parseBoolean(entryParts[4]);

				// Maybe add something to filter out duplicate books?

				temp.add(new Book(name, author, genre, date, available));

			}
			fin.close();
			while (!temp.isEmpty())
				books.add(temp.poll());
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found!");
		}
	}

	/**
	 * Returns an arrayList based on the availability of all books. Based on the
	 * boolean, either available or unavailable books will appear first. For
	 * example, if the boolean is set to true, then all available books will appear
	 * first, FOLLOWED BY unavailable books.
	 * 
	 * @param available
	 *            whether the book is available or not
	 * @param b
	 *            an ArrayList of Books
	 * @return availableBooksFirst
	 */
	public static ArrayList<Book> sortByAvailability(boolean available, ArrayList<Book> b) {
		int index = 0;
		ArrayList<Book> availableBooksFirst = new ArrayList<>();
		for (int i = books.size() - 1; i >= 0; i--)
			if (books.get(i).isAvailable() == available) {
				availableBooksFirst.add(0, books.get(i));
				index++;
			} else
				availableBooksFirst.add(index, books.get(i));

		return availableBooksFirst;

	}

	/**
	 * Returns a list of books filtered by a specific name.
	 * 
	 * @param name
	 *            Book name
	 * @return names
	 */
	public static ArrayList<Book> searchName(String name) {
		ArrayList<Book> names = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			if (name.equalsIgnoreCase(books.get(i).getName())) {
				names.add(books.get(i));
			}
		}
		return names;
	}

	/**
	 * Returns a list of books filtered by a specific author
	 * 
	 * @param author
	 *            Book author
	 * @return authors
	 */
	public static ArrayList<Book> searchAuthor(String author) {
		ArrayList<Book> authors = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			if (author.equalsIgnoreCase(books.get(i).getAuthor())) {
				authors.add(books.get(i));
			}
		}
		return authors;
	}

	/**
	 * Returns a list of books filtered by a specific genre
	 * 
	 * @param genre
	 *            Book genre
	 * @return genres
	 */
	public static ArrayList<Book> searchGenre(String genre) {
		ArrayList<Book> genres = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			if (genre.equalsIgnoreCase(books.get(i).getGenre())) {
				genres.add(books.get(i));
			}
		}
		return genres;
	}

	/**
	 * Returns a list of books filtered by a specific date
	 * 
	 * @param date
	 *            Book date
	 * @return dates
	 */
	public static ArrayList<Book> searchDate(String date) {
		ArrayList<Book> dates = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			if (date.equalsIgnoreCase(books.get(i).getDate())) {
				dates.add(books.get(i));
			}
		}
		return dates;
	}
	/*
	 * WORK IN PROGRESS public LibraryDB addOrRemoveOrStatus(Book b, String
	 * function) { if(function.equalsIgnoreCase("add")) { try { FileWriter cetan =
	 * new FileWriter("Books.txt", true); cetan.append(b.toString()); cetan.close();
	 * return new LibraryDB(); } catch (IOException e) {
	 * System.out.println("ERROR: File not found!"); } } else { try {
	 * 
	 * File inFile = new File("Books.txt"); //Construct the new file that will later
	 * be renamed to the original filename. File tempFile = new
	 * File(inFile.getAbsolutePath() + ".tmp");
	 * 
	 * BufferedReader br = new BufferedReader(new FileReader("Books.txt"));
	 * BufferedWriter pw = new BufferedWriter(new FileWriter(tempFile));
	 * 
	 * String line = null;
	 * 
	 * //Read from the original file and write to the new //unless content matches
	 * data to be removed. boolean t = false; while ((line = br.readLine()) != null)
	 * {
	 * 
	 * if (!line.equals(b.toString())) {
	 * 
	 * pw.write(line); pw.newLine(); } else if (function.equalsIgnoreCase("toggle"))
	 * { b.setAvailable(!b.isAvailable()); pw.write(b.toString()); pw.newLine(); t =
	 * true; } else { t = true; }
	 * 
	 * } pw.close(); br.close(); if (inFile.delete()) { // Rename the output file to
	 * the input file tempFile.renameTo(inFile);
	 * 
	 * } if(!t) {System.out.println("ERROR: Book not found!");} return new
	 * LibraryDB(); } catch (FileNotFoundException ex) { ex.printStackTrace(); }
	 * catch (IOException ex) { ex.printStackTrace(); }
	 * 
	 * }
	 * 
	 * return this; }
	 */

}
