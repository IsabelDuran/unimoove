package unimoove.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserRoleChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:29:59.978+01:00[Europe/Madrid]")
public class UserRoleChangeRequest   {
  /**
   * Gets or Sets newRole
   */
  public enum NewRoleEnum {
    USER("user"),
    
    ADMIN("admin");

    private String value;

    NewRoleEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NewRoleEnum fromValue(String text) {
      for (NewRoleEnum b : NewRoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("newRole")
  private NewRoleEnum newRole = null;

  public UserRoleChangeRequest newRole(NewRoleEnum newRole) {
    this.newRole = newRole;
    return this;
  }

  /**
   * Get newRole
   * @return newRole
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public NewRoleEnum getNewRole() {
    return newRole;
  }

  public void setNewRole(NewRoleEnum newRole) {
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
