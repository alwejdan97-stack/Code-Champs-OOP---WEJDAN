package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.Student;
import ObjectOrientedProgramming.OOPDemo.Entities.Teacher;
import ObjectOrientedProgramming.OOPDemo.Entities.University;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static ObjectOrientedProgramming.OOPDemo.Services.TeacherService.personService;

public class StudentService {
    CourseService courseService = new CourseService();
    DepartmentService departmentService = new DepartmentService();
    List<Student> studentList=new ArrayList<>();
    University university=new University();
    public static Scanner scanner=new Scanner(System.in);

    public Student addNewStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ** Adding new Student **");
        Student teacher = (Student) personService.addNewPerson();
        //object student class
        Student student = new Student();
        student.setId(UUID.randomUUID());

        System.out.println("Enter student Name: ");
        //String stdName = scanner.nextLine();
        student.setName(scanner.nextLine());

        System.out.println("Departments List");
        UniversityService.university.displayDepartments();

        System.out.println("Enter Department: ");
        student.setDepartment(departmentService.addNewDepartment());

        student.setCourseList(student.getDepartment().getOfferedCourses());
     return student;
    }

    public List<Student> addNewStudents(){
        //Scanner scanner = new Scanner(System.in);
        //List<Student> studentsList = new ArrayList<>();
        Boolean continueFlag = true;
        while (continueFlag) {
            studentList.add(addNewStudent());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_STUDENTS);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return studentList;
    }

    public void updateStudent(){
        displayStudents();
        System.out.println("Enter student name");
        String name=scanner.nextLine();
        //UUID uuid=UUID.fromString(id);
       /* UUID uuid;
        try{
            uuid=UUID.fromString(id);
        }catch(Exception ex){
            System.out.println("Invalid ID");
        }*/
        Boolean found=false;
        for(Student s: studentList){
            if(s.getName().equalsIgnoreCase(name)){
                //System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                System.out.println(Constants.STUDENT_UPDATE_MESSAGE);
                //String studentToUpdate = scanner.nextLine();
                s.setName(scanner.nextLine());
                System.out.println("Successful UPDATE");
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
        displayStudents();
        System.out.println(Constants.STUDENT_DELETE_MESSAGE);
        String id = scanner.nextLine();
        UUID uuid=UUID.fromString(id);
        /*UUID uuid;
        try{
            uuid=UUID.fromString(id);
        }catch(Exception ex){
            System.out.println("Invalid ID");
        }*/
        Boolean found=false;
        for(Student s:studentList){
            if(s.getId().equals(uuid)){
                studentList.remove(s);
                System.out.println("Successful Delete");
                found=true;
                break;
            }
        }
        if(!found){
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

    public void displayStudents(){
        if(studentList.isEmpty()){
            System.out.println("NO student in the list");
            return;
        }
        for(Student st:studentList){
            System.out.println("Student Name: "+st.getName()+" | "+" Student ID: "+st.getId());
        }
    }

    public Boolean handleStudentMenu(Integer studentOption) {
        switch (studentOption){
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
                displayStudents();
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
