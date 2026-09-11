
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

	public static void main(String[] args) {
		
		ArrayList<Expense> expenses = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		
		boolean running = true;

		while (running) {

		    System.out.println();
		    System.out.println("===== PERSONAL EXPENSE TRACKER =====");
		    System.out.println("1. Add Expense");
		    System.out.println("2. View Expenses");
		    System.out.println("3. View Total Spending");
		    System.out.println("4. View Spending by Category");
		    System.out.println("5. Exit");

		    System.out.print("Enter your choice: ");
		    int choice = input.nextInt();
		    input.nextLine();

		    if (choice == 1) {

		        // Add expense
		    	System.out.print("Enter expense name: ");
                String name = input.nextLine();

                System.out.print("Enter amount: ");
                double amount = input.nextDouble();
                input.nextLine();

                System.out.print("Enter category: ");
                String category = input.nextLine();

                Expense expense = new Expense(name, amount, category);
                expenses.add(expense);

                System.out.println("Expense added!");

		    } else if (choice == 2) {

		    	System.out.println();
                System.out.println("===== YOUR EXPENSES =====");

                for (Expense expense : expenses) {
                    System.out.println("Name: " + expense.name);
                    System.out.println("Amount: $" + expense.amount);
                    System.out.println("Category: " + expense.category);
                    System.out.println();
                }

		    } else if (choice == 3) {

		        double total = 0;

		        for (Expense expense : expenses) {
		            total = total + expense.amount;
		        }

		        System.out.println("Total Spending: $" + total);

		    } else if (choice == 4) {

		        System.out.print("Enter a category: ");
		        String searchCategory = input.nextLine();

		        double categoryTotal = 0;

		        for (Expense expense : expenses) {

		            if (expense.category.equalsIgnoreCase(searchCategory)) {
		                categoryTotal = categoryTotal + expense.amount;
		            }
		        }

		        System.out.println(searchCategory + ": $" + categoryTotal);

		    } else if (choice == 5) {

		        running = false;
		        System.out.println("Goodbye!");

		    } else {

		        System.out.println("Invalid choice.");

		    }
		}
		
        input.close();
		
	}

}
