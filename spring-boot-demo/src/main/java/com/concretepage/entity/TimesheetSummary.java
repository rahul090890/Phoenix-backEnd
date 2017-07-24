package com.concretepage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timesheetSummary")
public class TimesheetSummary implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6912413407090547119L;
	
	public TimesheetSummary() {}
	
	@EmbeddedId
	private TimesheetSummaryId id;
	
	
	public TimesheetSummaryId getId() {
		return id;
	}

	public void setId(TimesheetSummaryId id) {
		this.id = id;
	}
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
		
	@Column(name = "totalhours")
	private Float totalHours;
	
	@Column(name = "timesheetStatus")
	private String timesheetStatus;
	
	@Column(name = "createdDate")
	private Date createdDate;

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Float getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Float totalHours) {
		this.totalHours = totalHours;
	}

	public String getTimesheetStatus() {
		return timesheetStatus;
	}

	public void setTimesheetStatus(String timesheetStatus) {
		this.timesheetStatus = timesheetStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "TimesheetSummary [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", totalHours="
				+ totalHours + ", timesheetStatus=" + timesheetStatus + "]";
	}
	
	
	
}
@Embeddable
class TimesheetSummaryId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7366848450288199887L;
	@Column(name = "employeeId")
	private int employeeId;
	@Column(name = "weekStartDate")
	private String weekStartDate;
	@Column(name = "weekEndDate")
	private String weekEndDate;
	
	public TimesheetSummaryId() {}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(String weekStartDate) {
		this.weekStartDate = weekStartDate;
	}

	public String getWeekEndDate() {
		return weekEndDate;
	}

	public void setWeekEndDate(String weekEndDate) {
		this.weekEndDate = weekEndDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((weekEndDate == null) ? 0 : weekEndDate.hashCode());
		result = prime * result + ((weekStartDate == null) ? 0 : weekStartDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimesheetSummaryId other = (TimesheetSummaryId) obj;
		if (employeeId != other.employeeId)
			return false;
		if (weekEndDate == null) {
			if (other.weekEndDate != null)
				return false;
		} else if (!weekEndDate.equals(other.weekEndDate))
			return false;
		if (weekStartDate == null) {
			if (other.weekStartDate != null)
				return false;
		} else if (!weekStartDate.equals(other.weekStartDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimesheetSummaryId [employeeId=" + employeeId + ", weekStartDate=" + weekStartDate + ", weekEndDate="
				+ weekEndDate + "]";
	}
	
	
}
