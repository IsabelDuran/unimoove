package unimoove.api.places;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import unimoove.api.utils.PaginationInfo;

/**
 * PlacePaginatedResponse
 */
@Validated
public class PlacePaginatedResponse {
	  @JsonProperty("pages")
	  @Valid
	  private List<PlaceResponse> pages = new ArrayList<>();

	  @JsonProperty("paginationInfo")
	  private PaginationInfo paginationInfo = null;

	  public PlacePaginatedResponse pages(List<PlaceResponse> pages) {
	    this.pages = pages;
	    return this;
	  }

	  public PlacePaginatedResponse addPagesItem(PlaceResponse pagesItem) {
	    this.pages.add(pagesItem);
	    return this;
	  }

	  /**
	   * Get pages
	   * @return pages
	  **/
	  @ApiModelProperty(required = true, value = "")
	      @NotNull
	    @Valid
	    public List<PlaceResponse> getPages() {
	    return pages;
	  }

	  public void setPages(List<PlaceResponse> pages) {
	    this.pages = pages;
	  }

	  public PlacePaginatedResponse paginationInfo(PaginationInfo paginationInfo) {
	    this.paginationInfo = paginationInfo;
	    return this;
	  }

	  /**
	   * Get paginationInfo
	   * @return paginationInfo
	  **/
	  @ApiModelProperty(required = true, value = "")
	      @NotNull

	    @Valid
	    public PaginationInfo getPaginationInfo() {
	    return paginationInfo;
	  }

	  public void setPaginationInfo(PaginationInfo paginationInfo) {
	    this.paginationInfo = paginationInfo;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    PlacePaginatedResponse PlacePaginatedResponse = (PlacePaginatedResponse) o;
	    return Objects.equals(this.pages, PlacePaginatedResponse.pages) &&
	        Objects.equals(this.paginationInfo, PlacePaginatedResponse.paginationInfo);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(pages, paginationInfo);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class PlacePaginatedResponse {\n");
	    
	    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
	    sb.append("    paginationInfo: ").append(toIndentedString(paginationInfo)).append("\n");
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
