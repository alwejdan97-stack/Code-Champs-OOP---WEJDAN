package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.Student;
import ObjectOrientedProgramming.OOPDemo.Entities.University;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class StudentService {
    CourseService courseService = new CourseService();
    DepartmentService departmentService = new DepartmentService();
    List<Student> studentList=new ArrayList<>();
    University university=new University();

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
                System.out.println(Constants.STUDENT_UPDATE_MESSAGE);
                String studentToUpdate = scanner.nextLine();
                s.setName(studentToUpdate);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Student NOT found");
        }
        Boolean continueFlag = true;
        while (continueFlag){
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_UPDATE_STUDENT);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }

    // delete department
    public void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.STUDENT_DELETE_MESSAGE);
        String studentToDelete = scanner.nextLine();
        Boolean found=false;
        for(Student s:studentList){
            if(s.getName().equalsIgnoreCase(studentToDelete)){
                studentList.remove(s);
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
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_DELETE_STUDENT);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }

    public Boolean handleStudentMenu(Integer departmentOption) {
        switch (departmentOption){
            case 1 -> {
                System.out.println("== Add New Student ==");
                addNewStudents();
            }
            case 2 -> {
                System.out.println("== Update Student ==");
                updateStudent();
            }
            case 3 -> {
                System.out.println("== Show Student ==");
                university.displayDepartments();
            }

            case 4 -> {
                System.out.println("== Delete Student ==");
                deleteStudent();
            }

            case 5 -> {
                return false;
            }
        }
        return true;
    }
}
