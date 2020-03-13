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
 * TripNumberAvailableSeatsChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T23:33:47.450+01:00[Europe/Madrid]")
public class TripNumberAvailableSeatsChangeRequest   {
  @JsonProperty("newNumberAvailableSeats")
  private Integer newNumberAvailableSeats = null;

  public TripNumberAvailableSeatsChangeRequest newNumberAvailableSeats(Integer newNumberAvailableSeats) {
    this.newNumberAvailableSeats = newNumberAvailableSeats;
    return this;
  }

  /**
   * Get newNumberAvailableSeats
   * @return newNumberAvailableSeats
  **/
  @ApiModelProperty(example = "2", required = true, value = "")
      @NotNull

    public Integer getNewNumberAvailableSeats() {
    return newNumberAvailableSeats;
  }

  public void setNewNumberAvailableSeats(Integer newNumberAvailableSeats) {
    this.newNumberAvailableSeats = newNumberAvailableSeats;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripNumberAvailableSeatsChangeRequest tripNumberAvailableSeatsChangeRequest = (TripNumberAvailableSeatsChangeRequest) o;
    return Objects.equals(this.newNumberAvailableSeats, tripNumberAvailableSeatsChangeRequest.newNumberAvailableSeats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newNumberAvailableSeats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TripNumberAvailableSeatsChangeRequest {\n");
    
    sb.append("    newNumberAvailableSeats: ").append(toIndentedString(newNumberAvailableSeats)).append("\n");
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
