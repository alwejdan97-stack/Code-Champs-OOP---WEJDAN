package ObjectOrientedProgramming.OOPDemo.Behaviours;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;

public interface DepartmentInterface {

    Boolean addCourse(Course course);
    Boolean removeCourse(Course course);
    Boolean modifyCourse(Integer id, Course updatedCourse);

}
