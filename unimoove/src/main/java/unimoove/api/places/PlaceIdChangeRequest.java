package unimoove.api.places;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * PlaceIdChangeRequest
 */
@Validated

public class PlaceIdChangeRequest   {
  @JsonProperty("newPlaceId")
  private String newPlaceId = null;

  public PlaceIdChangeRequest newPlaceId(String newPlaceId) {
    this.newPlaceId = newPlaceId;
    return this;
  }

  /**
   * Get newPlaceId
   * @return newPlaceId
  **/
  @ApiModelProperty(example = "CA", required = true, value = "")
      @NotNull

    public String getNewPlaceId() {
    return newPlaceId;
  }

  public void setNewPlaceId(String newPlaceId) {
    this.newPlaceId = newPlaceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaceIdChangeRequest placeIdChangeRequest = (PlaceIdChangeRequest) o;
    return Objects.equals(this.newPlaceId, placeIdChangeRequest.newPlaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newPlaceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceIdChangeRequest {\n");
    
    sb.append("    newPlaceId: ").append(toIndentedString(newPlaceId)).append("\n");
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
