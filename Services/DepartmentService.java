package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DepartmentService {
    public static Department department = departmentInit();
    List<Department> departmentList=new ArrayList<>();

    DepartmentService departmentService = new DepartmentService();
    CourseService courseService = new CourseService();

    public Department addNewDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Adding new department **");

        Department department = new Department();
        department.setId(UUID.randomUUID());

        System.out.println("Enter Department Name");
        String deptName = scanner.nextLine();
        department.setName(deptName);

        department.setOfferedCourses(courseService.addNewCourses());

        return department;
    }

    public List<Department> addNewDepartments() {
        Scanner scanner = new Scanner(System.in);
        List<Department> departmentList = new ArrayList<>();
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
        String oldDepartment=scanner.nextLine();
        System.out.println("Enter Department Name");
        for(Department d: departmentList){
            if(d.getName().equalsIgnoreCase(oldDepartment)){
                System.out.println("Enter new department");
                String newDepartmentName = scanner.nextLine();
                d.setName(newDepartmentName);
            }
        }
        Boolean continueFlag = true;
        while (continueFlag){
            System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }
// delete department
    /*public void deleteDepartment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Department Name");
        String departmentName = scanner.nextLine();
        for(Department d: departmentList){
            if(d.getName().equalsIgnoreCase(departmentName)){
                System.out.println("Enter new department");
                departmentList.remove(d);
            }
        }
        Boolean continueFlag = true;
        while (continueFlag){
            System.out.println(Constants.DEPARTMENT_DELETE_MESSAGE);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }
*/
    private static Department departmentInit() {
        Department department = new Department();
        department.setName("English");
        department.setId(UUID.randomUUID());
        //department.setOfferedCourses(List<Department> );
        return department;
    }

    public void displayDepartment(){
        for(Department d: departmentList){
            System.out.println("ID:"+ d.getId()+" | "+ "Name: "+ d.getName());
        }
    }

   /* public Boolean handleDepartmentMenu(Integer departmentOption) {
        switch (departmentOption) {
            case 1 -> {
                System.out.println("Add New Department");
                departmentService.addNewDepartments();
            }
            case 2 -> {
                System.out.println("Update Departments");
                departmentService.updateDepartment();
            }
            case 3 -> {
                System.out.println("Show Department");
                departmentService.displayDepartment();
            }

            case 4 -> {
                System.out.println("Delete Department");
                //departmentService.deleteDepartment();
            }

            case 5 -> {
                return false;
            }
        }
        return true;
    }*/
}
