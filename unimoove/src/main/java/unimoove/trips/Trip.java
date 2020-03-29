package unimoove.trips;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String departurePlace;
	private String arrivalPlace;
	private OffsetDateTime departureDateTime;
	private Integer numberAvailableSeats;
	private BigDecimal price;
	
	public Trip() {
	}

	public Trip(String departurePlace, String arrivalPlace, OffsetDateTime departureDateTime,
			Integer numberAvailableSeats, BigDecimal price) {
		this.departurePlace = departurePlace;
		this.arrivalPlace = arrivalPlace;
		this.departureDateTime = departureDateTime;
		this.numberAvailableSeats = numberAvailableSeats;
		this.price = price;
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
	
}
