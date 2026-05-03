package ObjectOrientedProgramming.OOPDemo;

import ObjectOrientedProgramming.OOPDemo.Menu.Menu;
import ObjectOrientedProgramming.OOPDemo.Services.DepartmentService;
import ObjectOrientedProgramming.OOPDemo.Services.UniversityService;
import ObjectOrientedProgramming.OOPDemo.Utils.MenuMessages;

import java.util.Scanner;

public class MainApp {


    static Menu menu = new Menu();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        UniversityService universityService = new UniversityService();
        DepartmentService departmentService=new DepartmentService();

        Boolean mainMenuContinue = true;
        while (mainMenuContinue) {
            menu.displayMenu();
            Integer option = input.nextInt();
            switch (option) {
                case 1 -> {
                    Boolean uniMenuContinue = true;
                    while (uniMenuContinue) {
                        System.out.println(" *********** University Menu ***********");
                        System.out.println(MenuMessages.UNIVERSITY_MENU_MESSAGE);
                        Integer universityOption = input.nextInt();
                        uniMenuContinue = universityService.handleUniversityMenu(universityOption);
                    }
                }
                case 2 -> {Boolean deptMenuContinue = true;
                    while (deptMenuContinue) {
                    System.out.println("*********** Department Menu ***********");
                    System.out.println(MenuMessages.DEPARTMENT_MENU_MESSAGE);
                    Integer departmentOption=input.nextInt();
                    deptMenuContinue=departmentService.handleDepartmentMenu(departmentOption);
                    }
                }
                case 3 ->{Boolean teacherMenuContinue = true;
                    while (teacherMenuContinue) {
                        System.out.println("*********** Teacher Menu ***********");
                        System.out.println(MenuMessages.TEACHER_MENU_MESSAGE);
                        Integer teacherOption=input.nextInt();
                        teacherMenuContinue=departmentService.handleDepartmentMenu(teacherOption);
                    }
                }
                case 4 -> {Boolean studentMenuContinue = true;
                    while (studentMenuContinue) {
                        System.out.println("*********** Student Menu ***********");
                        System.out.println(MenuMessages.STUDENT_MENU_MESSAGE);
                        Integer studentOption=input.nextInt();
                        studentMenuContinue=departmentService.handleDepartmentMenu(studentOption);
                    }
                }
                case 5 -> {Boolean courseMenuContinue = true;
                    while (courseMenuContinue) {
                        System.out.println("*********** Course Menu ***********");
                        System.out.println(MenuMessages.COURSE_MENU_MESSAGE);
                        Integer courseOption=input.nextInt();
                        courseMenuContinue=departmentService.handleDepartmentMenu(courseOption);
                    }
                }
                case 6 -> {
                    System.out.println("Exit");
                    mainMenuContinue = false;
                }
                default -> System.out.println("Select a choice from the list");
            }
        }
    }
}
