package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.Student;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class StudentService {
    CourseService courseService = new CourseService();
    DepartmentService departmentService = new DepartmentService();
    List<Student> studentList=new ArrayList<>();

    public Student addNewStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ** Adding new Student **");
        //object student class
        Student student = new Student();
        student.setId(UUID.randomUUID());

        System.out.println("Enter student Name: ");
        String stdName = scanner.nextLine();

        System.out.println("Departments List");
        UniversityService.university.displayDepartments();

        System.out.println("Enter Department: ");
        student.setDepartment(departmentService.addNewDepartment());

        student.setCourseList(student.getDepartment().getOfferedCourses());
     return student;
    }

    public List<Student> addNewStudents(){
        Scanner scanner = new Scanner(System.in);
        List<Student> studentsList = new ArrayList<>();

        Boolean continueFlag = true;
        while (continueFlag) {
            studentsList.add(addNewStudent());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_STUDENTS);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return studentsList;
    }
    public void updateStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter old student Name");
        String oldStudent=scanner.nextLine();
        Boolean found=false;
        for(Student s: studentList){
            if(s.getName().equalsIgnoreCase(oldStudent)){
                //System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                String departmentToUpdate = scanner.nextLine();
                s.setName(departmentToUpdate);
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
}
