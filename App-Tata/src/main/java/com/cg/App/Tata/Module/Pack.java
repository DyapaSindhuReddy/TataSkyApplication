package com.cg.App.Tata.Module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pack {
	@Id
	private long id;
	
    private double cost;
    private int daysValidity;
    private String description;
    private String planName;
    private List<String> channels;
    
    @OneToMany(mappedBy="currentPack",cascade = CascadeType.ALL)
    private List<Account> account;
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getDaysValidity() {
		return daysValidity;
	}
	public void setDaysValidity(int daysValidity) {
		this.daysValidity = daysValidity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public List<String> getChannels() {
		return channels;
	}
	public void setChannels(List<String> channels) {
		this.channels = channels;
	}
	
	
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Pack [id=" + id + ", cost=" + cost + ", daysValidity=" + daysValidity + ", description=" + description
				+ ", planName=" + planName + "]";
	}
    
    
    
    

}
