import java.util.ArrayList; // Imports ArrayList to store Person objects

/**
 * Registry; code where all information on any person is stored regardless of staff or student status. It stores and
 * prints all Person objects' information from an Array list.
 *
 * @author Dharsan Ravindran
 * @since 2021-08-09
 * @version 1.0
 * Student ID: 20219218
 * Instructor: Professor Paul Allison
 */
public class Registry {
    private static ArrayList<Person> personDB = new ArrayList<>(); // Creates array list to store Persons

    /**
     *Creates many instances of a Person and adds to personsDB array list.
     * Many different commented lines are created to show how error methods work. Please uncomment each constructor to
     * see how errors are implemented.
     *
     * @param personDB Person object array list which contains all Persons for HR use
     * @throws HRException if any illegal values outlined in assignment are entered
     */
    private static void addPeople(ArrayList<Person> personDB) throws HRException{
        Person person1 = new FacultyMember("Jonathan", "Ross", 37, 17271, 4, DepartmentType.ENGINEER, Training.BACHELOR);
        personDB.add(person1);
        person1.setLastName("McField"); // Tests the LastName mutator
        Person person2 = new Undergraduate("Samuel", "Jackson", 26 , 12761, 4, 5, 60200, true, false, MajorType.MEDICINE);
        person2.setAge(27); // Tests the age mutator
        System.out.println("Person2 First Name: " + person2.getFirstName()); // Tests the first name accessor
        personDB.add(person2);
        Person person3 = new Undergraduate("Bob", "Jones", 37, 14532, 3, 4, 61562, false, true, MajorType.EDUCATION);
        System.out.println("Person3 Last Name: " + person3.getLastName()); // Tests the last name accessor
        personDB.add(person3);
        Person person4 = new SupportStaff("Betty", "Craig", 48, 83734, 3, DepartmentType.EDUC, 60, 22);
        System.out.println("Person4 Age: " +person4.getAge()); // Tests the age accessor
        personDB.add(person4);
        System.out.println(person3.compareTo(person4)+"\n"); // Tests the compare to method for ages
        Person person5  = new Graduate("Naomi" , "Osaka", 17, 19911, 2, 4, 61000.91, false, 1100, Program.MASTERS);
        personDB.add(person5);
        Person person6 = new FacultyMember("Sam", "Hayden", 71, 12831, 12, DepartmentType.HEALTH_SCI, Training.GRADUATE);
        personDB.add(person6);
        Person person7 = new SupportStaff("Marshal", "Mather", 41, 12931, 1, DepartmentType.ARTS_SCI, 25, 35.44);
        personDB.add(person7);
        Person person8 = new Graduate("Ryan", "Menak", 24, 91283, 2, 5, 110000.34, true, 1100.21, Program.PHD);
        personDB.add(person8);


        //Person person9 = new FacultyMember("Michael", "Phelps", 14, 21312, 3, DepartmentType.ARTS_SCI,
        //        Training.BACHELOR); // Tests for invalid age

        //Person person10 = new FacultyMember("Andre", "De Grasse", 22, 91299, 0, DepartmentType.EDUC,
        //        Training.GRADUATE); // Tests for too less years worked

        //Person person11 = new FacultyMember("Lebron", "James", 88, 12031, 40, DepartmentType.EDUC,
        //        Training.GRADUATE); // Tests for too much years worked

        //Person person12 = new Undergraduate("Wayne", "Gretzky", 72, 01233, 0, 4, 70111, false, true,
        //        MajorType.EDUCATION); // Tests for to little years of study

        //Person person13 = new Graduate("Patrick", "Kane", 42, 71721, 11, 5, 60111, true, 2000,
        //        Program.MASTERS); // Tests for too many years of study

        //Person person14 = new Graduate("Mario", "Fitapaldi", 51, 12321, 8, 0, 71111, false, 1001,
        //        Program.PHD); // Tests for too little course number

        //Person person15 = new Undergraduate("Sidney", "Crosby", 33, 61686, 4, 6, 60001, true, false,
        //        MajorType.COMPUTER_SCIENCE); // Tests for too much courses

        //Person person16 = new Graduate("Randy", "Johnson", 22, 17392, 2, 5, 60000, true, 2000,
        //        Program.MASTERS); // Tests for too little scholarship

        //Person person17 = new Graduate("Ozzie", "Smith", 91, 31821, 3, 5, 120000, true, 2000,
        //        Program.PHD); // Tests for too much scholarship

        //Person person18 = new SupportStaff("Yogi", "Berra", 44, 36719, 30, DepartmentType.HEALTH_SCI,
        //        60, 14);// Tests invalid base pay rate

        //Person person19 = new Graduate("Kim", "Smith", 49, 25891, 2, 4, 61211, true, 1000,
        //        Program.PHD); // Tests for too little grant

    }

    /**
     * Prints out all information on all Persons based on their respective to string methods from their classes
     *
     * @param personDB Person object array list which contains all Persons for HR use
     */
    private static void printRegistry(ArrayList<Person> personDB){
        System.out.println("Person1 First Name: " + personDB.get(0).getFirstName()); // tests an accessor from the array list
        personDB.get(0).setFirstName("Dan"); // tests a mutator from the array list
        for(Person person : personDB){
            System.out.println(person + "\n\n------------------------------------");
        }
        System.out.println(personDB.get(0).compareTo(personDB.get(1))); // tests teh age compare to method from the array list
        personDB.get(0).compareTo(personDB.get(2)); // test the age compare to method without printing the +,0, or - num
    }

    /**
     * Main method where all print and array Persons are instantiated and printed
     *
     * @throws HRException if any illegal values outlined in assignment are entered
     */
    public static void main(String[] args) throws HRException{
        addPeople(personDB); // adds all specified people to the data base
        printRegistry(personDB); // prints out all specified people while testing some methods

    }

}
