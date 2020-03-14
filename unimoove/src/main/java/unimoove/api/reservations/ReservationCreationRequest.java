package unimoove.api.reservations;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * ReservationCreationRequest
 */
@Validated

public class ReservationCreationRequest   {
  @JsonProperty("idTrip")
  private Integer idTrip = null;

  public ReservationCreationRequest idTrip(Integer idTrip) {
    this.idTrip = idTrip;
    return this;
  }

  /**
   * Get idTrip
   * @return idTrip
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
      @NotNull

    public Integer getIdTrip() {
    return idTrip;
  }

  public void setIdTrip(Integer idTrip) {
    this.idTrip = idTrip;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationCreationRequest reservationCreationRequest = (ReservationCreationRequest) o;
    return Objects.equals(this.idTrip, reservationCreationRequest.idTrip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTrip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationCreationRequest {\n");
    
    sb.append("    idTrip: ").append(toIndentedString(idTrip)).append("\n");
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
