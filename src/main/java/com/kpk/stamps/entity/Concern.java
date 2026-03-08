package com.kpk.stamps.entity;


import com.kpk.stamps.enums.ConcernStatus;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name="concerns")
public class Concern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String concernNumber;

    private String title;

    private String description;

    private String programName;

    private String initiatorName;

    private String assignedTo;

    private ConcernStatus status;

    private LocalDate raisedDate;

    private LocalDate targetDate;

    private String priority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcernNumber() {
        return concernNumber;
    }

    public void setConcernNumber(String concernNumber) {
        this.concernNumber = concernNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public ConcernStatus getStatus() {
        return status;
    }

    public void setStatus(ConcernStatus status) {
        this.status = status;
    }

    public LocalDate getRaisedDate() {
        return raisedDate;
    }

    public void setRaisedDate(LocalDate raisedDate) {
        this.raisedDate = raisedDate;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
