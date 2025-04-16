package org.ej.apps.model;

import jakarta.persistence.*;

@Entity
@Table(name = "form", schema = "eshandb")
public class Form {

    public Form() {}

    public Form(long form_id,
                String sender_name,
                String sender_mail,
                String sender_workplace,
                String sender_position,
                String content) {
        this.form_id = form_id;
        this.sender_mail = sender_mail;
        this.sender_workplace = sender_workplace;
        this.sender_name = sender_name;
        this.sender_position = sender_position;
        this.content = content;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long form_id;

    @Basic
    @Column(name = "sender_name")
    private String sender_name;

    @Basic
    @Column(name = "sender_mail")
    private String sender_mail;

    @Basic
    @Column(name = "sender_workplace")
    private String sender_workplace;

    @Basic
    @Column(name = "sender_position")
    private String sender_position;

    @Basic
    @Column(name = "content")
    private String content;

    public long getForm_id() {
        return form_id;
    }

    public void setForm_id(long form_id) {
        this.form_id = form_id;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_mail() {
        return sender_mail;
    }

    public void setSender_mail(String sender_mail) {
        this.sender_mail = sender_mail;
    }

    public String getSender_workplace() {
        return sender_workplace;
    }

    public void setSender_workplace(String sender_workplace) {
        this.sender_workplace = sender_workplace;
    }

    public String getSender_position() {
        return sender_position;
    }

    public void setSender_position(String sender_position) {
        this.sender_position = sender_position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}