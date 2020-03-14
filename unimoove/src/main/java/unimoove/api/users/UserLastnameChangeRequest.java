package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * UserLastnameChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-14T00:59:07.824+01:00[Europe/Madrid]")
public class UserLastnameChangeRequest   {
  @JsonProperty("newLastname")
  private String newLastname = null;

  public UserLastnameChangeRequest newLastname(String newLastname) {
    this.newLastname = newLastname;
    return this;
  }

  /**
   * Get newLastname
   * @return newLastname
  **/
  @ApiModelProperty(example = "Diaz", required = true, value = "")
      @NotNull

    public String getNewLastname() {
    return newLastname;
  }

  public void setNewLastname(String newLastname) {
    this.newLastname = newLastname;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserLastnameChangeRequest userLastnameChangeRequest = (UserLastnameChangeRequest) o;
    return Objects.equals(this.newLastname, userLastnameChangeRequest.newLastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newLastname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserLastnameChangeRequest {\n");
    
    sb.append("    newLastname: ").append(toIndentedString(newLastname)).append("\n");
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
