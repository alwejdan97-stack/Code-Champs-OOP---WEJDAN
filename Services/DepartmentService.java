package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.University;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DepartmentService {
    public Scanner scanner = new Scanner(System.in);
    List<Department> departmentList=new ArrayList<>();
    Department departmente=new Department();
    CourseService courseService = new CourseService();
    University university=new University();

    public Department addNewDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Adding new department **");

        Department department = new Department();
        department.setId(UUID.randomUUID());

        System.out.println("Enter Department Name");
        String deptName = scanner.nextLine();
        department.setName(deptName);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter old department Name");
        String oldDepartment=scanner.nextLine();
        Boolean found=false;
        for(Department d: departmentList){
            if(d.getName().equalsIgnoreCase(oldDepartment)){
                //System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                String departmentToUpdate = scanner.nextLine();
                d.setName(departmentToUpdate);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.DEPARTMENT_DELETE_MESSAGE);
        String departmentToDelete = scanner.nextLine();
        Boolean found=false;
        for(Department d:departmentList){
            if(d.getName().equalsIgnoreCase(departmentToDelete)){
                departmentList.remove(d);
                found=true;
                break;
            }
        }
        if(found){
            System.out.println("Deleted successfully");
        }else{
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
                university.displayDepartments();
            }

            case 4 -> {
                System.out.println("== Delete Department ==");
                deleteDepartment();
            }

            case 5 -> {
                return false;
            }
        }
        return true;
    }
}
