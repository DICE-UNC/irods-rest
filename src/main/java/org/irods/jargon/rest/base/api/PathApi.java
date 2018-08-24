/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.irods.jargon.rest.base.api;

import org.irods.jargon.rest.base.model.PathInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Api(value = "path", description = "the path API")
public interface PathApi {

    Logger log = LoggerFactory.getLogger(PathApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "search and retrieve information on an iRODS path", nickname = "searchPaths", notes = "By passing in the appropriate options, you can search for available paths (files or collections)  ", response = PathInfo.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = PathInfo.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/path",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<PathInfo>> searchPaths(@ApiParam(value = "pass an iRODS path to retrieve. If the like parameter is not supplied, this method will look for an exact match. With the like parameter this method will treat as LIKE path% and return all matches.  ") @Valid @RequestParam(value = "path", required = false) String path,@ApiParam(value = "indicates the path is search with LIKE path% type query ", defaultValue = "false") @Valid @RequestParam(value = "like", required = false, defaultValue="false") Boolean like,@Min(0)@ApiParam(value = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"modifyDate\" : \"2016-08-29T09:12:33.001Z\",  \"name\" : \"file1\",  \"absolutePath\" : \"/zone/home/user/file1\",  \"createDate\" : \"2016-08-29T09:12:33.001Z\"}, {  \"modifyDate\" : \"2016-08-29T09:12:33.001Z\",  \"name\" : \"file1\",  \"absolutePath\" : \"/zone/home/user/file1\",  \"createDate\" : \"2016-08-29T09:12:33.001Z\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PathApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
