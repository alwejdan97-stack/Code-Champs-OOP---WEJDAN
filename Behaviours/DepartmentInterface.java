package ObjectOrientedProgramming.OOPDemo.Behaviours;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;
import ObjectOrientedProgramming.OOPDemo.Entities.Department;

import java.util.UUID;

public interface DepartmentInterface {

    Boolean addCourse(Course course);
    Boolean removeCourse(Course course);
    Boolean modifyCourse(UUID id, Course updatedCourse);
    //Boolean updateDepartment();
    //Boolean deleteDepartment();
}
