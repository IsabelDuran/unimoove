package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * UserGenderChangeRequest
 */
@Validated

public class UserGenderChangeRequest   {
  @JsonProperty("newGender")
  private Integer newGender = null;

  public UserGenderChangeRequest newGender(Integer newGender) {
    this.newGender = newGender;
    return this;
  }

  /**
   * Get newGender
   * @return newGender
  **/
  @ApiModelProperty(example = "0", required = true, value = "")
      @NotNull

    public Integer getNewGender() {
    return newGender;
  }

  public void setNewGender(Integer newGender) {
    this.newGender = newGender;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserGenderChangeRequest userGenderChangeRequest = (UserGenderChangeRequest) o;
    return Objects.equals(this.newGender, userGenderChangeRequest.newGender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newGender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserGenderChangeRequest {\n");
    
    sb.append("    newGender: ").append(toIndentedString(newGender)).append("\n");
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
