package ObjectOrientedProgramming.OOPDemo.Behaviours;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;

import java.util.UUID;

public interface DepartmentInterface {

    Boolean addCourse(Course course);
    Boolean removeCourse(Course course);
    Boolean modifyCourse(UUID id, Course updatedCourse);

}
