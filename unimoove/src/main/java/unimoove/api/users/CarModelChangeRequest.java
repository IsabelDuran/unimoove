package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * CarModelChangeRequest
 */
@Validated

public class CarModelChangeRequest   {
  @JsonProperty("newModel")
  private String newModel = null;

  public CarModelChangeRequest newModel(String newModel) {
    this.newModel = newModel;
    return this;
  }

  /**
   * Get newModel
   * @return newModel
  **/
  @ApiModelProperty(example = "Fiesta", required = true, value = "")
      @NotNull

    public String getNewModel() {
    return newModel;
  }

  public void setNewModel(String newModel) {
    this.newModel = newModel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarModelChangeRequest carModelChangeRequest = (CarModelChangeRequest) o;
    return Objects.equals(this.newModel, carModelChangeRequest.newModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarModelChangeRequest {\n");
    
    sb.append("    newModel: ").append(toIndentedString(newModel)).append("\n");
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
