package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * UserRoleChangeRequest
 */
@Validated

public class UserRoleChangeRequest   {
  @JsonProperty("newRole")
  private Integer newRole = null;

  public UserRoleChangeRequest newRole(Integer newRole) {
    this.newRole = newRole;
    return this;
  }

  /**
   * Get newRole
   * @return newRole
  **/
  @ApiModelProperty(example = "0", required = true, value = "")
      @NotNull

    public Integer getNewRole() {
    return newRole;
  }

  public void setNewRole(Integer newRole) {
    this.newRole = newRole;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRoleChangeRequest userRoleChangeRequest = (UserRoleChangeRequest) o;
    return Objects.equals(this.newRole, userRoleChangeRequest.newRole);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newRole);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRoleChangeRequest {\n");
    
    sb.append("    newRole: ").append(toIndentedString(newRole)).append("\n");
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
