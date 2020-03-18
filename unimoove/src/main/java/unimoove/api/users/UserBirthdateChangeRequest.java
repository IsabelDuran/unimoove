package unimoove.api.users;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * UserBirthdateChangeRequest
 */
@Validated

public class UserBirthdateChangeRequest   {
  @JsonProperty("newBirthdate")
  private LocalDate newBirthdate = null;

  public UserBirthdateChangeRequest newBirthdate(LocalDate newBirthdate) {
    this.newBirthdate = newBirthdate;
    return this;
  }

  /**
   * Get newBirthdate
   * @return newBirthdate
  **/
  @ApiModelProperty(example = "1996-05-10", required = true, value = "")
      @NotNull

    public LocalDate getNewBirthdate() {
    return newBirthdate;
  }

  public void setNewBirthdate(LocalDate newBirthdate) {
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
