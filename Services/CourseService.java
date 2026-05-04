package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;
import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.University;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CourseService {
    public List<Course> courseList=new ArrayList<>();
    University university=new University();
    Department department=new Department();
    public static Scanner scanner = new Scanner(System.in);

    public Course addNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Adding new Course to the department **");

        Course course = new Course();
        course.setId(UUID.randomUUID());

        System.out.println("Enter course name");
        String courseName = scanner.nextLine();
        course.setName(courseName);

        System.out.println("Enter course code");
        String courseCode = scanner.nextLine();
        course.setCourseCode(courseCode);

        return course;

    }

    public List<Course> addNewCourses() {
        Scanner scanner = new Scanner(System.in);
        //List<Course> courseList = new ArrayList<>();
        Boolean continueFlag = true;
        while (continueFlag) {
            //System.out.println("Entering multiple courses");
            courseList.add(addNewCourse());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_COURSE);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }

        return courseList;
    }

    // updating department
    public void updateCourse(){
        displayCourses();
        System.out.println("Enter course Name");
        String oldCourse=scanner.nextLine();
        Boolean found=false;
        for(Course c:courseList){
            if(c.getName().equalsIgnoreCase(oldCourse)){
                //System.out.println(Constants.DEPARTMENT_UPDATE_MESSAGE);
                System.out.println(Constants.COURSE_UPDATE_MESSAGE);
                //String courseToUpdate = scanner.nextLine();
                c.setName(scanner.nextLine());
                System.out.println("Successful UPDATE");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Course NOT found");
        }
        Boolean continueFlag = true;
        while (continueFlag){
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_UPDATE_COURSE);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }
    // delete department
    public void deleteCourse(){
        displayCourses();
        System.out.println(Constants.COURSE_DELETE_MESSAGE);
        String courseToDelete = scanner.nextLine();
        Boolean found=false;
        for(Course c :courseList){
            if(c.getName().equalsIgnoreCase(courseToDelete)){
                courseList.remove(c);
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
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_DELETE_COURSE);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
    }

    public void displayByName(List<Course> courseList) {
        if (courseList.isEmpty()) {
            System.out.println("NO course in the list");
        } else {
            displayCourses();
        System.out.println(Constants.COURSE_DISPLAY_BY_NAME_MESSAGE);
        String courseToDisplay = scanner.nextLine();
        Boolean found = false;
        for (Course c : courseList) {
            if (c.getName().equalsIgnoreCase(courseToDisplay)) {
                // System.out.println("Department: "+);
                System.out.println("Course Name: " + c.getName());
                System.out.println("Course Code: " + c.getCourseCode());
                System.out.println("Course ID: " + c.getId());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Course NOT found");
        }
        }
    }

    public void displayCourses(){
        if(courseList.isEmpty()){
            System.out.println("NO course in the list");
        }
        for(Course c:courseList){
            System.out.println("Course Name: "+ c.getName()+" | "+ " Course Code: "+ c.getCourseCode()+ " | " +" Course ID: "+c.getId());
        }
    }

    public Boolean handleCourse(Integer courseOption) {
        switch (courseOption){
            case 1 -> {
                System.out.println("== Add New Course ==");
                addNewCourses();
            }
            case 2 -> {
                System.out.println("== Update Course ==");
                updateCourse();
            }
            case 3 -> {
                System.out.println("== Show Courses ==");
                displayCourses();
            }

            case 4 -> {
                System.out.println("== Show SPECIFIC Course ==");
                displayByName(courseList);
            }

            case 5 -> {
                System.out.println("== Delete Course ==");
                deleteCourse();
            }

            case 6 -> {
                return false;
            }
        }
        return true;
    }
}
