package hashTable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class SecurityInterface {
	private static SecurityTable sec = new SecurityTable();
	
	public static void main(String[] args) {
		if(args.length!=1) {
			//Display a message telling the user to use one argument and close
		}
		else {
			try {
				initialize(args[0]);
			} catch (IOException e) {
				//Display a message indicating an IOException
			}
			//PUT ALL THE GUI STUFF HERE 'CAUSE NOW WE HAVE A WORKING TABLE
		}

	}
	
	public static void initialize(String location) throws IOException {
		FileReader in = new FileReader(location);
		BufferedReader thru = new BufferedReader(in);
		String line;
		sec = new SecurityTable();
		while ((line = thru.readLine())!=null) {
			String[] stuff = line.split(";");
			sec.addEmployee(new Employee(stuff[0],Boolean.parseBoolean(stuff[1])));
		}
		thru.close();
	}

}
