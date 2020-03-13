package unimoove.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TripReservationResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:29:59.978+01:00[Europe/Madrid]")
public class TripReservationResponse   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("departurePlace")
  private String departurePlace = null;

  @JsonProperty("arrivalPlace")
  private String arrivalPlace = null;

  @JsonProperty("departureDateTime")
  private OffsetDateTime departureDateTime = null;

  /**
   * Gets or Sets state
   */
  public enum StateEnum {
    AVALIBLE("Avalible"),
    
    FULL("Full"),
    
    CANCELLED("Cancelled"),
    
    PAST("Past");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String text) {
      for (StateEnum b : StateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("state")
  private StateEnum state = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  public TripReservationResponse id(Integer id) {
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

  public TripReservationResponse departurePlace(String departurePlace) {
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

  public TripReservationResponse arrivalPlace(String arrivalPlace) {
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

  public TripReservationResponse departureDateTime(OffsetDateTime departureDateTime) {
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

  public TripReservationResponse state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public TripReservationResponse price(BigDecimal price) {
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
    TripReservationResponse tripReservationResponse = (TripReservationResponse) o;
    return Objects.equals(this.id, tripReservationResponse.id) &&
        Objects.equals(this.departurePlace, tripReservationResponse.departurePlace) &&
        Objects.equals(this.arrivalPlace, tripReservationResponse.arrivalPlace) &&
        Objects.equals(this.departureDateTime, tripReservationResponse.departureDateTime) &&
        Objects.equals(this.state, tripReservationResponse.state) &&
        Objects.equals(this.price, tripReservationResponse.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, departurePlace, arrivalPlace, departureDateTime, state, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TripReservationResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    departurePlace: ").append(toIndentedString(departurePlace)).append("\n");
    sb.append("    arrivalPlace: ").append(toIndentedString(arrivalPlace)).append("\n");
    sb.append("    departureDateTime: ").append(toIndentedString(departureDateTime)).append("\n");
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
