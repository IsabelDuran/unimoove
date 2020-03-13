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
 * PlaceCategoryChangeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:29:59.978+01:00[Europe/Madrid]")
public class PlaceCategoryChangeRequest   {
  /**
   * Gets or Sets newGender
   */
  public enum NewGenderEnum {
    TOWN("town"),
    
    FACULTY("faculty");

    private String value;

    NewGenderEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NewGenderEnum fromValue(String text) {
      for (NewGenderEnum b : NewGenderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("newGender")
  private NewGenderEnum newGender = null;

  public PlaceCategoryChangeRequest newGender(NewGenderEnum newGender) {
    this.newGender = newGender;
    return this;
  }

  /**
   * Get newGender
   * @return newGender
  **/
  @ApiModelProperty(value = "")
  
    public NewGenderEnum getNewGender() {
    return newGender;
  }

  public void setNewGender(NewGenderEnum newGender) {
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
    PlaceCategoryChangeRequest placeCategoryChangeRequest = (PlaceCategoryChangeRequest) o;
    return Objects.equals(this.newGender, placeCategoryChangeRequest.newGender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newGender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceCategoryChangeRequest {\n");
    
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
