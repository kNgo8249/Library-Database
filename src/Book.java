/**
 * This class represents a Book that has multiple fields relating to its name,
 * author, genre, date, and availability
 * 
 * @author Kenny
 * @version 1.0
 * 
 *          NOTE: This class contains a boolean called {@code available}. This
 *          boolean returns true if the book is available, or false if it isn't.
 * 
 */
public class Book implements Comparable<Book> {

	private String name;
	private String author;
	private String genre;
	private String date;
	private boolean available;

	/**
	 * Generates a new book with a name, author, genre, date, and availability.
	 * 
	 * @param name
	 *            Name of book
	 * @param author
	 *            Author of book
	 * @param genre
	 *            Genre of book
	 * @param date
	 *            Date of book publish
	 * @param available
	 *            Whether the book is available or not
	 */
	public Book(String name, String author, String genre, String date, boolean available) {
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.date = date;
		this.available = available;
	}

	/**
	 * Returns whether the book is available.
	 * 
	 * @return available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Sets the availability of a book.
	 * 
	 * @param available
	 *            The boolean as to whether the book is available or not
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Returns the name of a book.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the author of a book.
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Returns the genre of a book.
	 * 
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Returns the date of a book.
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Returns a formatted output of a Book with it's name, author, genre, date, and
	 * availability.
	 */
	public String toString() {
		if (available == true)
			return name + ",    " + author + ",    " + genre + ",    " + date + ",    " + "Available";
		return name + ",    " + author + ",    " + genre + ",    " + date + ",    " + "Unavailable";
	}

	/**
	 * A comparable method made to return whether {@code this} book is greater
	 * than/equal to/less than another Book {@code b}.
	 * 
	 * @param b
	 *            The book we are comparing to
	 */
	public int compareTo(Book b) {
		return this.getName().compareTo(b.getName());
	}

}
