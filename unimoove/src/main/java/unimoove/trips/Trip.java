package unimoove.trips;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import unimoove.reservations.Reservation;
import unimoove.users.User;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String departurePlace;
	private String arrivalPlace;
	private OffsetDateTime departureDateTime;
	private Integer numberAvailableSeats;
	private BigDecimal price;
	/*
	 * 0 for available, 1 for full, 2 for cancelled, 3 for past
	 * */
	private Integer state = 0;
	
	@ManyToOne
	private User user;
	
	@OneToMany
	private Set<Reservation> reservations;
	
	public Trip() {
	}

	public Trip(String departurePlace, String arrivalPlace, OffsetDateTime departureDateTime,
			Integer numberAvailableSeats, BigDecimal price, Integer state, User user) {
		super();
		this.departurePlace = departurePlace;
		this.arrivalPlace = arrivalPlace;
		this.departureDateTime = departureDateTime;
		this.numberAvailableSeats = numberAvailableSeats;
		this.price = price;
		this.state = state;
		this.user = user;
	}



	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getArrivalPlace() {
		return arrivalPlace;
	}

	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}

	public OffsetDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(OffsetDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public Integer getNumberAvailableSeats() {
		return numberAvailableSeats;
	}

	public void setNumberAvailableSeats(Integer numberAvailableSeats) {
		this.numberAvailableSeats = numberAvailableSeats;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
