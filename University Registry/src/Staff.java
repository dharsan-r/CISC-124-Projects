/**
 * Staff abstract sub class of Person parent class which is extended. Contains all information from
 * Person parent class plus information on staff id, years worked, and their department name (an enumerated type).
 * Invokes super method to construct a Person.
 */
public abstract class Staff extends Person{
    private int staffId;
    private int numYears;
    private DepartmentType departmentName; // From the DepartmentType enumerator


    /**
     * Constructor for a Staff member Invokes super method to construct a Person
     *
     * @param firstName The string first name of a person
     * @param lastName The string last name of a person
     * @param age The integer age of person
     * @param staffId The integer staff id for a staff member
     * @param numYears The integer number of years a staff member has worked
     * @param departmentName The departmentName enum for department the staff member is working in
     * @throws HRException if any illegal values outlined in assignment are entered
     */
    public Staff(String firstName, String lastName, int age, int staffId, int numYears, DepartmentType departmentName)
            throws HRException {
        super(firstName, lastName, age);
        setStaffId(staffId);
        setNumYears(numYears);
        setDepartmentName(departmentName);
    }

    /**
     * Abstract method that must be implemented in subclasses to calculate a staff members pay
     *
     * @return a double implemented in sub classes
     */
    public abstract double calculatePay();

    /**
     * Getter method for staff id
     *
     * @return staffId the private integer staff id of a staff member
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * Setter method for staff id
     *
     * @param staffId integer for a staff members id
     */
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    /**
     * Getter method for num years worked
     *
     * @return integer for number of years a staff member has worked
     */
    public int getNumYears() {
        return numYears;
    }

    /**
     * Setter method for number of years a staff member has worked
     *
     * @param numYears integer for number of years a staff member has worked
     * @throws HRException if a person has worked less than or 0 years or >= 40 years an error is thrown
     */
    public void setNumYears(int numYears) throws HRException{
        if(numYears>0 && numYears<40){
            this.numYears = numYears;
        }else {
            throw new HRException("Invalid Years Worked!");
        }
    }

    /**
     * Getter for the department a staff works in
     *
     * @return departmentName an enum value for the department name
     */
    public DepartmentType getDepartmentName() {
        return departmentName;
    }

    /**
     * Setter for the department a staff works in
     *
     * @param departmentName an enum value for the department name
     */
    public void setDepartmentName(DepartmentType departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Calls the super class to print all the information from the toString method from the Person class and
     * prints all information on the staff member as well.
     *
     * @return String that is specified bellow
     */
    public String toString(){
        return super.toString() +"\n\nStaff ID: " + getStaffId() + "\nYears Worked: " +getNumYears()
                +"\nDepartment Name: " + getDepartmentName();
    }

}
