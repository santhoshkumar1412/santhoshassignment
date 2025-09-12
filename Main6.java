package santhosh;
class User {
	    String name;

	    User(String name) {
	        this.name = name;
	    }
	    public final void displayRole() {
	        System.out.println(name + " is a User");
	    }
	}
	class Admin extends User {
	    Admin(String name) {
	        super(name);
	    }
	    /*public void displayRole() {
	        System.out.println(name + " is an Admin");
	    }*/
	}
	public class Main6 {
	    public static void main(String[] args) {
	        Admin admin = new Admin("Santhosh");
	        admin.displayRole(); 
	    }
	}