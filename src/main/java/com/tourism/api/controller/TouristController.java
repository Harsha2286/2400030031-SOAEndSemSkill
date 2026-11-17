package com.tourism.api.controller;

import com.tourism.api.model.Tourist;
import com.tourism.api.service.TouristService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Tourist Controller", description = "Tourism Analytics Dashboard API")
public class TouristController {

    @Autowired
    private TouristService touristService;

    // -------------------------------------------------------
    // Step 1: Pre-generated valid token loaded from properties
    // -------------------------------------------------------
    @Value("${app.valid.token}")
    private String validToken;

    /**
     * Step 1 + Step 2:
     *   - Inspect the incoming "Token" header.
     *   - If token is missing or invalid → 500 with error message.
     *   - If token is valid             → 200 with list of all tourists.
     */
    @Operation(
        summary = "Get All Tourists",
        description = "Retrieves all registered tourist records. " +
                      "Requires a valid custom Token header for authorization."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved all tourist records",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Tourist.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Unauthorized: Invalid Token Provided",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/tourists")
    public ResponseEntity<?> getAllTourists(
        @Parameter(
            description = "Pre-generated authorization token",
            required = true,
            example = "TOURISM-SECRET-TOKEN-2024"
        )
        @RequestHeader(value = "Token", required = false) String token
    ) {
        // ---- Step 1: Inspect Token ----
        if (token == null || token.isBlank() || !token.equals(validToken)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unauthorized: Invalid Token Provided");
        }

        // ---- Step 2: Fetch All Records ----
        List<Tourist> tourists = touristService.getAllTourists();
        return ResponseEntity.ok(tourists);
    }
}
