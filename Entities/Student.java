package ObjectOrientedProgramming.OOPDemo.Entities;


import ObjectOrientedProgramming.OOPDemo.Behaviours.StudentInterface;

public class Student extends Person implements StudentInterface {


    private String registrationYear;

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    @Override
    public void attendCourse() {
        
    }

    @Override
    public void registerCourse() {

    }

    @Override
    public void dropCourse() {

    }

    @Override
    public void takeExam() {

    }
}
