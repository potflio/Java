package Student;


import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student_Insert in = new Student_Insert();
		Student_View vi = new Student_View();
		Student_Update up = new Student_Update();
		Student_Delete de = new Student_Delete();
		
		
		
		System.out.println("Welcome to Moni Schools");
			while(true) {
				System.out.println("1.Student Form");
				System.out.println("2.Update Info");
				System.out.println("3.View Info");
				System.out.println("4.Delete");
				System.out.print("Choose :");
				int option = scan.nextInt();
				if(option == 1) {
					in.Insert();
				}
				else if(option == 2) {
					up.change();
				}
				else if(option == 3) {
					vi.view();
				}
				else if(option == 4) {
					de.del();
				}
				else {
					System.out.println("Not Found");
				}
				
			}
			
	}
}
