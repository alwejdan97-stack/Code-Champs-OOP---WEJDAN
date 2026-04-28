package ObjectOrientedProgramming.OOPDemo.Entities;

import ObjectOrientedProgramming.OOPDemo.Behaviours.TeacherInterface;
import ObjectOrientedProgramming.OOPDemo.Constants;
import ObjectOrientedProgramming.OOPDemo.Utils.Helper;

import java.util.List;

public class Teacher extends Person implements TeacherInterface {

    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public void assignCourse(Course courseToAssign) {
        if (Helper.isNotNull(courseToAssign)) {
            List<Course> tempCourseList = this.getCourseList();
            tempCourseList.add(courseToAssign);
            this.setCourseList(tempCourseList);
            System.out.println(Constants.TEACHER_COURSE_ASSIGNED);
        } else {
            System.out.println(Constants.TEACHER_NOT_COURSE_ASSIGNED);
        }
    }
}
