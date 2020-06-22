package unimoove.api.reservations;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import unimoove.api.trips.TripReservationResponse;
import unimoove.api.users.UserReservationResponse;
import unimoove.api.users.UserReservationResponse;

import java.time.OffsetDateTime;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationResponse
 */
@Validated

public class ReservationResponse {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("trip")
	private TripReservationResponse trip = null;

	@JsonProperty("user")
	private UserReservationResponse user = null;

	@JsonProperty("dateTimeReservation")
	private OffsetDateTime dateTimeReservation = null;

	@JsonProperty("status")
	private Integer status = null;

	public ReservationResponse id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(example = "1", required = true, value = "")
	@NotNull

	public Long getId() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public ReservationResponse trip(TripReservationResponse trip) {
		this.trip = trip;
		return this;
	}

	/**
	 * Get trip
	 * 
	 * @return trip
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid
	public TripReservationResponse getTrip() {
		return trip;
	}

	public void setTrip(TripReservationResponse trip) {
		this.trip = trip;
	}

	public ReservationResponse dateTimeReservation(OffsetDateTime dateTimeReservation) {
		this.dateTimeReservation = dateTimeReservation;
		return this;
	}

	/**
	 * Get dateTimeReservation
	 * 
	 * @return dateTimeReservation
	 **/
	@ApiModelProperty(example = "2017-07-21T17:32:28Z", required = true, value = "")
	@NotNull

	@Valid
	public OffsetDateTime getDateTimeReservation() {
		return dateTimeReservation;
	}

	public void setDateTimeReservation(OffsetDateTime dateTimeReservation) {
		this.dateTimeReservation = dateTimeReservation;
	}

	public ReservationResponse status(Integer status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(example = "0", required = true, value = "")
	@NotNull

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Get user
	 * 
	 * @return user
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid
	public UserReservationResponse getUser() {
		return user;
	}

	public void setUser(UserReservationResponse user) {
		this.user = user;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReservationResponse reservationResponse = (ReservationResponse) o;
		return Objects.equals(this.id, reservationResponse.id) && Objects.equals(this.trip, reservationResponse.trip)
				&& Objects.equals(this.user, reservationResponse.user)
				&& Objects.equals(this.dateTimeReservation, reservationResponse.dateTimeReservation)
				&& Objects.equals(this.status, reservationResponse.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, trip, user, dateTimeReservation, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReservationResponse {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    trip: ").append(toIndentedString(trip)).append("\n");
		sb.append("    user: ").append(toIndentedString(user)).append("\n");
		sb.append("    dateTimeReservation: ").append(toIndentedString(dateTimeReservation)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
