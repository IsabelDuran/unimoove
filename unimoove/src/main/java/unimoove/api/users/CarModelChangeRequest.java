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
  @JsonProperty("newCarModel")
  private String newCarModel = null;

  public CarModelChangeRequest newCarModel(String newCarModel) {
    this.newCarModel = newCarModel;
    return this;
  }

  /**
   * Get newCarModel
   * @return newCarModel
  **/
  @ApiModelProperty(example = "Fiesta", required = true, value = "")
      @NotNull

    public String getNewCarModel() {
    return newCarModel;
  }

  public void setNewCarModel(String newCarModel) {
    this.newCarModel = newCarModel;
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
    return Objects.equals(this.newCarModel, carModelChangeRequest.newCarModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newCarModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarModelChangeRequest {\n");
    
    sb.append("    newCarModel: ").append(toIndentedString(newCarModel)).append("\n");
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
