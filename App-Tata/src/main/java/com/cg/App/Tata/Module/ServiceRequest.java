package com.cg.App.Tata.Module;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ServiceRequest {
	@Id
	private long id;
    private LocalDate requestedDate;
    
    @ManyToOne
    private Account acc;
    
    private String message;
    private boolean statusOpened;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
	}
	public Account getAccount() {
		return acc;
	}
	public void setAccount(Account account) {
		this.acc = account;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatusOpened() {
		return statusOpened;
	}
	public void setStatusOpened(boolean statusOpened) {
		this.statusOpened = statusOpened;
	}
	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", requestedDate=" + requestedDate + ", message=" + message
				+ ", statusOpened=" + statusOpened + "]";
	}

    
    

}
