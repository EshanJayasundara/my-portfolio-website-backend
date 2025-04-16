package org.ej.apps.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ej.apps.dto.Error;
import org.ej.apps.model.Form;
import org.ej.apps.dto.FormDTO;
import org.ej.apps.repository.FormRepository;

import java.net.URI;
import java.util.Optional;

@Path("/form")
@ApplicationScoped
public class FormResource {

    @Inject
    FormRepository formRepository;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "FINALLY WORKING!";
    }

//    @GET
//    @Path("/{form_id}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getForm(@PathParam("form_id") long id) {
//        Optional<Form> form;
//        try {
//            form = formRepository.getForm(id);
//            return form.isPresent() ? form.get().getSender_name() + ":\n" + form.get().getContent(): "No form found for id:" + form.get().getForm_id() + "!";
//        } catch(Exception e) {
//            return "No form found for id:" + id;
//        }
//    }

    @GET
    @Path("/{form_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForm(@PathParam("form_id") long id) {
        try {
            Optional<Form> optionalForm = Optional.ofNullable(formRepository.getForm(id));
            if (optionalForm.isPresent()) {
                Form form = optionalForm.get();
                return Response.ok(form).build(); // 200 OK
            } else {
                Error error = new Error("Form with id " + id + " not found.");
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(error)
                        .build(); // 404 Not Found
            }
        } catch(Exception e) {
            Error error = new Error("An error occurred while retrieving the form: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(error)
                    .build();
        }
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createForm(FormDTO formDTO) {
        Form form = formRepository.createForm(formDTO);
        return Response.created(URI.create("/form/" + form.getForm_id()))
                .entity(form)
                .build();
    }

}