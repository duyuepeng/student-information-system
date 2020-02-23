package example.org.resource;

import example.org.model.Lecture;
import example.org.service.LectureService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("lectures")
public class LectureResource {

    LectureService lectureService = new LectureService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture addLecture(Lecture lecture) {
        return lectureService.add(lecture);
    }

    @DELETE
    @Path("/{lectureId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture deleteLecture(@PathParam("lectureId") Long lectureId) {
        return lectureService.delete(lectureId);
    }

    @GET
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture getLecture(@PathParam("lectureId") Long lectureId) {
        return lectureService.get(lectureId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lecture> getLectures(@QueryParam("course") Long course) {
        Map<String, String> kwargs = new HashMap<>();
        if (course != null)
            kwargs.put("course", course.toString());
        return lectureService.getList(kwargs);
    }

    @PUT
    @Path("/{lectureId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture updateLecture(@PathParam("lectureId") Long lectureId, Lecture lecture) {
        return lectureService.update(lecture, lectureId);
    }
}
