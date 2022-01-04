package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println("start");
			int i = 1/0;
			System.out.println("finish");
			
		} catch (Exception e) {
			
			System.out.println("catch block");
			System.out.println(e.getMessage());
	
		}

	}

}
