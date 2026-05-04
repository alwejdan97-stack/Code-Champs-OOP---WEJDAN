package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Person;
import ObjectOrientedProgramming.OOPDemo.Entities.Student;
import ObjectOrientedProgramming.OOPDemo.Entities.Teacher;
import ObjectOrientedProgramming.OOPDemo.Entities.University;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TeacherService {

    static Integer counter = 1;
    static PersonService personService = new PersonService();
    static DepartmentService departmentService = new DepartmentService();
    static CourseService courseService = new CourseService();
    static University university=new University();
    public static List<Teacher> teacherList = new ArrayList<>();
    public static Scanner scanner=new Scanner(System.in);


    public Teacher addNewTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Adding new teacher **");

        Teacher teacher = (Teacher) personService.addNewPerson();
        /*teacher.setId(UUID.randomUUID());

        System.out.println("Enter Name");
        String teacherName = scanner.nextLine();
        teacher.setName(teacherName);

        System.out.println("Enter Email");
        String teacherEmail = scanner.nextLine();
        teacher.setEmail(teacherEmail);

        System.out.println("Enter Phone Number");*/

        teacher.setTeacherId("TH-" + counter);
        counter += 1;

        System.out.println("Departments & Associated Courses: ");
        UniversityService.university.displayDepartments();

        teacher.setDepartment(departmentService.addNewDepartment());

        teacher.setCourseList(courseService.addNewCourses());
        return teacher;
    }

    public List<Teacher> addNewTeachers() {
        Scanner scanner = new Scanner(System.in);
        //List<Teacher> teacherList = new ArrayList<>();
        Boolean continueFlag = true;
        while (continueFlag) {
            teacherList.add(addNewTeacher());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_TEACHER);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return teacherList;
    }

    public void updateTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter old teacher Name");
        String oldTeacher=scanner.nextLine();
        Boolean found=false;
        for(Teacher t: teacherList){
            if(t.getName().equalsIgnoreCase(oldTeacher)){
                //System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                System.out.println(Constants.TEACHER_UPDATE_MESSAGE);
                String teacherToUpdate = scanner.nextLine();
                t.setName(teacherToUpdate);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Teacher NOT found");
        }
        Boolean continueFlag = true;
        while (continueFlag){
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_UPDATE_TEACHER);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }

    // delete department
    public void deleteTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.TEACHER_DELETE_MESSAGE);
        String teacherToDelete = scanner.nextLine();
        Boolean found=false;
        for(Teacher t:teacherList){
            if(t.getName().equalsIgnoreCase(teacherToDelete)){
                teacherList.remove(t);
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
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_DELETE_TEACHER);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }

    public void displayByName(List<Teacher> teacherList){
        if(teacherList.isEmpty()){
            System.out.println("NO Teacher in the list");
            return;
        }else {
            displayTeachers();
            System.out.println("Enter Teacher name to display");
            String teacherToDisplay = scanner.nextLine();
            Boolean found = false;
            for (Teacher t : teacherList) {
                if (t.getName().equalsIgnoreCase(teacherToDisplay)) {
                    System.out.println("Teacher Name: " + t.getName());
                    System.out.println("Teacher ID: " + t.getId());
                    System.out.println("Date Of Birth: " + t.getDateOfBirth());
                    System.out.println("Teacher Email: " + t.getEmail());
                    System.out.println("Teacher ID Card: " + t.getIdCard());
                    System.out.println("Teacher Phone Number: " + t.getPhoneNumber());
                    System.out.println("Department: " + t.getDepartment());
                    System.out.println("Courses List: " + t.getCourseList());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Teacher NOT found");
            }
        }
    }

    public void displayTeachers(){
        if(teacherList.isEmpty()){
            System.out.println("NO Teacher in the list");
            return;
        }
        for(Teacher t:teacherList){
            System.out.println("Teacher Name: "+t.getName()+ " | "+ " Teacher ID Card: "+t.getTeacherId()+" | "+" Teacher ID: "+t.getId());
        }
    }

    public Boolean handleTeacherMenu(Integer teacherOption) {
        switch (teacherOption){
            case 1 -> {
                System.out.println("== Add New Teacher ==");
                addNewTeacher();
            }
            case 2 -> {
                System.out.println("== Update Teacher ==");
                updateTeacher();
            }
            case 3 -> {
                System.out.println("== Show Teacher ==");
                university.displayDepartments();
            }

            case 4 -> {
                System.out.println("== Show SPECIFIC Teacher ==");
                displayByName(teacherList);
            }

            case 5 -> {
                System.out.println("== Delete Teacher ==");
                deleteTeacher();
            }

            case 6 -> {
                return false;
            }
        }
        return true;
    }
}
