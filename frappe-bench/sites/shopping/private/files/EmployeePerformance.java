import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.ArrayList; 
import java.util.Scanner;

public class EmployeePerformance{
    public static void main(String[] args) throws RserveException, REXPMismatchException, FileNotFoundException, IOException {
        RConnection c = new RConnection("localhost", 6311);
		BasicDBObject SearchDocument;
		String Choice;
		String a1,a2,a3,b1,b2,b3,c1,c2,c3;
		Scanner user_input = new Scanner( System.in );
        if(c.isConnected()) {
            System.out.println("Connected to RServe.");
         		
			try{   
		 // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         // Now connect to your databases
         DB db = mongoClient.getDB( "Company" );
		 System.out.println("Connect to database successfully");
         DBCollection coll = db.getCollection("Performance");
         System.out.println("Collection Created/Switched successfully");
		 
		 //Get the record of Employee1
		  SearchDocument = new BasicDBObject(); 
			 SearchDocument.append("Name", "Emp1"); 
		 DBObject doc;
		 
		 DBCursor cursor = coll.find(SearchDocument);
         int i=0;
		 String str="";
		 int[] Emp1Attendance=new int[26];
		 int[] Emp1PassedProduct=new int[26];
		 int[] Emp1PortionCovered=new int[26];
		 int[] Days=new int[26];
		 while (cursor.hasNext()) { 
            doc = cursor.next();
			str = (doc.get("Attendance")).toString();
			Emp1Attendance[i]=Integer.parseInt(str);
			
			str = (doc.get("Passed Products")).toString();
			Emp1PassedProduct[i]=Integer.parseInt(str);
			
			str = (doc.get("Portion Covered")).toString();
			Emp1PortionCovered[i]=Integer.parseInt(str);
			
			Days[i]=i;
			 //System.out.println(Emp1Attendance[i]);
           i++;
		}
		 
		  c.assign("x",Emp1Attendance);
		
		  c.eval("a1 <- (sum(x)/26)*100");
		  
		  a1 = c.eval("a1").asString();
		  
		  c.assign("x",Emp1PassedProduct);
		 
		  c.eval("a2 <- (sum(x)/26)*100");
		  
		  a2 = c.eval("a2").asString();
		  
		   c.assign("x",Emp1PortionCovered);
		  
		  c.eval("a3 <- (sum(x)/26)*100");
		  
		  a3 = c.eval("a3").asString();
		
		//Get the record of Employee2
		  SearchDocument = new BasicDBObject(); 
			 SearchDocument.append("Name", "Emp2"); 
		 
		 
		  cursor = coll.find(SearchDocument);
          i=0;
		  str="";
		 int[] Emp2Attendance=new int[26];
		 int[] Emp2PassedProduct=new int[26];
		 int[] Emp2PortionCovered=new int[26];
		 while (cursor.hasNext()) { 
            doc = cursor.next();
			str = (doc.get("Attendance")).toString();
			Emp2Attendance[i]=Integer.parseInt(str);
			
			str = (doc.get("Passed Products")).toString();
			Emp2PassedProduct[i]=Integer.parseInt(str);
			
			str = (doc.get("Portion Covered")).toString();
			Emp2PortionCovered[i]=Integer.parseInt(str);
			
			 //System.out.println(Emp1Attendance[i]);
           i++;
		}
		 
		  c.assign("y",Emp2Attendance);
		 
		  c.eval("b1 <- (sum(y)/26)*100");
		  
		  b1 = c.eval("b1").asString();
		  
		  c.assign("y",Emp1PassedProduct);
		 
		  c.eval("b2 <- (sum(y)/26)*100");
		  
		   b2 = c.eval("b2").asString();
		   
		  c.assign("y",Emp1PortionCovered);
		  
		  c.eval("b3 <- (sum(y)/26)*100");
		
		 b3 = c.eval("b3").asString();
				//Get the record of Employee3
		  SearchDocument = new BasicDBObject(); 
			 SearchDocument.append("Name", "Emp3"); 
		
		 
		  cursor = coll.find(SearchDocument);
          i=0;
		  str="";
		 int[] Emp3Attendance=new int[26];
		 int[] Emp3PassedProduct=new int[26];
		 int[] Emp3PortionCovered=new int[26];
		 while (cursor.hasNext()) { 
            doc = cursor.next();
			str = (doc.get("Attendance")).toString();
			Emp3Attendance[i]=Integer.parseInt(str);
			
			str = (doc.get("Passed Products")).toString();
			Emp3PassedProduct[i]=Integer.parseInt(str);
			
			str = (doc.get("Portion Covered")).toString();
			Emp3PortionCovered[i]=Integer.parseInt(str);
            i++;
		}
		 
		  c.assign("z",Emp3Attendance);
		  
		  c.eval("c1 <- (sum(z)/26)*100");
		  
		  c1 = c.eval("c1").asString();
		  
		  c.assign("z",Emp3PassedProduct);
		  
		  c.eval("c2 <- (sum(z)/26)*100");
		  
		   c2 = c.eval("c2").asString();
		  
		  c.assign("z",Emp3PortionCovered);
		  
		  c.eval("c3 <- (sum(z)/26)*100");
		  
		   c3 = c.eval("c3").asString();
		   
		  c.eval("attendance_analysis_vector <- c(a1,b1,c1)");
		  c.eval("passed_products_analysis_vector <- c(a2,b2,c2)");
		  c.eval("portion_covered_analysis_vector <- c(a3,b3,c3)");
		  c.eval("performance_analysis_vector <- ((attendance_analysis_vector + passed_products_analysis_vector + portion_covered_analysis_vector)/3)");
		  
		 System.out.println("--------------MENU--------------");
		 System.out.println("1. Attendance Analysis");
		 System.out.println("2. Passed Product Analysis");
		 System.out.println("3. Portion Covered Analysis");
		 System.out.println("4. Total Performance Analysis");
		 System.out.println("5. Quit\n");
		 Choice = user_input.next();
		 switch(Choice)
		 {
		    case "1":
			{
			System.out.println("Employee1 -> "+a1);
		    System.out.println("Employee2 -> "+a2);
			System.out.println("Employee3 -> "+a3);
			}
			
			break;
			
			case "2":
			{
			System.out.println("Employee1 -> "+b1);
		    System.out.println("Employee2 -> "+b2);
			System.out.println("Employee3 -> "+b3);
			}
			
			break;
			
			case "3":
			{
			System.out.println("Employee1 -> "+c1);
		    System.out.println("Employee2 -> "+c2);
			System.out.println("Employee3 -> "+c3);
			}
			
			break;
			
			case "4":
			{
			c.eval("plot(performance_analysis_vector,type='l', main='Employee Perfromance Analysis',lwd=3,col='Green')");
			}
			
			break;
			}
		 
		  
      }catch(Exception e){
	     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       
		}
		c.close();
        System.out.println("Session Closed");
    }

}
public static String TrimEnd(String input, String charsToTrim)
	{
		return input.replaceAll("[" + charsToTrim + "]+$", "");		
	}
}