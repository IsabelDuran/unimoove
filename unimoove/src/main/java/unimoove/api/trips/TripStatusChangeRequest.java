package unimoove.api.trips;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TripStatusChangeRequest
 */
@Validated
public class TripStatusChangeRequest {
	@JsonProperty("newStatus")
	private Integer newStatus = null;
	
	public TripStatusChangeRequest newStatus(Integer newStatus) {
	    this.newStatus = newStatus;
	    return this;
	  }
	
	/**
	   * Get newStatus
	   * @return newStatus
	  **/
	  @ApiModelProperty(example = "1", required = true, value = "")
	      @NotNull

	    public Integer getNewStatus() {
	    return newStatus;
	  }

	  public void setNewStatus(Integer newStatus) {
	    this.newStatus = newStatus;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    TripStatusChangeRequest TripStatusChangeRequest = (TripStatusChangeRequest) o;
	    return Objects.equals(this.newStatus, TripStatusChangeRequest.newStatus);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(newStatus);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class TripStatusChangeRequest {\n");
	    
	    sb.append("    newStatus: ").append(toIndentedString(newStatus)).append("\n");
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
