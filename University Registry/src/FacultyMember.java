/**
 * FacultyMember sub class of Staff parent class which is extended. Contains all information from
 * Staff parent class plus information on degree type(an enumerated type).
 * Invokes super method to construct a Staff member.
 */
public class FacultyMember extends Staff{
    private Training degreeType;

    /**
     * Constructor for a FacultyMember Invokes super method to construct a Staff member
     *
     * @param firstName The string first name of a person
     * @param lastName The string last name of a person
     * @param age The integer age of person
     * @param staffId The integer staff id for a staff member
     * @param numYears The integer number of years a staff member has worked
     * @param departmentName The departmentName enum for department the staff member is working in
     * @param degreeType The degree type enum for a faculty's training achieved
     * @throws HRException HRException if any illegal values outlined in assignment are entered
     */
    public FacultyMember(String firstName, String lastName, int age, int staffId, int numYears,
                         DepartmentType departmentName, Training degreeType) throws HRException {
        super(firstName, lastName, age, staffId, numYears, departmentName);
        setDegreeType(degreeType);
    }

    /**
     * Getter for the training a staff  has
     *
     * @return degreeType an enum value for the degree teh faculty member has
     */
    public Training getDegreeType() {
        return degreeType;
    }

    /**
     * Setter for the training a staff has
     * @param degreeType an enum value for the degree the faculty member has
     */
    public void setDegreeType(Training degreeType) {
        this.degreeType = degreeType;
    }

    /**
     * Implements the abstract method from teh Staff class and calculates a faculty members pay
     *
     * @return a double for a FacultyMembers yearly salary based on years worked and training outlined in assignment
     */
    public double calculatePay(){
        if(getNumYears() ==1){
            if(getDegreeType() == Training.BACHELOR) {
                return 56345;
            }else return 62567;
        }else if(getNumYears() ==2){
            if(getDegreeType() == Training.BACHELOR) {
                return 59345;
            }else return 66567;
        }else if(getNumYears() ==3){
            if(getDegreeType() == Training.BACHELOR) {
                return 63345;
            }else return 70567;
        }else if(getNumYears() ==4){
            if(getDegreeType() == Training.BACHELOR) {
                return 66345;
            }else return 74567;
        }else if(getNumYears() ==5){
            if(getDegreeType() == Training.BACHELOR) {
                return 69345;
            }else return 78567;
        }else if(getNumYears() ==6){
            if(getDegreeType() == Training.BACHELOR) {
                return 73345;
            }else return 82567;
        }else if(getNumYears() ==7){
            if(getDegreeType() == Training.BACHELOR) {
                return 76345;
            }else return 87567;
        } else{
            if (getDegreeType()== Training.BACHELOR){
                return 79345;
            }else {
                return 91567;
            }
        }
    }

    /**
     * Calls the super class to print all the information from the toString method from the Staff class and
     * prints all information on the FacultyMember as well.
     *
     * @return String that is specified bellow
     */
    public String toString(){
        return super.toString() +"\nQualifications : " + getDegreeType() + "\nSalary: $" + String.format("%.2f", calculatePay()) ;
    }
}
