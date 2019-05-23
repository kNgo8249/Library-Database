import java.util.Scanner;

public class TestUI {

	
	// This class implements a text UI and many features in the actual GUI will be different due to text based limitations.
	public static void main(String[] args) {
		/*LibraryDB l = new LibraryDB();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("-----------------------------------------------\nWelcome to the Library! Please select something to search for:\n");
			System.out.println(
					"0 List all books\n1 Search name\n2 Search author\n3 Search genre\n4 Search date\n5 Search by availability\n6 Add/Remove/Change status of book\n7 Stop");

			int x = input.nextInt();
			switch (x) {
			case 0:
				System.out.println(LibraryDB.getBooks());
				input.nextLine();
				input.nextLine();
				break;
			case 1:
				input.nextLine();
				System.out.println("Enter in a name:");
				String nameInput = input.nextLine();
				if (LibraryDB.searchName(nameInput).isEmpty()) {
					System.out.println("ERROR: Name not found!");
				} else {
					System.out.println(LibraryDB.searchName(nameInput));
				}
				System.out.println("\n\n");
				input.nextLine();
				break;
			case 2:
				input.nextLine();
				System.out.println("Enter in an author:");
				String authInput = input.nextLine();
				if (LibraryDB.searchAuthor(authInput).isEmpty()) {
					System.out.println("ERROR: Author not found!");
				} else {
					System.out.println(LibraryDB.searchAuthor(authInput));
				}
				System.out.println("\n\n");
				input.nextLine();
				break;
			case 3:
				input.nextLine();
				System.out.println("Enter in a genre:");
				String genreInput = input.nextLine();
				if (LibraryDB.searchGenre(genreInput).isEmpty()) {
					System.out.println("ERROR: Genre not found!");
				} else {
					System.out.println(LibraryDB.searchGenre(genreInput));
				}
				System.out.println("\n\n");
				input.nextLine();
				break;
			case 4:
				input.nextLine();
				System.out.println("Enter in a date:");
				String dateInput = input.nextLine();
				if (LibraryDB.searchDate(dateInput).isEmpty()) {
					System.out.println("ERROR: Date not found!");
				} else {
					System.out.println(LibraryDB.searchDate(dateInput));
				}
				System.out.println("\n\n");
				input.nextLine();
				break;
			case 5:
				input.nextLine();
				System.out.println("Available (1) or Unavailable (0)?");
				String availability = input.nextLine();
				if(availability.equalsIgnoreCase("Available") || availability.equals("1"))	System.out.println(LibraryDB.sortByAvailability(true));
				else if(availability.equalsIgnoreCase("Unavailable") || availability.equals("0"))	System.out.println(LibraryDB.sortByAvailability(false));
				else	System.out.println("ERROR: You need to specify availability!");	// In the GUI this will be different
				input.nextLine();
				break;
			case 6:
			break;
			case 7:
				System.out.println("Program stopping...");
				return;
			default:
				System.out.println("ERROR: You need to select a type to search for!");
				input.nextLine();
				input.nextLine();
				break;

			}
		}
*/
	}
	
	


}
