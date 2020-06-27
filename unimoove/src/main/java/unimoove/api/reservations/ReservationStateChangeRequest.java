package unimoove.api.reservations;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ReservationStateChangeRequest
 */
@Validated
public class ReservationStateChangeRequest {
	@JsonProperty("newState")
	private Integer newState = null;
	
	public ReservationStateChangeRequest newState(Integer newState) {
	    this.newState = newState;
	    return this;
	  }
	
	/**
	   * Get newState
	   * @return newState
	  **/
	  @ApiModelProperty(example = "1", required = true, value = "")
	      @NotNull

	    public Integer getnewState() {
	    return newState;
	  }

	  public void setnewState(Integer newState) {
	    this.newState = newState;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    ReservationStateChangeRequest ReservationStateChangeRequest = (ReservationStateChangeRequest) o;
	    return Objects.equals(this.newState, ReservationStateChangeRequest.newState);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(newState);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ReservationStateChangeRequest {\n");
	    
	    sb.append("    newState: ").append(toIndentedString(newState)).append("\n");
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
