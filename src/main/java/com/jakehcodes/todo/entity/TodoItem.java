package com.jakehcodes.todo.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
	
	@Column(name="due_date")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate dueDate;
	
	@Column(name="date_created")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateCreated;
	
	@Column(name="date_updated")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateUpdated;

	public TodoItem(String status, String title, String content, Date dueDate,
			Date dateCreated, Date dateUpdated) {
		this.status = status;
		this.title = title;
		this.content = content;
		this.dueDate = Instant.ofEpochMilli(dueDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		this.dateCreated = Instant.ofEpochMilli(dateCreated.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		this.dateUpdated = Instant.ofEpochMilli(dateUpdated.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
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

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDate dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", status=" + status + ", title=" + title + ", content=" + content
				+ ", dueDate=" + dueDate + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + "]";
	}

}
