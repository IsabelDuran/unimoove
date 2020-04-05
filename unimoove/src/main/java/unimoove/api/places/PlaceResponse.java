package unimoove.api.places;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * PlaceResponse
 */
@Validated

public class PlaceResponse {

	@JsonProperty("idPlace")
	private String idPlace = null;
	
	@JsonProperty("name")
	private String name = null;

	@JsonProperty("category")
	private Integer category = null;

	public PlaceResponse name(String name) {
		this.name = name;
		return this;
	}
	
	
	/**
	 * Get idPlace
	 * 
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

	/**
	 * Get name
	 * 
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

	public PlaceResponse category(Integer category) {
		this.category = category;
		return this;
	}

	/**
	 * Get category
	 * 
	 * @return category
	 **/
	@ApiModelProperty(example = "0", required = true, value = "")
	@NotNull

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
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
		PlaceResponse placeResponse = (PlaceResponse) o;
		return Objects.equals(this.name, placeResponse.name) && Objects.equals(this.category, placeResponse.category);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, category);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlaceResponse {\n");

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
