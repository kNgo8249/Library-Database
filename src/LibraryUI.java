import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class controls the graphical user interface for the project.
 * A {@code LibraryDB} object is created, and this object is used to calculate a list of books.
 * @author Kenny
 * @version 1.0
 * 
 */
public class LibraryUI extends Application {

	private LibraryDB l = new LibraryDB();
	private static CheckBox availability = new CheckBox();
	private ObservableList<Book> bookList;

	public static void main(String[] args) {
		availability.setSelected(true);
		launch();
	}


	private Scene bookScreen(Stage stage, String info, Book ba) {
		System.out.println(info);
		Image im2 = new Image("booksImage.jpg");
		ImageView i2 = new ImageView(im2);
		i2.setFitHeight(600);
		i2.setFitWidth(800);
		BorderPane rootPane = new BorderPane();
		rootPane.getChildren().add(i2);

		Button backButton = new Button("<--");

		backButton.setOnAction(e -> {
			stage.setScene(homeScreen(stage));
		});

		HBox h = new HBox();
		h.setPadding(new Insets(10));
		h.getChildren().add(backButton);

		String entryParts[] = info.split("\\,\\s\\s\\s\\s");
		Label title = new Label(entryParts[0]);
		title.setPadding(new Insets(0, 0, 40, 0));
		title.setFont(Font.font("Gill Sans", 40));
		title.setStyle("-fx-font-weight: bold");
		Label author = new Label(entryParts[1]);
		author.setFont(title.getFont());
		author.setStyle(title.getStyle());
		author.setPadding(new Insets(0, 0, 40, 0));
		Label genre = new Label(entryParts[2]);
		genre.setFont(title.getFont());
		genre.setPadding(new Insets(0, 0, 40, 0));
		genre.setStyle(title.getStyle());
		Label date = new Label(entryParts[3]);
		date.setPadding(new Insets(0, 0, 40, 0));
		date.setFont(title.getFont());
		date.setStyle(title.getStyle());

		String status = entryParts[4];

		ObservableList<String> options = FXCollections.observableArrayList("Available", "Unavailable");
		ComboBox<String> statusUpdate = new ComboBox<String>(options);
		statusUpdate.setPrefSize(150, 40);
		if (status.equalsIgnoreCase("Available")) {
			statusUpdate.setValue("Available");
		}

		else if (status.equalsIgnoreCase("Unavailable")) {
			statusUpdate.setValue("Unavailable");
		}
		statusUpdate.setStyle("-fx-font: 15px \"SanSerif\"; -fx-font-weight: bold");
		statusUpdate.setOnAction(e -> {
			System.out.println(statusUpdate.getSelectionModel().getSelectedItem());
			for (Book book : LibraryDB.getBooks()) {
				if (book.equals(ba)) {
					book.setAvailable(!book.isAvailable());
				}
			}
		});

		VBox v = new VBox();
		v.getChildren().addAll(title, author, genre, date, statusUpdate);
		v.setPadding(new Insets(20));

		rootPane.setCenter(v);
		rootPane.setTop(h);

		Scene scene = new Scene(rootPane, 800, 600);
		return scene;
	}

