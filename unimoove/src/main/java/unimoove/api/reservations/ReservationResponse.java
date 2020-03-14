package unimoove.api.reservations;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import unimoove.api.trips.TripReservationResponse;

import java.time.OffsetDateTime;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationResponse
 */
@Validated

public class ReservationResponse   {
  @JsonProperty("reservationId")
  private Integer reservationId = null;

  @JsonProperty("trip")
  private TripReservationResponse trip = null;

  @JsonProperty("dateTimeReservation")
  private OffsetDateTime dateTimeReservation = null;

  @JsonProperty("status")
  private Integer status = null;

  public ReservationResponse reservationId(Integer reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * Get reservationId
   * @return reservationId
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
      @NotNull

    public Integer getReservationId() {
    return reservationId;
  }

  public void setReservationId(Integer reservationId) {
    this.reservationId = reservationId;
  }

  public ReservationResponse trip(TripReservationResponse trip) {
    this.trip = trip;
    return this;
  }

  /**
   * Get trip
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationResponse reservationResponse = (ReservationResponse) o;
    return Objects.equals(this.reservationId, reservationResponse.reservationId) &&
        Objects.equals(this.trip, reservationResponse.trip) &&
        Objects.equals(this.dateTimeReservation, reservationResponse.dateTimeReservation) &&
        Objects.equals(this.status, reservationResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservationId, trip, dateTimeReservation, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationResponse {\n");
    
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    trip: ").append(toIndentedString(trip)).append("\n");
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
