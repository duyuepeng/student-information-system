package example.org.resource;

import example.org.model.Program;
import example.org.model.request.BasicProgram;
import example.org.service.ProgramService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("programs")
public class ProgramResource {

    ProgramService programService = new ProgramService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Program addProgram(BasicProgram program) {
        return programService.add(program);
    }

    @DELETE
    @Path("/{programId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Program deleteProgram(@PathParam("programId") Long programId) {
        return programService.delete(programId);
    }

    @GET
    @Path("/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Program getProgram(@PathParam("programId") Long programId) {
        return programService.get(programId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Program> getPrograms() {
        Map<String, String> kwargs = new HashMap<>();
        return programService.getList(kwargs);
    }

    @PUT
    @Path("/{programId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Program updateProgram(@PathParam("programId") Long programId, BasicProgram program) {
        return programService.update(program, programId);
    }
}
