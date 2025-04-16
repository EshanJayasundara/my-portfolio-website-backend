package org.ej.apps.dto;

public class FormDTO {
    private String senderName;
    private String senderMail;
    private String senderWorkplace;
    private String senderPosition;
    private String content;

    // Default constructor (required for JSON deserialization)
    public FormDTO() {}

    // All-args constructor
    public FormDTO(String senderName,
                   String senderMail,
                   String senderWorkplace,
                   String senderPosition,
                   String content) {
        this.senderName = senderName;
        this.senderMail = senderMail;
        this.senderWorkplace = senderWorkplace;
        this.senderPosition = senderPosition;
        this.content = content;
    }

    // Getters and Setters (using camelCase for Java conventions)
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getSenderWorkplace() {
        return senderWorkplace;
    }

    public void setSenderWorkplace(String senderWorkplace) {
        this.senderWorkplace = senderWorkplace;
    }

    public String getSenderPosition() {
        return senderPosition;
    }

    public void setSenderPosition(String senderPosition) {
        this.senderPosition = senderPosition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}