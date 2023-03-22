package com.spring.todoapp.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="todoData")
public class TodoListData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="task")
	private String task;
	
	@Column(name="time")
	private LocalTime time;
	
	@Column(name="date")
	private LocalDate date;

	public TodoListData(String task, LocalTime time, LocalDate date) {
		this.task = task;
		this.time = time;
		this.date = date;
	}

	public TodoListData() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TodoListData [id=" + id + ", task=" + task + ", time=" + time + ", date=" + date + "]";
	}
	
	
	
}
