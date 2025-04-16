package org.ej.apps.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.ej.apps.model.Form;
import org.ej.apps.dto.FormDTO;

@ApplicationScoped
public class FormRepository {

    @Inject
    JPAStreamer jpaStreamer;

    @Inject
    EntityManager entityManager;

//    public Optional<Form> getForm(long form_id) {
//        Form form = entityManager.find(Form.class, form_id);
//        return jpaStreamer.stream(Form.class)
//                .filter(Form$.form_id.equal(form_id))
//                .findFirst();
//    }

    public Form getForm(long form_id) {
        Form form = entityManager.find(Form.class, form_id);
        return form;
    }

    public Form createForm(FormDTO formDTO) {
        Form newForm = new Form();
        newForm.setSender_name(formDTO.getSenderName());
        newForm.setSender_mail(formDTO.getSenderMail());
        newForm.setSender_workplace(formDTO.getSenderWorkplace());
        newForm.setSender_position(formDTO.getSenderPosition());
        newForm.setContent(formDTO.getContent());

        entityManager.persist(newForm);
        return newForm;
    }

}