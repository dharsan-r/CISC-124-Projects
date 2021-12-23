/**
 * Graduate sub class of Student parent class which is extended. Contains all information from
 * Student parent class plus information on their program(an enumerated type), and research funding.
 * Invokes super method to construct a Staff member.
 */
public class Graduate extends Student{
    private double funding;
    private Program studentType;


    /**
     * Constructor for a Graduate Invokes super method to construct a Student
     *
     * @param firstName The string first name of a person
     * @param lastName The string last name of a person
     * @param age The integer age of person
     * @param studentID the integer student id of a student
     * @param studyYear the integer year of study for a student
     * @param courseNum the integer number of courses a student is taking
     * @param scholarship the double scholarship amount a student has
     * @param domestic a boolean true if a student is domestic and false if international
     * @param funding a double for the amount of research funding a graduate will receive
     * @param studentType The enum for the program the Graduate is in
     * @throws HRException HRException if any illegal values outlined in assignment are entered
     */
    public Graduate(String firstName, String lastName, int age, int studentID, int studyYear, int courseNum,
                    double scholarship, boolean domestic, double funding, Program studentType) throws HRException {
        super(firstName, lastName, age, studentID, studyYear, courseNum, scholarship, domestic);
        setFunding(funding);
        setStudentType(studentType);
    }

    /**
     * Getter method for a graduates research funding
     *
     * @return funding a double for the amount of research funding a graduate will receive
     */
    public double getFunding() {
        return funding;
    }

    /**
     * Setter method for a graduates research funding
     *
     * @param funding a double for the amount of research funding a graduate will receive
     * @throws HRException if a students funding is less than or equal to 1000 dollars
     */
    public void setFunding(double funding) throws HRException {
        if(funding>1000){
            this.funding = funding;
        }else {
            throw new HRException("Invalid Funding Amount!");
        }
    }

    /**
     * Implements the abstract method from the Student class and calculates a Graduate's tuition
     *
     * @return a double for a students tuition based on domestic status outlined in assignment (scholarship and grants are subtracted)
     */
    public double calculateTuition(){
        if(isDomestic()){
            return 5603.65-getFunding()-getScholarship();
        }else {
            return 8426.27-getFunding()-getScholarship();
        }
    }

    /**
     * Getter method for a graduates program type
     *
     * @return studentType The enum for the program the Graduate is in
     */
    public Program getStudentType() {
        return studentType;
    }

    /**
     * Setter method for a graduates program type
     *
     * @param studentType The enum for the program the Graduate is in
     */
    public void setStudentType(Program studentType) {
        this.studentType = studentType;
    }

    /**
     * Calls the super class to print all the information from the toString method from the Student class and
     * prints all information on the Graduate as well.
     *
     * @return String that is specified bellow
     */
    public String toString(){
        return super.toString() +"\nProgram Type: " + getStudentType() + "\nResearch Funding: $" +
                String.format("%.2f",getFunding())  + "\nTuition: $" + String.format("%.2f", calculateTuition());
    }

}
