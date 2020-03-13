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
 * PlaceNameChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:12:55.470+01:00[Europe/Madrid]")
public class PlaceNameChangeRequest   {
  @JsonProperty("newName")
  private String newName = null;

  public PlaceNameChangeRequest newName(String newName) {
    this.newName = newName;
    return this;
  }

  /**
   * Get newName
   * @return newName
  **/
  @ApiModelProperty(example = "Cadiz", required = true, value = "")
      @NotNull

    public String getNewName() {
    return newName;
  }

  public void setNewName(String newName) {
    this.newName = newName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaceNameChangeRequest placeNameChangeRequest = (PlaceNameChangeRequest) o;
    return Objects.equals(this.newName, placeNameChangeRequest.newName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceNameChangeRequest {\n");
    
    sb.append("    newName: ").append(toIndentedString(newName)).append("\n");
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
