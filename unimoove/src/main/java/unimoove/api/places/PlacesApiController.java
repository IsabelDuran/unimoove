package unimoove.api;

import unimoove.api.dto.PlaceCategoryChangeRequest;
import unimoove.api.dto.PlaceCreationRequest;
import unimoove.api.dto.PlaceIdChangeRequest;
import unimoove.api.dto.PlaceNameChangeRequest;
import unimoove.api.dto.PlaceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:29:59.978+01:00[Europe/Madrid]")
@Controller
public class PlacesApiController implements PlacesApi {

    private static final Logger log = LoggerFactory.getLogger(PlacesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PlacesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addPlace(@ApiParam(value = "Place to add"  )  @Valid @RequestBody PlaceCreationRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deletePLace(@ApiParam(value = "By passing in the appropriate place ID, you can delete the place.",required=true) @PathVariable("idPlace") String idPlace
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<PlaceResponse> getPlace(@ApiParam(value = "By passing in the appropriate place ID, you can get the place.",required=true) @PathVariable("idPlace") String idPlace
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PlaceResponse>(objectMapper.readValue("{\n  \"name\" : \"Puerto Real\",\n  \"category\" : \"Town\"\n}", PlaceResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PlaceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PlaceResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyPlaceCategory(@ApiParam(value = "",required=true) @PathVariable("idPlace") String idPlace
,@ApiParam(value = "The place's new category"  )  @Valid @RequestBody PlaceCategoryChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyPlaceId(@ApiParam(value = "",required=true) @PathVariable("idPlace") String idPlace
,@ApiParam(value = "The place's new ID"  )  @Valid @RequestBody PlaceIdChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyPlaceName(@ApiParam(value = "",required=true) @PathVariable("idPlace") String idPlace
,@ApiParam(value = "The place's new name"  )  @Valid @RequestBody PlaceNameChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<PlaceResponse>> searchPlace(@ApiParam(value = "the place to be searched") @Valid @RequestParam(value = "name", required = false) String name
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<PlaceResponse>>(objectMapper.readValue("[ {\n  \"name\" : \"Puerto Real\",\n  \"category\" : \"Town\"\n}, {\n  \"name\" : \"Puerto Real\",\n  \"category\" : \"Town\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<PlaceResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<PlaceResponse>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
