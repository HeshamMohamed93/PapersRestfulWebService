/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Restful.service;

import com.Restful.Paper;
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

/**
 *
 * @author hesham
 */
@Stateless
@Path("com.restful.paper")
public class PaperFacadeREST extends AbstractFacade<Paper> {

    @PersistenceContext(unitName = "finalPU")
    private EntityManager em;

    public PaperFacadeREST() {
        super(Paper.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Paper entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Paper entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Paper find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Paper> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Paper> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    
    
    @GET
    @Path("searchPaper/{val}")
    @Produces({"application/json"})
    public List<Paper> searchPaper (@PathParam("val") String value)
    {
        return super.search(value);
    }
    
    @GET
    @Path("viewPapers")
    @Produces(/*{"application/json"}*/MediaType.APPLICATION_JSON)
    public List<Paper> viewPapers1 ()
    {
        return super.viewPapers();
    }
    
    @GET
    @Path("addPaper/{val}/{val1}/{val2}")
    @Produces({"application/json"})
    public void addPaper1 (@PathParam("val") String title  , @PathParam("val1") String content , @PathParam("val2") String links)
    {
        try {
            super.addPaper(title, content , links);
            
        } catch (Exception e) {
        }
         
    }
    
    @GET
    @Path("deletePaper/{val}")
    @Produces(/*{"application/json"}*/MediaType.APPLICATION_JSON)
    public void deletePaper1 (@PathParam("val") int id )
    {
        try {
            super.deletePaper(id);
            
        } catch (Exception e) {
        }
         
    }
    
    @GET
    @Path("updatePaper/{val}/{val1}/{val2}/{val3}")
    @Produces(/*{"application/json"}*/MediaType.APPLICATION_JSON)
    public void updatePaper1 (@PathParam("val") String title  , @PathParam("val1") String content , @PathParam("val2") String link , @PathParam("val3") int id )
    {
        try {
            super.updatePaper(id , title , content , link);
            
        } catch (Exception e) {
        }
         
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
