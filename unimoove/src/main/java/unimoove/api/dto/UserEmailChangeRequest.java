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
 * UserEmailChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:29:59.978+01:00[Europe/Madrid]")
public class UserEmailChangeRequest   {
  @JsonProperty("newEmail")
  private String newEmail = null;

  public UserEmailChangeRequest newEmail(String newEmail) {
    this.newEmail = newEmail;
    return this;
  }

  /**
   * Get newEmail
   * @return newEmail
  **/
  @ApiModelProperty(example = "new@example.com", required = true, value = "")
      @NotNull

    public String getNewEmail() {
    return newEmail;
  }

  public void setNewEmail(String newEmail) {
    this.newEmail = newEmail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserEmailChangeRequest userEmailChangeRequest = (UserEmailChangeRequest) o;
    return Objects.equals(this.newEmail, userEmailChangeRequest.newEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newEmail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserEmailChangeRequest {\n");
    
    sb.append("    newEmail: ").append(toIndentedString(newEmail)).append("\n");
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
