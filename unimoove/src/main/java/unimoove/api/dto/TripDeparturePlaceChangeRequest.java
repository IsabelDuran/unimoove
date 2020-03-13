package unimoove.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TripDeparturePlaceChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T23:33:47.450+01:00[Europe/Madrid]")
public class TripDeparturePlaceChangeRequest   {
  @JsonProperty("newPlace")
  private String newPlace = null;

  public TripDeparturePlaceChangeRequest newPlace(String newPlace) {
    this.newPlace = newPlace;
    return this;
  }

  /**
   * Get newPlace
   * @return newPlace
  **/
  @ApiModelProperty(example = "CA", required = true, value = "")
      @NotNull

    public String getNewPlace() {
    return newPlace;
  }

  public void setNewPlace(String newPlace) {
    this.newPlace = newPlace;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripDeparturePlaceChangeRequest tripDeparturePlaceChangeRequest = (TripDeparturePlaceChangeRequest) o;
    return Objects.equals(this.newPlace, tripDeparturePlaceChangeRequest.newPlace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newPlace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TripDeparturePlaceChangeRequest {\n");
    
    sb.append("    newPlace: ").append(toIndentedString(newPlace)).append("\n");
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
