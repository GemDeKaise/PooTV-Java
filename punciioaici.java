//////public class punciioaici {
//////
//////}
//////public interface Observer {
//////	void addObserver(Observer observer);
//////	void removeObserver(Observer observer);
//////	void update(Movie movie);
//////}
//////
//////public class MoviePlatform implements Subject {
//////	private List<Observer> observers;
//////
//////	public void addObserver(Observer observer) {
//////		observers.add(observer);
//////	}
//////
//////	public void removeObserver(Observer observer) {
//////		observers.remove(observer);
//////	}
//////
//////	public void notifyObservers(Movie movie) {
//////		for (Observer observer : observers) {
//////			observer.update(movie);
//////		}
//////	}
//////}
//////
//////public class User implements Observer {
//////	private String name;
//////
//////	public void update(Movie movie) {
//////		System.out.println(name + ": A new movie is available: " + movie.getTitle());
//////	}
//////}
//////
//////public class UserFactory {
//////	public User createUser(String type, String name) {
//////		if (type.equalsIgnoreCase("PREMIUM")) {
//////			return new PremiumUser(name);
//////		} else if (type.equalsIgnoreCase("STANDARD")) {
//////			return new StandardUser(name);
//////		}
//////	}
//////}
//////
//////	UserFactory factory = new UserFactory();
//////	User user = factory.createUser("PREMIUM", "John Doe");
//////]]public class UserFactory {
//////	public User createUser(String type, String name) {
//////		if (type.equalsIgnoreCase("PREMIUM")) {
//////			return new PremiumUser(name);
//////		} else if (type.equalsIgnoreCase("STANDARD")) {
//////			return new StandardUser(name);
//////		}
//////	}
//////}
//////
//////public abstract class User {
//////	protected String name;
//////
//////	public User(String name) {
//////		this.name = name;
//////	}
//////
//////	public void upgradeAccount() {
//////		// Implement code to upgrade the user's account
//////	}
//////}
//////
//////public class PremiumUser extends User {
//////	public PremiumUser(String name) {
//////		super(name);
//////	}
//////}
//////
//////public class StandardUser extends User {
//////	public StandardUser(String name) {
//////		super(name);
//////	}
//////}
//////
//////public class UserUpgrader {
//////	public void upgradeUser(User user) {
//////		// Implement code to upgrade the user's account
//////	}
//////}
//////
//////// abstract base class for pages
//////abstract class Page {
//////	protected Page parent;
//////	protected Page[] children;
//////
//////	public Page(Page parent) {
//////		this.parent = parent;
//////	}
//////
//////	// handle request to navigate to this page
//////	public abstract void handleRequest(String request);
//////}
//////
//////// concrete page class
//////class HomePage extends Page {
//////	public HomePage(Page parent) {
//////		super(parent);
//////	}
//////
//////	// handle request to navigate to this page
//////	public void handleRequest(String request) {
//////		if (request == "Home") {
//////			// navigate to this page
//////		} else {
//////			// pass request to parent page
//////			parent.handleRequest(request);
//////		}
//////	}
//////}
//////
//////// concrete page class
//////class AboutPage extends Page {
//////	public AboutPage(Page parent) {
//////		super(parent);
//////	}
//////
//////	// handle request to navigate to this page
//////	public void handleRequest(String request) {
//////		if (request == "About") {
//////			// navigate to this page
//////		} else {
//////			// pass request to parent page
//////			parent.handleRequest(request);
//////		}
//////	}
//////}
//////
//////// concrete page class
//////class ContactPage extends Page {
//////	public ContactPage(Page parent) {
//////		super(parent);
//////	}
//////
//////	// handle request to navigate to this page
//////	public void handleRequest(String request) {
//////		if (
//////
//////
//////
//////
//////	}}
//////
//////abstract class PageState {
//////	// abstract base class for page states
//////	protected PageState nextState;
//////
//////	public PageState(PageState nextState) {
//////		this.nextState = nextState;
//////	}
//////
//////	// handle request to navigate to the next page
//////	public abstract void handleRequest(String request);
//////}
//////
//////// concrete page state for the home page
//////class HomePageState extends PageState {
//////	public HomePageState(PageState nextState) {
//////		super(nextState);
//////	}
//////
//////	// handle request to navigate to the next page
//////	public void handleRequest(String request) {
//////		if (request == "Next") {
//////			// navigate to the next page
//////			nextState.handleRequest(request);
//////		}
//////	}
//////}
//////
//////// concrete page state for the about page
//////class AboutPageState extends PageState {
//////	public AboutPageState(PageState nextState) {
//////		super(nextState);
//////	}
//////
//////	// handle request to navigate to the next page
//////	public void handleRequest(String request) {
//////		if (request == "Next") {
//////			// navigate to the next page
//////			nextState.handleRequest(request);
//////		}
//////	}
//////}
////// Command interface
////public interface Command {
////	void execute();
////}
////
////// Concrete command implementations
////public class OnPageCommand implements Command {
////	private String feature;
////
////	public OnPageCommand(String feature) {
////		this.feature = feature;
////	}
////
////	@Override
////	public void execute() {
////		// Perform the "on page" action for the specified feature
////	}
////}
////
////public class ChangePageCommand implements Command {
////	private String page;
////
////	public ChangePageCommand(String page) {
////		this.page = page;
////	}
////
////	@Override
////	public void execute() {
////		// Perform the "change page" action for the specified page
////	}
////}
////
////// Invoker class
////public class InputInvoker {
////	private List<Command> commands;
////
////	public InputInvoker() {
////		commands = new ArrayList<>();
////	}
////
////	public void addCommand(Command command) {
////		commands.add(command);
////	}
////
////	public void processInput(Map<String, String> input) {
////		String type = input.get("type");
////		if ("on page".equals(type)) {
////			String feature = input.get("feature");
////			Command command = new OnPageCommand(feature);
////			command.execute();
////		} else if ("change page".equals(type)) {
////			String page = input.get("page");
////			Command command = new ChangePageCommand(page);
////			command.execute();
////		}
////	}
////}
////
////// Usage
////InputInvoker
////
////
////
//////////
////
////
////// The common interface for all commands
////public interface Command {
////	void execute();
////}
////
////// The concrete command objects that perform actions on the pages
////public class OpenPageCommand implements Command {
////	private Page page;
////
////	public OpenPageCommand(Page page) {
////		this.page = page;
////	}
////
////	@Override
////	public void execute() {
////		page.open();
////	}
////}
////
////public class ClosePageCommand implements Command {
////	private Page page;
////
////	public ClosePageCommand(Page page) {
////		this.page = page;
////	}
////
////	@Override
////	public void execute() {
////		page.close();
////	}
////}
////
////// The invoker object that executes the commands
////public class PageInvoker {
////	private Command command;
////
////	public PageInvoker(Command command) {
////		this.command = command;
////	}
////
////	public void executeCommand() {
////		command.execute();
////	}
////}
////
////// The page object that the commands operate on
////public class Page {
////	public void open() {
////		// Open the page
////	}
////
////	public void close() {
////		// Close the page
////	}
////}
////
////	// Example usage
////	Page page = new Page();
////
////	// Create a command to open the page and set it to the invoker
////	PageInvoker invoker = new PageInvoker(new OpenPageCommand(page));
////
////// Tell the invoker to execute the command, which will open the page
////invoker.executeCommand();
////
////// Create a command to close the page and set it to the invoker
////	invoker = new PageInvoker(new ClosePageCommand(page));
////
////// Tell the invoker to execute the command, which will close the page
////	invoker.executeCommand();
//public interface Command {
//	void execute();
//}
//
//public class LogInCommand implements Command {
//	public void execute() {
//		// Code for logging in to the application goes here
//	}
//}
//
//public class RegisterCommand implements Command {
//	public void execute() {
//		// Code for registering a new user goes here
//	}
//}
//
//public class Page {
//	static ArrayList<String> nextPages = new ArrayList<String>();
//	ArrayList<String> commands = new ArrayList<String>();
//
//	protected Command command;
//
//	public Page() {
//		nextPages.clear();
//		commands.clear();
//	}
//
//	public void setCommand(Command command) {
//		this.command = command;
//	}
//
//	public void executeCommand() {
//		command.execute();
//	}
//}
//
//public class HomePageNeautenticated extends Page {
//
//	public HomePageNeautenticated() {
//		super();
//		// Set up the list of available commands for this page
//		commands.add("login");
//		commands.add("register");
//	}
//}
//
//public class LogInPage extends Page {
//	static ArrayList<String> nextPages = new ArrayList<String>();
//	ArrayList<String> commands = new ArrayList<String>(Arrays.asList("login"));
//
//	public LogInPage() {
//		super();
//		// Set up the list of available commands for this page
//		commands.add("login");
//	}
//}
//
//public class RegisterPage extends Page {
//
//	public RegisterPage() {
//		super();
//		// Set up the list of available commands for this page
//		commands.add("register");
//	}
//}
//
