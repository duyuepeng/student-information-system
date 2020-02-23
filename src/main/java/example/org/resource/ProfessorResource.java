package example.org.resource;

import example.org.model.Professor;
import example.org.model.request.BasicProfessor;
import example.org.service.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("professors")
public class ProfessorResource {

    ProfessorService professorService = new ProfessorService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Professor addProfessor(BasicProfessor professor) {
        return professorService.add(professor);
    }

    @DELETE
    @Path("/{professorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Professor deleteProfessor(@PathParam("professorId") Long professorId) {
        return professorService.delete(professorId);
    }

    @GET
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor getProfessor(@PathParam("professorId") Long professorId) {
        return professorService.get(professorId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getProfessors(@QueryParam("department") String department) {
        Map<String, String> kwargs = new HashMap<>();
        kwargs.put("department", department);
        return professorService.getList(kwargs);
    }

    @PUT
    @Path("/{professorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Professor updateProfessor(@PathParam("professorId") Long professorId, BasicProfessor professor) {
        return professorService.update(professor, professorId);
    }
}
