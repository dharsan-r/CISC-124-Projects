/** Person parent class for all types of people in database regardless of type of student or staff.
 * Also contains compare to method to compare the ages of two Persons
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    /**
     * Constructor for a Person
     *
     * @param firstName The string first name of a person
     * @param lastName The string last name of a person
     * @param age The integer age of person
     * @throws HRException if any illegal values outlined in assignment are entered
     */
    public Person(String firstName, String lastName, int age) throws HRException{
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    /**
     * Getter method for first name
     *
     * @return firstName the private String first name of a person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for first name
     *
     * @param firstName The String first name of a person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for last name
     *
     * @return lastName the String private last name of a person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for first name
     *
     * @param lastName The String last name of a person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for age
     *
     * @return age the integer private age of a person
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for a persons age
     *
     * @param age The integer age of a person
     * @throws HRException if a persons age is below 15 years old
     */
    public void setAge(int age) throws HRException{
        if(age>=15) {
            this.age = age;
        }else {
            throw new HRException("Invalid Age!");
        }
    }

    /**
     * Compare to method to compare two Persons' ages
     *
     * @param person2 second Person object to compare age to
     * @return ageGap the age gap between two people, positive if first person is older, negative if younger and 0 if same
     */
    public int compareTo(Person person2){
        int ageGap = this.getAge()-person2.getAge(); // calculates age gap between two people
        //Prints out who's older and their difference based on the age gap calculated
        if(ageGap<0){
            System.out.println(person2.getFirstName() + " is " + ageGap*-1 + " years older than "
                    + this.getFirstName() +".");
            return ageGap;
        }else if (ageGap==0){
            System.out.println(this.getFirstName() + " is the same age as " + person2.getFirstName() + ".");
            return ageGap;
        }else {
            System.out.println(this.getFirstName() + " is " + ageGap + " years older than "
                    + person2.getFirstName() +".");
            return ageGap;
        }
    }

    /**
     * To string default method for printing out all information on a Person.
     *
     * @return String that is specified bellow
     */
    public String toString(){
        return "\nName: " + getFirstName() + " " + getLastName() +"\nAge: " + getAge();
    }
}
