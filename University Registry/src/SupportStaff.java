/**
 * SupportStaff sub class of Staff parent class which is extended. Contains all information from
 * Staff parent class plus information on their base pay, and their weekly hours worked.
 * Invokes super method to construct a Staff member.
 */
public class SupportStaff extends Staff{
    private int numHours;
    private double basePayRate;

    /**
     * Constructor for a FacultyMember Invokes super method to construct a Staff member
     *
     * @param firstName The string first name of a person
     * @param lastName The string last name of a person
     * @param age The integer age of person
     * @param staffId The integer staff id for a staff member
     * @param numYears The integer number of years a staff member has worked
     * @param departmentName The departmentName enum for department the staff member is working in
     * @param numHours The integer for the amount of weekly hours a support staff member has worked
     * @param basePayRate The double for the base pay rate of a support staff
     * @throws HRException HRException if any illegal values outlined in assignment are entered
     */
    public SupportStaff(String firstName, String lastName, int age, int staffId, int numYears,
                        DepartmentType departmentName, int numHours, double basePayRate) throws HRException {
        super(firstName, lastName, age, staffId, numYears, departmentName);
        setNumHours(numHours);
        setBasePayRate(basePayRate);
    }


    /**
     * Getter method for the amount of weekly hours worked for a SupportStaff member
     *
     * @return numHours The integer for the amount of weekly hours a support staff member has worked
     */
    public int getNumHours() {
        return numHours;
    }

    /**
     * Setter method for the amount of weekly hours worked for a SupportStaff member
     *
     * @param numHours The integer for the amount of weekly hours a support staff member has worked
     */
    public void setNumHours(int numHours) {
        this.numHours = numHours;
    }

    /**
     * Getter method for the base pay rate for a SupportStaff member
     *
     * @return basePayRate The double for the base pay rate of a support staff
     */
    public double getBasePayRate() {
        return basePayRate;
    }

    /**
     * Setter method for the base pay rate for a SupportStaff member
     *
     * @param basePayRate The double for the base pay rate of a support staff
     * @throws HRException if the base pay rate is less than 15 dollars an hour
     */
    public void setBasePayRate(double basePayRate) throws HRException{
        if(basePayRate>15){
            this.basePayRate = basePayRate;
        }else{
            throw new HRException("Invalid Base Pay Rate!");
        }
    }

    /**
     * Implements the abstract method from the Staff class and calculates a Support Staff members pay
     *
     * @return a double for a SupportStaff's yearly salary based on base pay rate and hours worked multiplied by the weeks in a year
     */
    public double calculatePay(){
        return getBasePayRate()*getNumHours()*52;

    }

    /**
     * Calls the super class to print all the information from the toString method from the Staff class and
     * prints all information on the SupportStaff member's as well.
     *
     * @return String that is specified bellow
     */
    public String toString(){
        return super.toString() +"\nHours Worked: " + getNumHours() +"\nPay Rate: $" +
                String.format("%.2f",getBasePayRate())+ "\nSalary: $" + String.format("%.2f", calculatePay());
    }


}
