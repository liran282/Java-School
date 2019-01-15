import java.util.ArrayList;

public class Main 
{
	public static void main (String[] args) throws IllegalBalance
	{
		
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		
		//creating accounts
		BankAccount scc = new ServiceChargeChecking("01", "Moses", "1111", 0); //monthly fees

		BankAccount nscc = new NoServiceChargeChecking("02", "Abraham", "2222", 500); //5oo min balance
		
		BankAccount sa = new SavingsAccount("03", "Donald", "3333", 2500); //2% interest
		
		BankAccount his = new HighInterestSavings("04", "Ezra", "4444", 3500); //4% interest, 2000 min balance
		
		BankAccount ic = new InterestChecking("05", "David", "5555", 1500); //1% interest, 1000 min balance
		
		//adding accounts to the arrayList
		accounts.add(scc);
		accounts.add(nscc);
		accounts.add(sa);
		accounts.add(his);
		accounts.add(ic);
		
		
		
		for (int i =0; i < accounts.size(); i++)
		{
			System.out.println("\n\t\t\t\t==*==*==*==*==*== TESTING ACCOUNT NUMBER " + i + "  ==*==*==*==*==*==\n");
			System.out.println("-Account Details-");
			System.out.println(accounts.get(i));
			
			
			System.out.println("\n=== Testing deposit ===");
			System.out.println("Depositing 100$\n");
			accounts.get(i).deposit(100);
			System.out.println("-Account Details-");
			System.out.println(accounts.get(i));
			
			
			System.out.println("\n=== Testing withdraw ==="); 
			System.out.println("Withdrawing 99$\n");
			accounts.get(i).withdraw(99);
			System.out.println("-Account Details-");
			System.out.println(accounts.get(i));
			
			
			System.out.println("\n=== Testing withdraw expecting an exception (balance is too low) ===");
			System.out.println("Withdrawing 10,000$\n");
			accounts.get(i).withdraw(10000);
			System.out.println("-Account Details-");
			System.out.println(accounts.get(i));
			
			
			System.out.println("\n=== Testing account management. N/A for accounts without fees. There will be an excpetion if balance is lower than the fees ===");
			System.out.println("Charging accounts with fees \n");
			accounts.get(i).accountMGMT();
			System.out.println("-Account Details-");
			System.out.println(accounts.get(i));
			
			
			System.out.println("\n=== Testing account management expecting no exceptions ===");
			System.out.println("Depositing 10,000$\n");
			accounts.get(i).deposit(10000);
			System.out.println("-Account Details-");
			System.out.println(accounts.get(i));
			System.out.println("\nCharging accounts with fees \n");
			accounts.get(i).accountMGMT();
			System.out.println("-Account Details-");
			System.out.println(accounts.get(i));
			
			
			System.out.println("\n\t\t\t==*==*==*==*==*== TESTING ACCOUNT NUMBER " + i + " HAS BEEN COMPLETED ==*==*==*==*==*==\n");
		}
		
	}
}
