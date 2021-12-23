/**
 * Undergraduate sub class of Student parent class which is extended. Contains all information from
 * Student parent class plus information on their major(an enumerated type), and residence status.
 * Invokes super method to construct a Staff member.
 */
public class Undergraduate extends Student{
    private boolean residence;
    private MajorType major;

    /**
     * Constructor for a Undergraduate Invokes super method to construct a Student
     *
     * @param firstName The string first name of a person
     * @param lastName The string last name of a person
     * @param age The integer age of person
     * @param studentID the integer student id of a student
     * @param studyYear the integer year of study for a student
     * @param courseNum the integer number of courses a student is taking
     * @param scholarship the double scholarship amount a student has
     * @param domestic a boolean true if a student is domestic and false if international
     * @param residence a boolean true if a student is living on residence and false if not
     * @param major The major enum for a undergrads major
     * @throws HRException HRException if any illegal values outlined in assignment are entered
     */
    public Undergraduate(String firstName, String lastName, int age, int studentID, int studyYear, int courseNum,
                         double scholarship, boolean domestic, boolean residence, MajorType major) throws HRException {
        super(firstName, lastName, age, studentID, studyYear, courseNum, scholarship, domestic);
        setResidence(residence);
        setMajor(major);
    }

    /**
     * Implements the abstract method from the Student class and calculates a Undergraduate's tuition
     *
     * @return a double for a students tuition based on major and domestic status outlined in assignment (scholarship is subtracted)
     */
    public double calculateTuition(){
        double amount = 0;
        if(getMajor() == MajorType.ENGLISH){
            if(isDomestic() == true){
                amount = 9934;
            }else {
                amount =  30263;
            }
        }else if(getMajor() == MajorType.COMPUTER_SCIENCE){
            if(isDomestic() == true){
                amount = 9619;
            }else {
                amount = 33875;
            }
        }else if(getMajor() == MajorType.MATHEMATICS){
            if(isDomestic() == true){
                amount = 9567;
            }else {
                amount = 34537;
            }
        }else if(getMajor() == MajorType.ENGINEERING){
            if(isDomestic() == true){
                amount = 12626;
            }else {
                amount = 29873;
            }
        }else {
            if (isDomestic()==true){
                amount = 7037;
            }else {
                amount = 32416;
            }
        }
        return amount-getScholarship();
    }

    /**
     * Getter method for an Undergrad's residence status
     *
     * @return residence a boolean true if a student is living on residence and false if not
     */
    public boolean isResidence() {
        return residence;
    }

    /**
     * Setter method for an Undergrad's residence status
     *
     * @param residence a boolean true if a student is living on residence and false if not
     */
    public void setResidence(boolean residence) {
        this.residence = residence;
    }

    /**
     * Getter method for an Undergrad's major type
     *
     * @return major The major enum for a undergrads major
     */
    public MajorType getMajor(){
        return major;
    }

    /**
     * Setter method for an Undergrad's major type
     *
     * @param major The major enum for a undergrads major
     */
    public void setMajor(MajorType major){
        this.major = major;
    }

    /**
     * Calls the super class to print all the information from the toString method from the Student class and
     * prints all information on the Undergraduate as well.
     *
     * @return String that is specified bellow
     */
    public String toString(){
        return super.toString() + "\nMajor: " + getMajor() + "\nResidence: " + isResidence()
                + "\nTuition: $" + String.format("%.2f",calculateTuition());
    }


}
