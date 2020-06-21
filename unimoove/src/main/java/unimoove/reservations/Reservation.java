package unimoove.reservations;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import unimoove.trips.Trip;
import unimoove.users.User;

@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private OffsetDateTime dateTimeReservation;
	/**
	 * 0 for pending, 1 for accepted, 2 for denied, 3 for cancelled, 4 for past
	 */
	private Integer status;

	@ManyToOne
	private Trip trip;

	@ManyToOne
	private User user;

	public Reservation(OffsetDateTime dateTimeReservation, Integer status, Trip trip) {
		super();
		this.dateTimeReservation = dateTimeReservation;
		this.status = status;
		this.trip = trip;
	}

	public Reservation() {

	}

	public OffsetDateTime getDateTimeReservation() {
		return dateTimeReservation;
	}

	public void setDateTimeReservation(OffsetDateTime dateTimeReservation) {
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
