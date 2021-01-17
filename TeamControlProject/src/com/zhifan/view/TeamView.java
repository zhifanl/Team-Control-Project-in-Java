package com.zhifan.view;


import com.zhifan.domain.*;
import com.zhifan.service.*;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {
		boolean loopFlag = true;
		char key = 0;

		do {
			if (key != '1') {
				listAllEmployees();
			}
			System.out.print("1-Team List  2-Add team member  3-Delete team member 4-Quit   Please Select(1-4)：");
			key = TSUtility.readMenuSelection();
			System.out.println();
			switch (key) {
			case '1':
				listTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("Please Confirm(Y/N)：");
				char yn = TSUtility.readConfirmSelection();
				if (yn == 'Y'||yn=='y')
					loopFlag = false;
				break;
			}
		} while (loopFlag);
	}

	// list all employees
	private void listAllEmployees() {
		System.out.println("\n-------------------------------Developer Team System--------------------------------\n");
		Employee[] emps = listSvc.getAllEmployees();
		if (emps.length == 0) {
			System.out.println("No record！");
		} else {
			System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tEquipment");
		}

		for (Employee e : emps) {
			System.out.println(" " + e);
		}
		System.out
				.println("-------------------------------------------------------------------------------");
	}

	private void listTeam() {
		System.out
				.println("\n--------------------Developer Team List---------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if (team.length == 0) {
			System.out.println("Developer Team does not have any member！");
		} else {
			System.out.println("TID/ID\tName\tAge\tSalary\tPosition\tBonus\tStock");
		}

		for (Programmer p : team) {
			System.out.println(" " + p.getDetailsForTeam());
		}
		System.out
				.println("-----------------------------------------------------");
	}

	// add member to team
	private void addMember() {
		System.out.println("---------------------Add Member---------------------");
		System.out.print("Type ID：");
		int id = TSUtility.readInt();

		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("Added successfully");
		} catch (TeamException e) {
			System.out.println("Failed to add，Reason：" + e.getMessage());
		}
		// Press return
		TSUtility.readReturn();
	}

	private void deleteMember() {
		System.out.println("---------------------Delete Member---------------------");
		System.out.print("Type TID of the member：");
		int id = TSUtility.readInt();
		System.out.print("Please Confirm(Y/N)：");
		char yn = TSUtility.readConfirmSelection();
		if (yn == 'N'||yn=='n')
			return;

		try {
			teamSvc.removeMember(id);
			System.out.println("Deleted successfully");
		} catch (TeamException e) {
			System.out.println("Failed to delete，Reason：" + e.getMessage());
		}
		TSUtility.readReturn();
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
