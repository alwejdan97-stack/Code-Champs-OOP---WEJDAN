package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;
import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.University;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DepartmentService {
    public static Scanner scanner = new Scanner(System.in);
    List<Department> departmentList=new ArrayList<>();
    Department department=new Department();
    CourseService courseService = new CourseService();

    public Department addNewDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Adding new department **");

        Department department = new Department();
        department.setId(UUID.randomUUID());

        System.out.println("Enter Department Name");
        //String deptName = scanner.nextLine();
        department.setName(scanner.nextLine());
        //departmentList.add(deptName);

        department.setOfferedCourses(courseService.addNewCourses());

        return department;
    }

    public List<Department> addNewDepartments() {
        Scanner scanner = new Scanner(System.in);
       // List<Department> departmentList = new ArrayList<>();
        Boolean continueFlag = true;
        while (continueFlag) {
            //System.out.println("Entering multiple departments");
            departmentList.add(addNewDepartment());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_DEPARTMENTS);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return departmentList;
    }

    // updating department
    public void updateDepartment(){
        //Scanner scanner = new Scanner(System.in);
        displayDepartments();
        System.out.println("Enter department Name");
        String department=scanner.nextLine();
        Boolean found=false;
        for(Department d: departmentList){
            if(d.getName().equalsIgnoreCase(department)){
                //System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                //String departmentToUpdate = scanner.nextLine();
                d.setName(scanner.nextLine());
                System.out.println("Successful UPDATE");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Department NOT found");
        }
        Boolean continueFlag = true;
        while (continueFlag){
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_UPDATE_DEPARTMENT);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }
// delete department
    public void deleteDepartment(){
        //Scanner scanner = new Scanner(System.in);
        displayDepartments();
        System.out.println(Constants.DEPARTMENT_DELETE_MESSAGE);
        String departmentToDelete = scanner.nextLine();
        Boolean found=false;
        for(Department d:departmentList){
            if(d.getName().equalsIgnoreCase(departmentToDelete)){
                departmentList.remove(d);
                System.out.println("Successful DELETE");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Deleted FAILED");
        }
        Boolean continueFlag = true;
        while (continueFlag){
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_DELETE_DEPARTMENT);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }

    public void displayByName(List<Department> departmentList){
        if(departmentList.isEmpty()){
            System.out.println("NO department in the list");
        }else {
            displayDepartments();
            System.out.println("Enter Department name to display");
            String departmentToDisplay = scanner.nextLine();
            Boolean found = false;
            for (Department d : departmentList) {
                if (d.getName().equalsIgnoreCase(departmentToDisplay)) {
                    // System.out.println("Department: "+);
                    System.out.println("Department Name: " + d.getName());
                    System.out.println("Department ID: " + d.getId());
                    System.out.println("Offered Courses: " + d.getOfferedCourses());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Department NOT found");
            }
        }
    }

    public void displayDepartments(){
        if(departmentList.isEmpty()){
            System.out.println("NO department in the list");
        }
        for(Department dept: departmentList){
            System.out.println("Department Name: " + dept.getName()+" | "+"Department ID: "+dept.getId());
        }
    }

    public Boolean handleDepartmentMenu(Integer departmentOption) {
        switch (departmentOption){
            case 1 -> {
                System.out.println("== Add New Department ==");
                addNewDepartments();
            }
            case 2 -> {
                System.out.println("== Update Department ==");
                updateDepartment();
            }
            case 3 -> {
                System.out.println("== Show Department ==");
                displayDepartments();
            }

            case 4 -> {
                System.out.println("== Show SPECIFIC Department ==");
                displayByName(departmentList);
            }

            case 5 -> {
                System.out.println("== Delete Department ==");
                deleteDepartment();
            }

            case 6 -> {
                return false;
            }
        }
        return true;
    }
}
