package unimoove.api.trips;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TripResponse
 */
@Validated

public class TripResponse   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("departurePlace")
  private String departurePlace = null;

  @JsonProperty("arrivalPlace")
  private String arrivalPlace = null;

  @JsonProperty("departureDateTime")
  private OffsetDateTime departureDateTime = null;

  @JsonProperty("numberAvailableSeats")
  private Integer numberAvailableSeats = null;

  @JsonProperty("state")
  private Integer state = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  public TripResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
      @NotNull

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TripResponse departurePlace(String departurePlace) {
    this.departurePlace = departurePlace;
    return this;
  }

  /**
   * Get departurePlace
   * @return departurePlace
  **/
  @ApiModelProperty(example = "CA", required = true, value = "")
      @NotNull

    public String getDeparturePlace() {
    return departurePlace;
  }

  public void setDeparturePlace(String departurePlace) {
    this.departurePlace = departurePlace;
  }

  public TripResponse arrivalPlace(String arrivalPlace) {
    this.arrivalPlace = arrivalPlace;
    return this;
  }

  /**
   * Get arrivalPlace
   * @return arrivalPlace
  **/
  @ApiModelProperty(example = "ESI", required = true, value = "")
      @NotNull

    public String getArrivalPlace() {
    return arrivalPlace;
  }

  public void setArrivalPlace(String arrivalPlace) {
    this.arrivalPlace = arrivalPlace;
  }

  public TripResponse departureDateTime(OffsetDateTime departureDateTime) {
    this.departureDateTime = departureDateTime;
    return this;
  }

  /**
   * Get departureDateTime
   * @return departureDateTime
  **/
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", required = true, value = "")
      @NotNull

    @Valid
    public OffsetDateTime getDepartureDateTime() {
    return departureDateTime;
  }

  public void setDepartureDateTime(OffsetDateTime departureDateTime) {
    this.departureDateTime = departureDateTime;
  }

  public TripResponse numberAvailableSeats(Integer numberAvailableSeats) {
    this.numberAvailableSeats = numberAvailableSeats;
    return this;
  }

  /**
   * Get numberAvailableSeats
   * @return numberAvailableSeats
  **/
  @ApiModelProperty(example = "2", required = true, value = "")
      @NotNull

    public Integer getNumberAvailableSeats() {
    return numberAvailableSeats;
  }

  public void setNumberAvailableSeats(Integer numberAvailableSeats) {
    this.numberAvailableSeats = numberAvailableSeats;
  }

  public TripResponse state(Integer state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(example = "0", required = true, value = "")
      @NotNull

    public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public TripResponse price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(example = "1.0", required = true, value = "")
      @NotNull

    @Valid
    public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripResponse tripResponse = (TripResponse) o;
    return Objects.equals(this.id, tripResponse.id) &&
        Objects.equals(this.departurePlace, tripResponse.departurePlace) &&
        Objects.equals(this.arrivalPlace, tripResponse.arrivalPlace) &&
        Objects.equals(this.departureDateTime, tripResponse.departureDateTime) &&
        Objects.equals(this.numberAvailableSeats, tripResponse.numberAvailableSeats) &&
        Objects.equals(this.state, tripResponse.state) &&
        Objects.equals(this.price, tripResponse.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, departurePlace, arrivalPlace, departureDateTime, numberAvailableSeats, state, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TripResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    departurePlace: ").append(toIndentedString(departurePlace)).append("\n");
    sb.append("    arrivalPlace: ").append(toIndentedString(arrivalPlace)).append("\n");
    sb.append("    departureDateTime: ").append(toIndentedString(departureDateTime)).append("\n");
    sb.append("    numberAvailableSeats: ").append(toIndentedString(numberAvailableSeats)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
