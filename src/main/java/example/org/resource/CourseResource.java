package example.org.resource;

import example.org.model.Course;
import example.org.model.request.StudentId;
import example.org.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("courses")
public class CourseResource {

    CourseService courseService = new CourseService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Course addCourse(Course course) {
        return courseService.add(course);
    }

    @DELETE
    @Path("/{courseId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Course deleteCourse(@PathParam("courseId") Long courseId) {
        return courseService.delete(courseId);
    }

    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course getCourse(@PathParam("courseId") Long courseId) {
        return courseService.get(courseId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(@QueryParam("location") String location, @QueryParam("weekday") Integer weekday) {
        Map<String, String> kwargs = new HashMap<>();
        kwargs.put("location", location);
        if (weekday != null)
            kwargs.put("weekday", weekday.toString());
        return courseService.getList(kwargs);
    }

    @PUT
    @Path("/{courseId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Course updateCourse(@PathParam("courseId") Long courseId, Course course) {
        return courseService.update(course, courseId);
    }


    @POST
    @Path("/{courseId}/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Course registerCourse(StudentId studentId, @PathParam("courseId") Long courseId) {
        return courseService.register(courseId, studentId.getStudentId());
    }
}
