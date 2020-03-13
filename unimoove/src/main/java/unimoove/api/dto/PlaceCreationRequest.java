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
 * PlaceCreationRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:29:59.978+01:00[Europe/Madrid]")
public class PlaceCreationRequest   {
  @JsonProperty("idPlace")
  private String idPlace = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * Gets or Sets category
   */
  public enum CategoryEnum {
    TOWN("Town"),
    
    UNIVERSITY("University");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("category")
  private CategoryEnum category = null;

  public PlaceCreationRequest idPlace(String idPlace) {
    this.idPlace = idPlace;
    return this;
  }

  /**
   * Get idPlace
   * @return idPlace
  **/
  @ApiModelProperty(example = "PR", required = true, value = "")
      @NotNull

    public String getIdPlace() {
    return idPlace;
  }

  public void setIdPlace(String idPlace) {
    this.idPlace = idPlace;
  }

  public PlaceCreationRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Puerto Real", required = true, value = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PlaceCreationRequest category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaceCreationRequest placeCreationRequest = (PlaceCreationRequest) o;
    return Objects.equals(this.idPlace, placeCreationRequest.idPlace) &&
        Objects.equals(this.name, placeCreationRequest.name) &&
        Objects.equals(this.category, placeCreationRequest.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPlace, name, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceCreationRequest {\n");
    
    sb.append("    idPlace: ").append(toIndentedString(idPlace)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
