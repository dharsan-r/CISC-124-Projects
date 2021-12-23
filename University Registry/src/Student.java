/**
 * Student abstract sub class of Person parent class which is extended. Contains all information from
 * Person parent class plus information on student id, years of study, number of courses, scholarship amount,
 * and their domestic or international status.
 * Invokes super method to construct a Person.
 */
public abstract class Student extends Person{
    private int studentID;
    private int studyYear;
    private int courseNum;
    private double scholarship;
    private boolean domestic;

    /**
     * Constructor for a student Invokes super method to construct a Person
     *
     * @param firstName The string first name of a person
     * @param lastName The string last name of a person
     * @param age The integer age of person
     * @param studentID the integer student id of a student
     * @param studyYear the integer year of study for a student
     * @param courseNum the integer number of courses a student is taking
     * @param scholarship the double scholarship amount a student has
     * @param domestic a boolean true if a student is domestic and false if international
     * @throws HRException if any illegal values outlined in assignment are entered
     */
    public Student(String firstName, String lastName, int age, int studentID, int studyYear,
                   int courseNum, double scholarship, boolean domestic) throws HRException {
        super(firstName, lastName, age);
        setStudentID(studentID);
        setStudyYear(studyYear);
        setCourseNum(courseNum);
        setScholarship(scholarship);
        setDomestic(domestic);
    }

    /**
     * Abstract method that must be implemented in subclasses to calculate a student's tuition
     *
     * @return a double implemented in sub classes
     */
    public abstract double calculateTuition();

    /**
     * Getter method for a students student id
     *
     * @return studentID the integer student id of a student
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Setter method for a students student id
     *
     * @param studentID the integer student id of a student
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Getter method for a students study year
     *
     * @return studyYear the integer year of study for a student
     */
    public int getStudyYear() {
        return studyYear;
    }

    /**
     * Setter method for a students study year
     *
     * @param studyYear the integer year of study for a student
     * @throws HRException if a students study year is <=0 or >10 years
     */
    public void setStudyYear(int studyYear) throws HRException{
        if(studyYear>0 && studyYear<=10){
            this.studyYear = studyYear;
        }else {
            throw new HRException("Invalid Year of Study");
        }

    }

    /**
     * Getter method for a students number of courses
     *
     * @return courseNum the integer number of courses a student is taking
     */
    public int getCourseNum() {
        return courseNum;
    }

    /**
     * Setter method for a students number of courses
     *
     * @param courseNum the integer number of courses a student is taking
     * @throws HRException if a student is taking less than 1 course if a student is taking more than 5 courses
     */
    public void setCourseNum(int courseNum) throws HRException{
        if(courseNum>0 && courseNum<6){
            this.courseNum = courseNum;
        }else{
            throw new HRException("Invalid Course Number!");
        }
    }

    /**
     * Getter method for a students scholarship amount
     *
     * @return scholarship the double scholarship amount a student has
     */
    public double getScholarship() {
        return scholarship;
    }

    /**
     * Setter method for a students scholarship amount
     *
     * @param scholarship the double scholarship amount a student has
     * @throws HRException if a students scholarship is less than 60,000 or greater than 120,000
     */
    public void setScholarship(double scholarship) throws HRException{
        if(scholarship>60000 && scholarship<120000){
            this.scholarship = scholarship;
        }else {
            throw new HRException("Invalid Scholarship Amount!");
        }

    }

    /**
     * Getter method for a students domestic status
     *
     * @return domestic a boolean true if a student is domestic and false if international
     */
    public boolean isDomestic() {
        return domestic;
    }

    /**
     * Setter method for a students domestic status
     *
     * @param domestic a boolean true if a student is domestic and false if international
     */
    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }

    /**
     * Calls the super class to print all the information from the toString method from the Person class and
     * prints all information on the student as well.
     *
     * @return String that is specified bellow
     */
    public String toString(){
        return super.toString() + "\n\nStudent ID: " + getStudentID() + "\nYear of Study: " +getStudyYear()
                + "\nNumber of Courses: " + getCourseNum() + "\nScholarship: $" + String.format("%.2f",getScholarship())
                +"\nDomestic Student: " + isDomestic();
    }
}
