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
 * PlaceCategoryChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T23:33:47.450+01:00[Europe/Madrid]")
public class PlaceCategoryChangeRequest   {
  @JsonProperty("newCategory")
  private Integer newCategory = null;

  public PlaceCategoryChangeRequest newCategory(Integer newCategory) {
    this.newCategory = newCategory;
    return this;
  }

  /**
   * Get newCategory
   * @return newCategory
  **/
  @ApiModelProperty(example = "0", required = true, value = "")
      @NotNull

    public Integer getNewCategory() {
    return newCategory;
  }

  public void setNewCategory(Integer newCategory) {
    this.newCategory = newCategory;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaceCategoryChangeRequest placeCategoryChangeRequest = (PlaceCategoryChangeRequest) o;
    return Objects.equals(this.newCategory, placeCategoryChangeRequest.newCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newCategory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceCategoryChangeRequest {\n");
    
    sb.append("    newCategory: ").append(toIndentedString(newCategory)).append("\n");
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
