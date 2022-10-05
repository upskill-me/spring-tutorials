package me.upskill.springtutorials.web.controllers;


import me.upskill.springtutorials.web.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/api/v1")
public class UserController {

    /**
     * Previously a ModelAttribute method is defined which initialises the user profile for us
     * Spring web mvc connects this for us seamlessly. If userProfile attribute is not present in the Model
     * it will instantiate it and bind the request parameters to object properties.
     * <p>
     * Spring web mvc will call the @ModelAttribute method first and inject the return profile object in this object
     * We can perform some modifications on that and return the same profile which will be added back to the model
     */
    @ModelAttribute("userProfile")
    @GetMapping(value = "/users/profile")
    public Profile getUserProfile() {
        return new Profile();
    }

    @GetMapping("/users/{userId}/profile")
    public ResponseEntity<?> getProfile(@PathVariable("userId") String uId) {
        // user user id to fetch profile
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new Profile());
    }

    @GetMapping("/download")
    public StreamingResponseBody downloadLargeFile() {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                // write the raw data to output stream
            }
        };
    }
}
