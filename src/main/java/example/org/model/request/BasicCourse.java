package example.org.model.request;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;
import java.util.Objects;

@DynamoDBTable(tableName = "Course")
public class BasicCourse {
    private String name = null;

    private String board = null;

    private String location = null;

    private Date startTime = null;

    private Date endTime = null;

    private Integer weekday = null;

    private Long professor = null;

    private Long ta = null;

    private Long program = null;


    public BasicCourse name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasicCourse board(String board) {
        this.board = board;
        return this;
    }

    /**
     * Get board
     *
     * @return board
     **/
    @DynamoDBAttribute(attributeName = "board")
    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public BasicCourse location(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get location
     *
     * @return location
     **/

    @DynamoDBAttribute(attributeName = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BasicCourse startTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get startTime
     *
     * @return startTime
     **/
    @DynamoDBAttribute(attributeName = "startTime")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public BasicCourse endTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get endTime
     *
     * @return endTime
     **/

    @DynamoDBAttribute(attributeName = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BasicCourse weekday(Integer weekday) {
        this.weekday = weekday;
        return this;
    }

    /**
     * Get weekday
     *
     * @return weekday
     **/

    @DynamoDBAttribute(attributeName = "weekday")
    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }


    public BasicCourse professor(Long professor) {
        this.professor = professor;
        return this;
    }

    /**
     * Get professor
     *
     * @return professor
     **/
    @DynamoDBAttribute(attributeName = "professor")
    public Long getProfessor() {
        return professor;
    }

    public void setProfessor(Long professor) {
        this.professor = professor;
    }

    public BasicCourse ta(Long ta) {
        this.ta = ta;
        return this;
    }

    /**
     * Get ta
     *
     * @return ta
     **/
    @DynamoDBAttribute(attributeName = "ta")
    public Long getTa() {
        return ta;
    }

    public void setTa(Long ta) {
        this.ta = ta;
    }


    public BasicCourse program(Long programId) {
        this.program = programId;
        return this;
    }

    /**
     * Get program
     *
     * @return program
     **/
    @DynamoDBAttribute(attributeName = "program")
    public Long getProgram() {
        return program;
    }

    public void setProgram(Long program) {
        this.program = program;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicCourse)) return false;
        BasicCourse that = (BasicCourse) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getBoard(), that.getBoard()) &&
                Objects.equals(getLocation(), that.getLocation()) &&
                Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getEndTime(), that.getEndTime()) &&
                Objects.equals(getWeekday(), that.getWeekday()) &&
                Objects.equals(getProfessor(), that.getProfessor()) &&
                Objects.equals(getTa(), that.getTa()) &&
                Objects.equals(getProgram(), that.getProgram());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBoard(), getLocation(), getStartTime(), getEndTime(), getWeekday(), getProfessor(), getTa(), getProgram());
    }

    @Override
    public String toString() {

        return "class BasicCourse {\n" +
                "    name: " + toIndentedString(name) + "\n" +
                "    board: " + toIndentedString(board) + "\n" +
                "    location: " + toIndentedString(location) + "\n" +
                "    startTime: " + toIndentedString(startTime) + "\n" +
                "    endTime: " + toIndentedString(endTime) + "\n" +
                "    weekday: " + toIndentedString(weekday) + "\n" +
                "    professor: " + toIndentedString(professor) + "\n" +
                "    ta: " + toIndentedString(ta) + "\n" +
                "    program: " + toIndentedString(program) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
