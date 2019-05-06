import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {
	static String employeeName = "", taskDesc = "", dueDate = "";
	static boolean taskStatus;
	final static ArrayList<Task> tasks = new ArrayList<Task>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Task Manager!");

		chooseTask(scan);

		System.out.println("Have a great day!");
		scan.close();

	}

	private static void markComplete(Scanner sc) {
		int updateStatus = 0;
		boolean isValid = false;
		
		printTaskList(tasks);
		System.out.print("\n" + "Which task number would you like to update? ");
		
		while(isValid != true) {
			updateStatus = sc.nextInt() - 1;
			try {
				if(updateStatus >= 0 && updateStatus < tasks.size()) {
					isValid =true;
				} else {
					throw new IndexOutOfBoundsException();
				}
			} catch(IndexOutOfBoundsException e) {
				System.out.print("\n" + "Please enter a valid task number from the list: ");
			}
		}
		
		System.out.print(
				"\n" + (updateStatus + 1) + ". " + tasks.get(updateStatus) + "Are you sure you want to update this task? (y/n): ");
		String confirm = sc.next();
		if (confirm.toLowerCase().contains("y")) {
			tasks.get(updateStatus).setTaskStatus(true);
			
		}
		
	}

	private static void deleteTask(Scanner sc) {
		int deleteTask = 0;
		boolean isValid = false;
		
		printTaskList(tasks);
		System.out.print("\n" + "Which task number would you like to remove? ");

		while (isValid != true) {
			deleteTask = sc.nextInt() - 1;
			try {
				if (deleteTask >= 0 && deleteTask < tasks.size()) {
					isValid = true;
				} else {
					throw new IndexOutOfBoundsException();
				}

			} catch (IndexOutOfBoundsException e) {
				System.out.print("\n" + "Please enter a valid task number from the list: ");
			}
		}

		System.out.print("\n" + (deleteTask + 1) + ". " + tasks.get(deleteTask)
				+ "Are you sure you want to remove this task? (y/n): ");
		String confirm = sc.next();

		if (confirm.toLowerCase().contains("y")) {
			tasks.remove(deleteTask);
		}

	}

	private static void createTask(Scanner sc) {
		Task task = new Task();

		task.getEmployeeName(sc, "Team member name: ");
		task.getTaskDesc(sc, "Task description: ");
		task.getDueDate(sc, "Due date (mm/dd/yyyy): ");
		task.getTaskStatus(false);
		tasks.add(task);

		System.out.println("Task created!");
	}

	public static void chooseTask(Scanner sc) {
		int userChoice;
		do {
			String[] taskChoiceArray = { "1. List tasks", "2. Add task", "3. Delete task", "4. Mark task complete",
					"5. Quit" };

			printTaskMenu(taskChoiceArray);
			System.out.print("What would you like to do? ");
			userChoice = sc.nextInt();
			sc.nextLine();
			System.out.print("\n");

			switch (userChoice) {

			// display task
			case 1:
				printTaskList(tasks);
				break;

			case 2:
				createTask(sc);
				break;

			// delete task
			case 3:
				deleteTask(sc);
				break;

			// mark complete
			case 4:
				markComplete(sc);
				break;

			// quit
			case 5:
				System.out.print("Are you sure you want to quit? (y/n) ");
				String confirm = sc.next();
				if (confirm.toLowerCase().contains("y")) {
					break;
				} else {
					chooseTask(sc);
				}
			default:
				break;
			}

		} while (userChoice != 5);
	}

	private static void printTaskList(ArrayList<Task> tasks) {
		System.out.printf("%-8s %-15s %-17s %-15s %-15s \n", "Number", "Team Member", "Description", "Due Date",
				"Done?");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.print(i + 1 + ". " + tasks.get(i));
		}
	}

	private static void printTaskMenu(String[] arr) {
		System.out.print("\n");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
