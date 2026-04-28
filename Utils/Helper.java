package ObjectOrientedProgramming.OOPDemo.Utils;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;

public class Helper {

    public static Boolean isNull(Course course) {
        return course.equals(null);
    }

    public static Boolean isNotNull(Course course) {
        return !isNull(course);
    }
}
