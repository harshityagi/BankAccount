import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount obj1=new BankAccount("XYZ","B40001");
		obj1.showMenu();
	}
}

class BankAccount
{
	int balance;
	int previousTransection;
	String customerName;
	String customerId;
	BankAccount(String cName,String cId){
		customerName=cName;
		customerId=cId;
	}
	void deposit(int amount) {
		if(amount!=0){
			balance=balance+amount;
			previousTransection=amount;
		}
	}
	void withdraw(int amount) {
		if(amount!=0){
			balance=balance-amount;
			previousTransection=-amount;
		}
	}
	void getPreviousTransection() {
		if(previousTransection>0) {
			System.out.println("Depostied : "+previousTransection);
		}else if(previousTransection<0) {
			System.out.println("Withdraw : "+ Math.abs(previousTransection));			
		}else {
			System.out.println("No Transection Occured");
		}
	}
	void showMenu() {
		char option='\0';
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome "+ customerName);
		System.out.println("Your ID is "+ customerId +"\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("Enter an Option");
			option=scanner.next().charAt(0);
			System.out.println("\n");
			switch(option) {
			case 'A' | 'a': 
				System.out.println("Balance="+balance);
				break;
			case 'b' | 'B':
				System.out.println("Enter an amount to deposit:");
				int amount=scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
			case 'C'|'c':
				System.out.println("Enter an amount to withdraw :");
				int amount2=scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
			case 'D'|'d':
				getPreviousTransection();
				System.out.println("\n");
				break;
			case 'E'|'e':
				System.out.println("Please Get Lost");
				break;
			default:
				System.out.println("Invalid Option!!.Please enter again");
				break;
			}
		}while(option!='E');
		
		System.out.println("Thank You for using our Services");
		scanner.close();
	}
}
