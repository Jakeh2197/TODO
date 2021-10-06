package com.jakehcodes.todo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="item")
public class TodoItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="status")
	private String status;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="priority")
	private int priority;
	
	@Column(name="severity")
	private String severity;
	
	@Column(name="due_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dueDate;
	
	@Column(name="date_created")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateCreated;
	
	@Column(name="date_updated")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateUpdated;

	public TodoItem(String status, String title, String content, int priority, String severity, Date dueDate,
			Date dateCreated, Date dateUpdated) {
		this.status = status;
		this.title = title;
		this.content = content;
		this.priority = priority;
		this.severity = severity;
		this.dueDate = dueDate;
		this.dateCreated = dateUpdated;
		this.dateUpdated = dateUpdated;
	}

	public TodoItem() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", status=" + status + ", title=" + title + ", content=" + content + ", priority="
				+ priority + ", severity=" + severity + ", dueDate=" + dueDate + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + "]";
	}

}
