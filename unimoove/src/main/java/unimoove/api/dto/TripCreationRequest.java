package unimoove.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TripCreationRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T23:33:47.450+01:00[Europe/Madrid]")
public class TripCreationRequest   {
  @JsonProperty("departurePlace")
  private String departurePlace = null;

  @JsonProperty("arrivalPlace")
  private String arrivalPlace = null;

  @JsonProperty("departureDateTime")
  private OffsetDateTime departureDateTime = null;

  @JsonProperty("numberAvailableSeats")
  private Integer numberAvailableSeats = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  public TripCreationRequest departurePlace(String departurePlace) {
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

  public TripCreationRequest arrivalPlace(String arrivalPlace) {
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

  public TripCreationRequest departureDateTime(OffsetDateTime departureDateTime) {
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

  public TripCreationRequest numberAvailableSeats(Integer numberAvailableSeats) {
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

  public TripCreationRequest price(BigDecimal price) {
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
    TripCreationRequest tripCreationRequest = (TripCreationRequest) o;
    return Objects.equals(this.departurePlace, tripCreationRequest.departurePlace) &&
        Objects.equals(this.arrivalPlace, tripCreationRequest.arrivalPlace) &&
        Objects.equals(this.departureDateTime, tripCreationRequest.departureDateTime) &&
        Objects.equals(this.numberAvailableSeats, tripCreationRequest.numberAvailableSeats) &&
        Objects.equals(this.price, tripCreationRequest.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(departurePlace, arrivalPlace, departureDateTime, numberAvailableSeats, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TripCreationRequest {\n");
    
    sb.append("    departurePlace: ").append(toIndentedString(departurePlace)).append("\n");
    sb.append("    arrivalPlace: ").append(toIndentedString(arrivalPlace)).append("\n");
    sb.append("    departureDateTime: ").append(toIndentedString(departureDateTime)).append("\n");
    sb.append("    numberAvailableSeats: ").append(toIndentedString(numberAvailableSeats)).append("\n");
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
