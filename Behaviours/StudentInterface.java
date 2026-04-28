package ObjectOrientedProgramming.OOPDemo.Behaviours;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;

public interface StudentInterface {
    void registerCourse(Course course);

    void dropCourse(Integer courseIdToDrop);

}
