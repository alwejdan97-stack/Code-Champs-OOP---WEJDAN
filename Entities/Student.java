package ObjectOrientedProgramming.OOPDemo.Entities;


import ObjectOrientedProgramming.OOPDemo.Behaviours.StudentInterface;
import ObjectOrientedProgramming.OOPDemo.Constants;

import java.util.List;

public class Student extends Person implements StudentInterface {


    private String registrationYear;

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    @Override
    public void registerCourse(Course course) {
        if (!(course.equals(null) && course.getId().equals(null))) {
            List<Course> tempCourseList = this.getCourseList();
            tempCourseList.add(course);
            this.setCourseList(tempCourseList);
            System.out.println(Constants.STUDENT_COURSE_REGISTERED);
        } else {
            System.out.println(Constants.STUDENT_COURSE_NOT_REGISTERED);
        }

    }

    @Override
    public void dropCourse(Integer courseIdToDrop) {
        List<Course> tempCourseList = this.getCourseList();

        for (Course c : tempCourseList) {
            if (c.getId().equals(courseIdToDrop)) {
                tempCourseList.remove(c);
            }
        }

        this.setCourseList(tempCourseList);
    }
}
