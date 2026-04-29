package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Person;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class PersonService {

    public Person addNewPerson() {

        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        person.setId(UUID.randomUUID());

        System.out.println(Constants.PERSON_ENTER_NAME);
        person.setName(scanner.nextLine());

        System.out.println(Constants.PERSON_ENTER_EMAIL);
        person.setEmail(scanner.nextLine());

        System.out.println(Constants.PERSON_ENTER_PHONE_NUMBER);
        person.setPhoneNumber(scanner.nextLine());

        System.out.println(Constants.PERSON_ENTER_ID_CARD);
        person.setIdCard(scanner.nextLine());

        System.out.println(Constants.PERSON_ENTER_DATE_OF_BIRTH);
        person.setDateOfBirth(scanner.nextLine());

        return person;

    }

    public List<Person> addNewPersons() {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Boolean continueFlag = true;
        while (continueFlag) {
            personList.add(addNewPerson());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_PERSON);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return personList;
    }
}
