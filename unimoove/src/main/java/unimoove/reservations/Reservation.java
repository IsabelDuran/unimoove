package unimoove.reservations;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import unimoove.trips.Trip;
import unimoove.users.User;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime dateTimeReservation;
	/**
	 * 0 for pending, 1 for accepted, 2 for denied, 3 for cancelled, 4 for past
	 */
	private Integer status;

	@ManyToOne
	private Trip trip;

	@ManyToOne
	private User user;

	public Reservation(LocalDateTime dateTimeReservation, Integer status, Trip trip) {
		super();
		this.dateTimeReservation = dateTimeReservation;
		this.status = status;
		this.trip = trip;
	}

	public Reservation() {

	}

	public LocalDateTime getDateTimeReservation() {
		return dateTimeReservation;
	}

	public void setDateTimeReservation(LocalDateTime dateTimeReservation) {
		this.dateTimeReservation = dateTimeReservation;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

}
