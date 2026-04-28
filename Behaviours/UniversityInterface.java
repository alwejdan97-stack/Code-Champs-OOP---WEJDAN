package ObjectOrientedProgramming.OOPDemo.Behaviours;

import ObjectOrientedProgramming.OOPDemo.Entities.Student;
import ObjectOrientedProgramming.OOPDemo.Entities.Teacher;

public interface UniversityInterface {

    Boolean registerStudent(Student student);
    void chargeFees(Integer studentId, String studentName);
    Boolean hireTeachers(Teacher teacher);
}
