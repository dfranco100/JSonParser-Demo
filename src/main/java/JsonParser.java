import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

import java.util.Iterator;

public class JsonParser {
	List<Student> studentList = new ArrayList();
	public static List<Student> parseJSOn(String url) throws ParseException {
        List<Student> studentList = new ArrayList();
        Client client = Client.create();
        WebResource webResource = client.resource(url);

        ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        if (clientResponse.getStatus() != 200) {
            throw new RuntimeException("Failed"+ clientResponse.toString());
        }

        JSONArray jsonArray = (JSONArray) new  JSONParser().parse(clientResponse.getEntity(String.class));

        Iterator<Object> it = jsonArray.iterator();

        String firstName;
        String gender;
        String email;
        double gpa;
        while (it.hasNext()){
            JSONObject jsonObject = (JSONObject)it.next();
            firstName = (String)jsonObject.get("first_name");
            gender = (String)jsonObject.get("gender");
            email = (String)jsonObject.get("email");
            gpa = Double.parseDouble((String)jsonObject.get("gpa"));
            studentList.add(new Student(firstName,gender,email,gpa));
        }

        return studentList;
        
    }
	
	public void searchName(String first_name) {
		for(Student student: studentList) {
			if(student.getFirst_name().equals(first_name))
				System.out.println("found " + first_name);
		}
	}
		
	public void searchGender(String gender) {
		for(Student student: studentList) {
			if(student.getGender().equals(gender))
				System.out.println("found " + gender);
			}		
	}
	public static void main(String[] args) throws ParseException {

        List<Student> studentList = parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student.json");
        for ( Student student: studentList){
            System.out.println(student.toString());
        }
      
	} 
	
}
