import java.util.Scanner;

public class Task {
	
	private String employeeName;
	private String taskDesc;
	private String dueDate;
	private boolean taskStatus;
	
	public Task() {

	}
	
	public void getEmployeeName(Scanner sc, String prompt) {
		System.out.print(prompt);
		employeeName = sc.nextLine();
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public void getTaskDesc(Scanner sc, String prompt) {
		System.out.print(prompt);
		taskDesc = sc.nextLine();
	}
	
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	public void getDueDate(Scanner sc, String prompt) {
		System.out.print(prompt);
		dueDate = sc.next();
		//sc.nextLine();
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public void getTaskStatus(boolean taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	public void setTaskStatus(boolean taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	@Override
	public String toString() {
		return String.format("%-5s %-15s %-17s %-15s %-15s \n", 
				"   " , employeeName, taskDesc, dueDate, taskStatus);
	}
}
