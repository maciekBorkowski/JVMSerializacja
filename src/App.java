import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class App {
	
	String FILE_NAME = "serialized.object";
		
	public void serializeObject(Object object) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
		out.writeObject(object);
		out.close();
	}
	
	public Object deserializeObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
		
		Object result = in.readObject();
		in.close();
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		App a = new App();
		
		Login l = new Login();
		l.setPassword("test");
		l.setUsername("test123123");
		
		Login l2 = new Login();
		l2.setPassword("asdasdasd");
		l2.setUsername("asda12312");
		
		Student s1 = new Student();
		s1.setFirstName("Maciej");
		s1.setLastName("Borkowski");
		s1.setStudentBookId("205297");
		s1.setLogin(l);
		
		Student s2 = new Student();
		s2.setFirstName("Maciej");
		s2.setLastName("Krzykowski");
		s2.setStudentBookId("65498749");
		s2.setLogin(l2);
		
		
		List<Student> attendeesList = new ArrayList<>();
		attendeesList.add(s1);
		attendeesList.add(s2);
		Classes c = new Classes();
		c.setAttemdeesList(attendeesList);
		
		a.serializeObject(c);
		
		Classes c2 = (Classes) a.deserializeObject();
		System.out.println(c2.toString());
		
		
	}

}
