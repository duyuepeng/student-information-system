package example.org.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import example.org.model.request.BasicCourse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Course
 */
@DynamoDBTable(tableName = "Course")
public class Course extends BasicCourse implements PrimaryKey<Long, Course> {
    private Long courseId = null;

    private List<Long> roster = null;

    public void setBasicCourse(BasicCourse basicCourse) {
        this.name(basicCourse.getName())
                .board(basicCourse.getBoard())
                .location(basicCourse.getLocation())
                .startTime(basicCourse.getStartTime())
                .endTime(basicCourse.getEndTime())
                .weekday(basicCourse.getWeekday())
                .professor(basicCourse.getProfessor())
                .ta(basicCourse.getTa())
                .program(basicCourse.getProgram());
    }

    public Course courseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    @Override
    public void changePk(Long obj) {
        this.setCourseId(obj);
    }

    @Override
    public Long retrievePk() {
        return this.getCourseId();
    }

    @Override
    public Course pk(Long obj) {
        return this.courseId(obj);
    }

    /**
     * Get courseId
     *
     * @return courseId
     **/
    @DynamoDBHashKey(attributeName = "courseId")
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Course name(String name) {
        this.setName(name);
        return this;
    }


    public Course board(String board) {
        this.setBoard(board);
        return this;
    }


    public Course location(String location) {
        this.setLocation(location);
        return this;
    }


    public Course startTime(Date startTime) {
        this.setStartTime(startTime);
        return this;
    }


    public Course endTime(Date endTime) {
        this.setEndTime(endTime);
        return this;
    }


    public Course weekday(Integer weekday) {
        this.setWeekday(weekday);
        return this;
    }


    public Course roster(List<Long> roster) {
        this.roster = roster;
        return this;
    }

    public Course addRosterItem(Long rosterItem) {
        if (this.roster == null) {
            this.roster = new ArrayList<>();
        }
        this.roster.add(rosterItem);
        return this;
    }

    /**
     * Get roster
     *
     * @return roster
     **/
    @DynamoDBAttribute(attributeName = "roster")
    public List<Long> getRoster() {
        return roster;
    }

    public void setRoster(List<Long> roster) {
        this.roster = roster;
    }

    public Course professor(Long professor) {
        this.setProfessor(professor);
        return this;
    }


    public Course ta(Long ta) {
        this.setTa(ta);
        return this;
    }

    public Course program(Long programId) {
        this.setProgram(programId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        if (!super.equals(o)) return false;
        Course course = (Course) o;
        return Objects.equals(getCourseId(), course.getCourseId()) &&
                Objects.equals(getRoster(), course.getRoster());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCourseId(), getRoster());
    }

    @Override
    public String toString() {

        return "class Course {\n" +
                "    courseId: " + toIndentedString(courseId) + "\n" +
                "    name: " + toIndentedString(getName()) + "\n" +
                "    board: " + toIndentedString(getBoard()) + "\n" +
                "    location: " + toIndentedString(getLocation()) + "\n" +
                "    startTime: " + toIndentedString(getStartTime()) + "\n" +
                "    endTime: " + toIndentedString(getEndTime()) + "\n" +
                "    weekday: " + toIndentedString(getWeekday()) + "\n" +
                "    roster: " + toIndentedString(roster) + "\n" +
                "    professor: " + toIndentedString(getProfessor()) + "\n" +
                "    ta: " + toIndentedString(getTa()) + "\n" +
                "    program: " + toIndentedString(getProgram()) + "\n" +
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
