package unimoove.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import unimoove.api.dto.PaginationInfo;
import unimoove.api.dto.ReservationResponse;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationPaginatedResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:12:55.470+01:00[Europe/Madrid]")
public class ReservationPaginatedResponse   {
  @JsonProperty("pages")
  @Valid
  private List<ReservationResponse> pages = new ArrayList<ReservationResponse>();

  @JsonProperty("paginationInfo")
  private PaginationInfo paginationInfo = null;

  public ReservationPaginatedResponse pages(List<ReservationResponse> pages) {
    this.pages = pages;
    return this;
  }

  public ReservationPaginatedResponse addPagesItem(ReservationResponse pagesItem) {
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
    public List<ReservationResponse> getPages() {
    return pages;
  }

  public void setPages(List<ReservationResponse> pages) {
    this.pages = pages;
  }

  public ReservationPaginatedResponse paginationInfo(PaginationInfo paginationInfo) {
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
    ReservationPaginatedResponse reservationPaginatedResponse = (ReservationPaginatedResponse) o;
    return Objects.equals(this.pages, reservationPaginatedResponse.pages) &&
        Objects.equals(this.paginationInfo, reservationPaginatedResponse.paginationInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pages, paginationInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationPaginatedResponse {\n");
    
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
