package com.saving.zion.fishonindia.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class FareAndAvailability {
	@Id
	private String id;

	private Integer fare;
	private Integer availableCapacity;
	private Integer maxCapacity;
	private Date avlDate;

	public Date getAvlDate() {
		return avlDate;
	}

	public void setAvlDate(Date avlDate) {
		this.avlDate = avlDate;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public Integer getAvailableCapacity() {
		return availableCapacity;
	}

	public void setAvailableCapacity(Integer availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

}
