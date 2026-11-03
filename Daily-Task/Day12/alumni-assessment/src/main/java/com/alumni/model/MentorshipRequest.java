
package com.alumni.model;

public class MentorshipRequest {

    private String requestId;
    private String studentId;
    private String alumniId;
    private String topic;
    private String status;

    public MentorshipRequest(String requestId, String studentId,
                             String alumniId, String topic) {

        this.requestId = requestId;
        this.studentId = studentId;
        this.alumniId = alumniId;
        this.topic = topic;
        this.status = "PENDING";
    }

    public String getRequestId() {
        return requestId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAlumniId() {
        return alumniId;
    }

    public String getTopic() {
        return topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request ID: " + requestId
                + " | Student: " + studentId
                + " | Alumni: " + alumniId
                + " | Topic: " + topic
                + " | Status: " + status;
    }
}
