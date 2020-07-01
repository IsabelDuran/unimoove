package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * CarTripResponse
 */
@Validated

public class CarTripResponse   {
  @JsonProperty("plate")
  private String plate = null;

  @JsonProperty("brand")
  private String brand = null;

  @JsonProperty("model")
  private String model = null;

  public CarTripResponse plate(String plate) {
    this.plate = plate;
    return this;
  }

  /**
   * Get plate
   * @return plate
  **/
  @ApiModelProperty(example = "9268 BAR", value = "")
  
    public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public CarTripResponse brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
  **/
  @ApiModelProperty(example = "Fiat", value = "")
  
    public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public CarTripResponse model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(example = "Marea Weekend", value = "")
  
    public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarTripResponse carResponse = (CarTripResponse) o;
    return Objects.equals(this.plate, carResponse.plate) &&
        Objects.equals(this.brand, carResponse.brand) &&
        Objects.equals(this.model, carResponse.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plate, brand, model);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarTripResponse {\n");
    
    sb.append("    plate: ").append(toIndentedString(plate)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
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
