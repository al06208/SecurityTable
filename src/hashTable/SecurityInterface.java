package hashTable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
public class SecurityInterface {
	private static SecurityTable sec = new SecurityTable();
	
	public static void main(String[] args) {
		if(args.length!=1) {
			//Display a message telling the user to use one argument and close
			System.out.println("Please run the security interface with exactly one argument: a text file.");
		}
		else {
			try {
				boolean leave = false;
				initialize(args[0]);
				Scanner op = new Scanner(System.in);
				System.out.println("Successfully initialized the Security Table.");
				System.out.println("Please enter a command. HELP lists available commands, EXIT at any time closes the program.");
				String input = op.nextLine().toUpperCase();
				do {
					switch (input){
					case "CHECK":
						System.out.println("Check to see if an employee is in the database.");
						System.out.println("Please enter their full name:");
						String a = op.nextLine().toUpperCase();
						if(a.equals("EXIT")) {
							leave = true;
							break;
						}
						else {
							if(sec.contains(a)) {
								System.out.println(a.toUpperCase() + " was found in the database.");
							}
							else {
								System.out.println(a.toUpperCase() + " was NOT found in the database.");
							}
						}
						break;
					case "STATUS":
						System.out.println("Checks an employee's access status.");
						System.out.println("Please enter their full name:");
						String b = op.nextLine().toUpperCase();
						if(b.equals("EXIT")) {
							leave = true;
							break;
						}
						else {
							if(sec.hasAccess(b)) {
								System.out.println(b + " has access to the facility.");
							}
							else {
								System.out.println(b + " does NOT have access to the facility.");
							}
						}
						
						break;
					case "HELP":
						System.out.println("CHECK");
						System.out.println("Determines wether or not an employee is in the access database.");
						System.out.println("STATUS");
						System.out.println("Determines whether or not an employee has full access to the facility.");
						System.out.println("HELP");
						System.out.println("Lists all available commands.");
						System.out.println("EXIT");
						System.out.println("Exits the program. Can be entered at any time, even after other commands.");
						break;
					case "EXIT":
						leave=true;
						break;
					default:
						System.out.println("Unrecognized command.");
					}
					if(!leave)
						input = op.nextLine().toUpperCase();
				}while(!leave);
				op.close();
				System.out.println("Have a nice day.");
				System.exit(0);
			} catch (IOException e) {
				System.out.println("Encountered an error while reading the file!");
				System.out.println(e.toString());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			
		}

	}
	
	public static void initialize(String location) throws IOException {
		FileReader in = new FileReader(location);
		BufferedReader thru = new BufferedReader(in);
		String line;
		LinkedList<Employee> list = new LinkedList<Employee>();
		while ((line = thru.readLine())!=null) {
			String[] stuff = line.split(";");
			list.add(new Employee(stuff[0],Boolean.parseBoolean(stuff[1])));
		}
		sec.initialize(list);
		thru.close();
	}

}
