package com.social.network.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/moderator")
@Tag(name = "Moderator")
public class ModeratorController {


    @Operation(
            description = "Get endpoint for moderator",
            summary = "This is a summary for moderator get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }

    )
    @GetMapping
    public String get() {
        return "GET:: moderator controller";
    }
    @PostMapping
    public String post() {
        return "POST:: moderator controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: moderator controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: moderator controller";
    }
}
