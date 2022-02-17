/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import entities.SchoolSubject;
import entities.SchoolSubjectId;
import exception.SelectCollectionException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author aitor
 */
@Stateless
@Path("entities.schoolsubject")
public class SchoolSubjectFacadeREST extends AbstractFacade<SchoolSubject> {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    private SchoolSubjectId getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;schoolId=schoolIdValue;subjectId=subjectIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.SchoolSubjectId key = new entities.SchoolSubjectId();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> schoolId = map.get("schoolId");
        if (schoolId != null && !schoolId.isEmpty()) {
            key.setSchoolId(new java.lang.Integer(schoolId.get(0)));
        }
        java.util.List<String> subjectId = map.get("subjectId");
        if (subjectId != null && !subjectId.isEmpty()) {
            key.setSubjectId(new java.lang.Integer(subjectId.get(0)));
        }
        return key;
    }

    public SchoolSubjectFacadeREST() {
        super(SchoolSubject.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(SchoolSubject entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, SchoolSubject entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.SchoolSubjectId key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public SchoolSubject find(@PathParam("id") PathSegment id) {
        entities.SchoolSubjectId key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SchoolSubject> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SchoolSubject> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    
    @GET
    @Path("nombre/{nombre}")
    @Produces({MediaType.APPLICATION_XML})
    public List<SchoolSubject> VisualizarAsignaturas(@PathParam("nombre") String nombre) throws SelectCollectionException {
        List<SchoolSubject> resultado;
        try{
            resultado = em.createNamedQuery("VisualizarAsignaturas")
                    .setParameter("nombre", nombre)
                    .getResultList();
        }catch(Exception e){
            throw new SelectCollectionException(e.getMessage());
        }
        return resultado;
    }
    

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
