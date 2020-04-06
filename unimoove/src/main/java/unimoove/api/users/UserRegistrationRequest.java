package unimoove.api.users;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserRegistrationRequest
 */
@Validated

public class UserRegistrationRequest {
	@JsonProperty("username")
	private String username = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("lastname")
	private String lastname = null;

	@JsonProperty("password")
	private String password = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("birthdate")
	private LocalDate birthdate = null;

	@JsonProperty("gender")
	private Integer gender = null;

	@JsonProperty("role")
	private Integer role = null;

	public UserRegistrationRequest username(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Get username
	 * 
	 * @return username
	 **/
	@ApiModelProperty(example = "johndoe", required = true, value = "")
	@NotNull

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRegistrationRequest name(String name) {
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

	public UserRegistrationRequest lastname(String lastname) {
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

	public UserRegistrationRequest password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 * 
	 * @return password
	 **/
	@ApiModelProperty(example = "1234", required = true, value = "")
	@NotNull

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRegistrationRequest birthdate(LocalDate birthdate) {
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

	public UserRegistrationRequest gender(Integer gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Get gender
	 * 
	 * @return gender
	 **/
	@ApiModelProperty(example = "0", required = true, value = "")
	@NotNull

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public UserRegistrationRequest role(Integer role) {
		this.role = role;
		return this;
	}

	/**
	 * Get role
	 * 
	 * @return role
	 **/
	@ApiModelProperty(example = "0", required = true, value = "")
	@NotNull

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserRegistrationRequest userRegistrationRequest = (UserRegistrationRequest) o;
		return Objects.equals(this.username, userRegistrationRequest.username)
				&& Objects.equals(this.name, userRegistrationRequest.name)
				&& Objects.equals(this.lastname, userRegistrationRequest.lastname)
				&& Objects.equals(this.password, userRegistrationRequest.password)
				&& Objects.equals(this.birthdate, userRegistrationRequest.birthdate)
				&& Objects.equals(this.gender, userRegistrationRequest.gender)
				&& Objects.equals(this.role, userRegistrationRequest.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, name, lastname, password, birthdate, gender, role);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UserRegistrationRequest {\n");

		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
