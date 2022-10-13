import java.lang.*;
import java.util.Scanner;

class LoadingScreen extends Thread {
	public void run() {
		System.out.println("Loading Main Menu.");
		for (int i = 0; i < 10; i++) {
			System.out.print('.');
			try {

				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		new Bank_mangement();
	}
}

class Account {

	public int ID;
	public String name;
	public double deposit;
	Scanner input_data = new Scanner(System.in);

	public void show_data() {
		try {
			if (name.equals("null")) {

			} else {
				System.out.println("..........Account Details............");
				System.out.println("Name of account Holder is " + name);
				System.out.println("current Balance " + deposit);
				System.out.println("id of " + name + " is " + ID);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(
					" ............NO ACCOUNT  REGISTRED YET .............\n Please press 1 to Make a New Account  ");
		}

	}

	public void Add_balance() {

		double add_amout;
		System.out.println("Enetr amount Do you want to Add in your Account");
		add_amout = input_data.nextDouble();
		deposit += add_amout;
		System.out.println("now your current balace is " + deposit);
		System.out.println("........balnce Added.....");

	}

	public void WithDraw() {
		double withdtraw;
		System.out.println("Enetr amount Do you want to Withdrwa");
		withdtraw = input_data.nextInt();

		if (deposit > 0 && withdtraw <= deposit) {
			System.out.println("now your current balace is " + deposit);
			System.out.println(".....balance withdrwan..........");
			deposit -= withdtraw;

		} else {
			// System.out.println("now your current balace is " + this.deposit);
			System.out.println("SORRY!!!!! there is no too much money in your Account  \n first Recharege  ");
		}

	}
}

class Admin extends Account {

	private String admin;
	private String passward;
	Scanner singup_input = new Scanner(System.in);

	private void create_account() {

		System.out.println(" Enter name ");

		name = singup_input.nextLine();
		System.out.println("  enter ID  of coustemer ");
		this.ID = input_data.nextInt();
		System.out.println(" enter amount To depossit  ");
		this.deposit = input_data.nextDouble();
		System.out.println(" .......Account created ......");

	}

	public void Sign_Up() {
		int admin_option;

		System.out.println("Enter Your Name ");

		admin = input_data.nextLine();
		System.out.println("enter Admin Passward ");
		passward = input_data.nextLine();

		if (admin.equals("Qurban") && passward.equals("admin")) {

			System.out.println("\n====================================================================");
			System.out.println("\n\t\t\t\t | Admin MAIN MENU|  \n\n");
			System.out.println(" \t\t\t\t*****WELCOME ADMIN******\n");
			System.out.println("=====================================================================");
			do {
				System.out.println("\t\t\t\tWelcome Admin");
				System.out.println("\t\t\t\t Choose Admin's Option ");
				System.out.println("\t\t\t\t 01: Make New  Account ");
				System.out.println("\t\t\t\t 02: Show Account");
				System.out.println("\t\t\t\t 03 EXIT");
				admin_option = input_data.nextInt();
				switch (admin_option) {
					case 1:
						create_account();
						break;
					case 2:

						show_data();
						break;
					case 3:
						System.out.println("thanks Admin ");

					default:

				}
			} while (admin_option != 3);

		}

		else {
			System.out.println("Incoorect Credetionals Admin Name or Passwaard :");

		}

	}

}

class User extends Account {
	// Account ac = new Account ();
	void User_Options() {
		int num;


		Scanner input_data = new Scanner(System.in);
		
			do {


				System.out.println("\n====================================================================");
				System.out.println("\n\t\t\t\t     | USER MAIN MENU|");
				System.out.println("\t\t\t\t***** GLAD TO SEE YOU HERE *****");
				System.out.println("=====================================================================");
				// System.out.println("\n------------------------------------");
				System.out.println("\n ----------------------------------------------------------------------");
				System.out.println(" \t\t\t\t01. DEPOSIT AMOUNT");
				System.out.println(" \t\t\t\t02. WITHDRAW AMOUNT");
				System.out.println(" \t\t\t\t03. tSHOW ACCOUNT DETAILS");
				System.out.println(" \t\t\t\t04. EXIT");
				System.out.println("\n----------------------------------------------------------------------");
				System.out.println(" \t\t\t\tSelect Your Option (1-4) ");

				num = input_data.nextInt();
				input_data.close();
				switch (num) {

					case 1:
						Add_balance();
						break;
					case 2:
						WithDraw();
						break;
					case 3:
						show_data();
						break;
					case 4:
						System.out.println("\t\t\t*****Thanks for joining us*****");
					break ;
					default:
						System.out.println("incorrect choice please try Again");

				}


			} 
			while (num != 4);
	
	}
	

}

 public class Bank_mangement {
	public Bank_mangement() {

		// Account a1 = new Account();
		Admin a = new Admin();
		User u1 = new User();
		Scanner input = new Scanner(System.in);
		int choice;

	
			do {

				// System.out.println("Press enter to continue");

				System.out.println("\n====================================================================");
				System.out.println("\n\t\t\t\t |MAIN MENU|\n");
				System.out.println("=====================================================================");
				System.out.println(" \t\t\t\t  Choose Any One Option ");
				System.out.println(" \t\t\t\t  01 Admin ");
				System.out.println(" \t\t\t\t  02 User ");
				System.out.println(" \t\t\t\t  03 Exit ");
				choice = input.nextInt();

				switch (choice) {
					case 1:
						System.out.println("Enter Admin Creditonls ");
						a.Sign_Up();
						break;
					case 2:

						u1.User_Options();
						break;
					case 3:
						System.out.println("Thanks For Joining Us");
				}
	} while (choice != 3);
			
		
}
	public static void main(String[] args) {
		System.out.println("\n=====================================================================");
		System.out.println("\t\t\t********** WELCOME TO MY BANK********** ");
		System.out.println("\n\n\t\t\t     Press Enter TO Continue     ");

		try {
			System.in.read();
		}

		catch (Exception e) {
		}

		LoadingScreen t1 = new LoadingScreen();
		t1.start();
		

	}
}
