package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * CarBrandChangeRequest
 */
@Validated
public class CarBrandChangeRequest {
	@JsonProperty("newBrand")
	private String newBrand = null;

	public CarBrandChangeRequest newBrand(String newBrand) {
		this.newBrand = newBrand;
		return this;
	}

	/**
	 * Get newBrand
	 * 
	 * @return newBrand
	 **/
	@ApiModelProperty(example = "Ford", required = true, value = "")
	@NotNull

	public String getNewBrand() {
		return newBrand;
	}

	public void setNewBrand(String newBrand) {
		this.newBrand = newBrand;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarBrandChangeRequest carBrandChangeRequest = (CarBrandChangeRequest) o;
		return Objects.equals(this.newBrand, carBrandChangeRequest.newBrand);
	}

	@Override
	public int hashCode() {
		return Objects.hash(newBrand);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CarBrandChangeRequest {\n");

		sb.append("    newBrand: ").append(toIndentedString(newBrand)).append("\n");
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
