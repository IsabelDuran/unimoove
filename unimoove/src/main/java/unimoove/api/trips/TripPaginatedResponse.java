package unimoove.api.trips;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import unimoove.api.trips.TripResponse;
import unimoove.api.utils.PaginationInfo;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TripPaginatedResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-14T00:59:07.824+01:00[Europe/Madrid]")
public class TripPaginatedResponse   {
  @JsonProperty("pages")
  @Valid
  private List<TripResponse> pages = new ArrayList<>();

  @JsonProperty("paginationInfo")
  private PaginationInfo paginationInfo = null;

  public TripPaginatedResponse pages(List<TripResponse> pages) {
    this.pages = pages;
    return this;
  }

  public TripPaginatedResponse addPagesItem(TripResponse pagesItem) {
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
    public List<TripResponse> getPages() {
    return pages;
  }

  public void setPages(List<TripResponse> pages) {
    this.pages = pages;
  }

  public TripPaginatedResponse paginationInfo(PaginationInfo paginationInfo) {
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
    TripPaginatedResponse tripPaginatedResponse = (TripPaginatedResponse) o;
    return Objects.equals(this.pages, tripPaginatedResponse.pages) &&
        Objects.equals(this.paginationInfo, tripPaginatedResponse.paginationInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pages, paginationInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TripPaginatedResponse {\n");
    
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
