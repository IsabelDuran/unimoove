package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * CarCreationRequest
 */
@Validated

public class CarCreationRequest   {
  @JsonProperty("plate")
  private String plate = null;

  @JsonProperty("brand")
  private String brand = null;

  @JsonProperty("model")
  private String model = null;

  @JsonProperty("seats")
  private Integer seats = null;

  public CarCreationRequest plate(String plate) {
    this.plate = plate;
    return this;
  }

  /**
   * Get plate
   * @return plate
  **/
  @ApiModelProperty(example = "9268 BAR", required = true, value = "")
      @NotNull

    public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public CarCreationRequest brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
  **/
  @ApiModelProperty(example = "Fiat", required = true, value = "")
      @NotNull

    public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public CarCreationRequest model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(example = "Marea Weekend", required = true, value = "")
      @NotNull

    public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public CarCreationRequest seats(Integer seats) {
    this.seats = seats;
    return this;
  }

  /**
   * Get seats
   * @return seats
  **/
  @ApiModelProperty(example = "5", required = true, value = "")
      @NotNull

    public Integer getSeats() {
    return seats;
  }

  public void setSeats(Integer seats) {
    this.seats = seats;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarCreationRequest carCreationRequest = (CarCreationRequest) o;
    return Objects.equals(this.plate, carCreationRequest.plate) &&
        Objects.equals(this.brand, carCreationRequest.brand) &&
        Objects.equals(this.model, carCreationRequest.model) &&
        Objects.equals(this.seats, carCreationRequest.seats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plate, brand, model, seats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarCreationRequest {\n");
    
    sb.append("    plate: ").append(toIndentedString(plate)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    seats: ").append(toIndentedString(seats)).append("\n");
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
