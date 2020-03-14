package unimoove.api.trips;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TripDepartureDateTimeChangeRequest
 */
@Validated

public class TripDepartureDateTimeChangeRequest   {
  @JsonProperty("newDepartureDateTime")
  private OffsetDateTime newDepartureDateTime = null;

  public TripDepartureDateTimeChangeRequest newDepartureDateTime(OffsetDateTime newDepartureDateTime) {
    this.newDepartureDateTime = newDepartureDateTime;
    return this;
  }

  /**
   * Get newDepartureDateTime
   * @return newDepartureDateTime
  **/
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", required = true, value = "")
      @NotNull

    @Valid
    public OffsetDateTime getNewDepartureDateTime() {
    return newDepartureDateTime;
  }

  public void setNewDepartureDateTime(OffsetDateTime newDepartureDateTime) {
    this.newDepartureDateTime = newDepartureDateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripDepartureDateTimeChangeRequest tripDepartureDateTimeChangeRequest = (TripDepartureDateTimeChangeRequest) o;
    return Objects.equals(this.newDepartureDateTime, tripDepartureDateTimeChangeRequest.newDepartureDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newDepartureDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TripDepartureDateTimeChangeRequest {\n");
    
    sb.append("    newDepartureDateTime: ").append(toIndentedString(newDepartureDateTime)).append("\n");
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
