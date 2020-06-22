package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserReservationResponse
 */
@Validated

public class UserReservationResponse {
	@JsonProperty("name")
	private String name = null;

	@JsonProperty("lastname")
	private String lastname = null;

	@JsonProperty("birthdate")
	private LocalDate birthdate = null;

	public UserReservationResponse name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "John", required = true, value = "")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserReservationResponse lastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	/**
	 * Get lastname
	 * 
	 * @return lastname
	 **/
	@ApiModelProperty(example = "Doe", required = true, value = "")
	@NotNull

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public UserReservationResponse birthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	/**
	 * Get birthdate
	 * 
	 * @return birthdate
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserReservationResponse UserReservationResponse = (UserReservationResponse) o;
		return Objects.equals(this.name, UserReservationResponse.name)
				&& Objects.equals(this.lastname, UserReservationResponse.lastname)
				&& Objects.equals(this.birthdate, UserReservationResponse.birthdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, lastname, birthdate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UserReservationResponse {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
		sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
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
