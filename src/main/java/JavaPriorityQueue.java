
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Student{
   private int token;
   private String fname;
   private double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
}

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		Double student1Cgpa = student1.getCgpa();
		Double student2Cgpa = student2.getCgpa();
		int cgpaCompare = student1Cgpa.compareTo(student2Cgpa);
		if (cgpaCompare != 0) {
			return cgpaCompare == -1 ? 1 : -1;
		}
		int fNameCompare = student1.getFname().compareTo(student2.getFname());
		if (fNameCompare != 0) {
			return fNameCompare;
		}
		if (student1.getToken() > student2.getToken()) {
			return 1;
		} else if (student1.getToken() < student2.getToken()) {
			return -1;
		}
		return 0;
	}
	
}

public class JavaPriorityQueue {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int totalEvents = Integer.parseInt(in.nextLine());
      Queue<Student> queue = new PriorityQueue<>(totalEvents, new StudentComparator());
      while(totalEvents>0){
    	  String line = in.nextLine();
    	  if(line.startsWith("ENTER")){
    		  String regexp = "(\\w*)(\\s)(\\w*)(\\s)(\\d+\\.\\d+)(\\s)(\\d+)";
    		  Pattern pattern = Pattern.compile(regexp);
    		  Matcher matcher = pattern.matcher(line);
    		  if (matcher.find()) {
    			  String name = matcher.group(3);
    			  double cgpa = Double.valueOf(matcher.group(5));
    			  int token = Integer.valueOf(matcher.group(7));
    			  Student student = new Student(token, name, cgpa);
    			  queue.add(student);
    		  } 
    	  } else if(line.startsWith("SERVED")) {
    		  Student s = queue.poll();
    		  System.out.println("Poling student: "+ s.getFname());
    	  }

         totalEvents--;
      }
      in.close();
      if(queue.isEmpty()){
    	  System.out.println("EMPTY");
      } else {
    	  while(!queue.isEmpty()){
    		  Student student = queue.poll();
    		  System.out.println(student.getFname());
    	  }
      }
      
    }
}