	private Scene homeScreen(Stage stage) {
		Image im2 = new Image("booksImage.jpg");
		ImageView i2 = new ImageView(im2);
		i2.setFitHeight(600);
		i2.setFitWidth(800);

		BorderPane rootPane = new BorderPane();
		BorderPane centerPane = new BorderPane();

		rootPane.getChildren().add(i2);

		HBox titleBox = new HBox();
		Label title = new Label("Library Tool");
		title.setFont(Font.font(randomFontGen(), 60));

		title.setTextFill(Color.web("ffffff"));
		titleBox.getChildren().addAll(title);
		titleBox.setAlignment(Pos.CENTER);

		rootPane.setTop(titleBox);

		VBox sideBox = new VBox();
		Button resetButton = new Button("Refresh");
		resetButton.setOnAction(e -> {
			stage.setScene(homeScreen(stage));
		});		

		Label search = new Label("Search");
		search.setTextFill(title.getTextFill());
		ObservableList<String> options = FXCollections.observableArrayList("Name", "Author", "Genre", "Date");
		ComboBox<String> searchOptions = new ComboBox<String>(options);
		searchOptions.setValue("Name");
		TextField searchBar = new TextField();
		searchBar.setPromptText("Search for a specific book");
		Button searchButton = new Button("Search!");

		Label available = new Label("Available:");
		available.setPadding(new Insets(10, 0, 0, 0));
		available.setTextFill(title.getTextFill());

		Label spacing1 = new Label(" ");
		spacing1.setPadding(new Insets(20, 0, 0, 0));
		Button addRemove = new Button("Add/Remove a book");
		
		addRemove.setOnAction(e -> {
			stage.setScene(addRemoveScene(stage));
		});
		
		Label spacing2 = new Label(" ");
		spacing2.setPadding(new Insets(20, 0, 0, 0));

		sideBox.getChildren().addAll(search, searchOptions, searchBar, searchButton, available, availability, spacing1,
				addRemove, spacing2, resetButton);

		rootPane.setLeft(sideBox);
		sideBox.setPadding(new Insets(50, 30, 30, 30));

		centerPane.setPadding(new Insets(30, 30, 0, 0));

		Label key = new Label("Book,\tAuthor,\tGenre,\tDate published,\tAvailablity");
		key.setStyle("-fx-font-weight: bold");
		key.setFont(Font.font("Gill Sans", 15));
		// key.setTextFill(title.getTextFill());

		centerPane.setTop(key);

		
		searchButton.setOnAction(e -> {
			if(searchOptions.getSelectionModel().getSelectedItem().equals("Name")) {
				ArrayList<Book> names = LibraryDB.searchName(searchBar.getText());
				bookList.setAll(names);
				
			} else if(searchOptions.getSelectionModel().getSelectedItem().equals("Author")) {
				ArrayList<Book> authors = LibraryDB.searchAuthor(searchBar.getText());
				bookList.setAll(authors);
			} else if(searchOptions.getSelectionModel().getSelectedItem().equals("Genre")) {
				ArrayList<Book> genres = LibraryDB.searchGenre(searchBar.getText());
				bookList.setAll(genres);
			} else if(searchOptions.getSelectionModel().getSelectedItem().equals("Date")) {
				ArrayList<Book> dates = LibraryDB.searchDate(searchBar.getText());
				bookList.setAll(dates);
			}
		});

		if (availability.isSelected()) {
			bookList = FXCollections.observableArrayList(LibraryDB.sortByAvailability(true, LibraryDB.getBooks()));

		} else {
			bookList = FXCollections.observableArrayList(LibraryDB.sortByAvailability(false, LibraryDB.getBooks()));
		}
		ListView<Book> list = new ListView<Book>();
		list.setItems(bookList);
		list.setMaxHeight(450);
		list.setMaxWidth(750);
		centerPane.setCenter(list);
		availability.setOnAction(e -> {
			stage.setScene(homeScreen(stage));
		});

		list.setOnMouseClicked(e -> {
			boolean isListEmpty = list.getSelectionModel().isEmpty();
			if (e.getClickCount() == 2 && !isListEmpty)
				stage.setScene(bookScreen(stage, list.getSelectionModel().getSelectedItem().toString(),
						list.getSelectionModel().getSelectedItem()));
		});

		rootPane.setCenter(centerPane);
		Scene scene = new Scene(rootPane, 800, 600);
		stage.setTitle("Library Tool");
		stage.setResizable(false);
		stage.show();

		return scene;

	}

	private Scene addRemoveScene(Stage stage) {
		Image im2 = new Image("booksImage.jpg");
		ImageView i2 = new ImageView(im2);
		i2.setFitHeight(600);
		i2.setFitWidth(800);
		BorderPane rootPane = new BorderPane();
		rootPane.getChildren().add(i2);
		
		
		VBox v = new VBox();
		v.setPadding(new Insets(30));
		Label add = new Label("Add");
		add.setTextFill(Color.web("ffffff"));
		add.setFont(Font.font(30));
		Label name = new Label("Name");
		name.setFont(Font.font(20));
		TextField nameText = new TextField();
		name.setPadding(new Insets(10, 0, 0, 0));
		add.setPadding(new Insets(0, 0, 10, 0));
		Label author = new Label("Author");
		author.setFont(name.getFont());
		TextField authorText = new TextField();
		author.setPadding(new Insets(10, 0, 0, 0));
		Label genre = new Label("Genre");
		genre.setFont(name.getFont());
		TextField genreText = new TextField();
		genre.setPadding(new Insets(10, 0, 0, 0));
		Label date = new Label("Date");
		date.setFont(name.getFont());
		date.setPadding(new Insets(10, 0, 0, 0));
		TextField dateText = new TextField();
		Button addButton = new Button("Add");
		addButton.setPrefSize(60, 30);
		Label space = new Label("");
		v.getChildren().addAll(add, name, nameText, author, authorText, genre, genreText, date, dateText, space, addButton);
		
		addButton.setOnAction(e -> {
			LibraryDB.getBooks().add(new Book(nameText.getText(), authorText.getText(), genreText.getText(), dateText.getText(), true));
			stage.setScene(homeScreen(stage));
		});
		
		VBox v2 = new VBox();
		v2.setPadding(new Insets(30));
		Label remove = new Label("Remove");
		remove.setTextFill(add.getTextFill());
		remove.setFont(add.getFont());
		
		remove.setPadding(new Insets(0, 0, 10, 0));
		Label remName = new Label("Name");
		remName.setFont(Font.font(20));
		name.setPadding(new Insets(10, 0, 0, 0));
		TextField remNameText = new TextField();
		Label spacing = new Label("");
		Button removeButton = new Button("Remove");
		removeButton.setPrefSize(60, 30);
		v2.getChildren().addAll(remove, remName, remNameText, spacing, removeButton);
		
		removeButton.setOnAction(e -> {
			for(int i = 0; i < LibraryDB.getBooks().size(); i++) {
				if(remNameText.getText().equalsIgnoreCase(LibraryDB.getBooks().get(i).getName())) {
					LibraryDB.getBooks().remove(i);
					stage.setScene(homeScreen(stage));
				}
			}
		});
		
		rootPane.setLeft(v);
		rootPane.setRight(v2);
		Scene scene = new Scene(rootPane, 800, 600);
		return scene;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(homeScreen(stage));
		

	}

	public static String randomFontGen() {
		return Font.getFontNames().get((int) (Math.random() * Font.getFontNames().size()));
	}

}
