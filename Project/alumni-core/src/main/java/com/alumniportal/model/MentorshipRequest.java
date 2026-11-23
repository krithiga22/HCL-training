package com.alumniportal.model;

import com.alumniportal.constants.Constants;

public class MentorshipRequest extends BaseEntity {

    private int requestId;
    private int studentId;
    private int mentorAlumniId;
    private String topic;
    private String status;

    public MentorshipRequest(int requestId, int studentId, int mentorAlumniId, String topic) {
        super((long) requestId);
        this.requestId = requestId;
        this.studentId = studentId;
        this.mentorAlumniId = mentorAlumniId;
        this.topic = topic;
        this.status = Constants.STATUS_PENDING;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getMentorAlumniId() {
        return mentorAlumniId;
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
        return String.format("Request #%d [Student: %d, Mentor: %d, Topic: '%s', Status: %s]",
                requestId, studentId, mentorAlumniId, topic, status);
    }
}
