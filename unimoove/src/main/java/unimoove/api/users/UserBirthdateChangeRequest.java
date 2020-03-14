package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * UserBirthdateChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-14T00:59:07.824+01:00[Europe/Madrid]")
public class UserBirthdateChangeRequest   {
  @JsonProperty("newBirthdate")
  private String newBirthdate = null;

  public UserBirthdateChangeRequest newBirthdate(String newBirthdate) {
    this.newBirthdate = newBirthdate;
    return this;
  }

  /**
   * Get newBirthdate
   * @return newBirthdate
  **/
  @ApiModelProperty(example = "1996-05-10", required = true, value = "")
      @NotNull

    public String getNewBirthdate() {
    return newBirthdate;
  }

  public void setNewBirthdate(String newBirthdate) {
    this.newBirthdate = newBirthdate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserBirthdateChangeRequest userBirthdateChangeRequest = (UserBirthdateChangeRequest) o;
    return Objects.equals(this.newBirthdate, userBirthdateChangeRequest.newBirthdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newBirthdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBirthdateChangeRequest {\n");
    
    sb.append("    newBirthdate: ").append(toIndentedString(newBirthdate)).append("\n");
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
