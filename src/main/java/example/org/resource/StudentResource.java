package example.org.resource;

import example.org.model.Student;
import example.org.model.request.BasicStudent;
import example.org.model.request.CourseId;
import example.org.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("students")
public class StudentResource {

    StudentService studentService = new StudentService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student addStudent(BasicStudent student) {
        return studentService.add(student);
    }

    @DELETE
    @Path("/{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student deleteStudent(@PathParam("studentId") Long studentId) {
        return studentService.delete(studentId);
    }

    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("studentId") Long studentId) {
        return studentService.get(studentId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents(@QueryParam("program") Long program) {
        Map<String, String> kwargs = new HashMap<>();
        if (program != null)
            kwargs.put("program", program.toString());
        return studentService.getList(kwargs);
    }

    @PUT
    @Path("/{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(@PathParam("studentId") Long studentId, BasicStudent student) {
        return studentService.update(student, studentId);
    }

    @POST
    @Path("/{studentId}/drop")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student dropCourse(@PathParam("studentId") Long studentId, CourseId courseId) {
        return studentService.drop(studentId, courseId.getCourseId());
    }
}
