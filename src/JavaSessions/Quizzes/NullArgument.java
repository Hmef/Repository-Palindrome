package JavaSessions.Quizzes;

public class NullArgument {

	public static void main(String[] args) {
		
		//test(0);
		
		test(null);  // quelle méthode va etre appelée ??
		
	}
	
	public static void test(Object o) {
		
		System.out.println("Object argument");
	}
	
	public static void test(String s) {
		
		System.out.println("String argument");
		
	}
	
	// if we try overload with StringBuilder 
	// we can't use the StringBuffer ==> because same thing we can do'it with String 
	/*
	public static void test(StringBuiler s) {
		System.out.println("StringBuilder argument");
	}
	
	public static void test(StringBuffer s){

	System.out.println("StringBuffer argument");
	}
	*/
	
	// Object's default value is Null  and also  String's default value is Null
	
	//ref : Tricky Interview Question : Pass null argument with method overloading of String and Object types (Naveen AutomationLabs)
	
}
