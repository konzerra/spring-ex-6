package org.konzerra.springex6.domain.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("public/api/v1/test/status")
     ResponseEntity<String> testServerStatus(){
        return ResponseEntity.ok("Online");
    }
    @GetMapping("protected/api/v1/test/security")
    ResponseEntity<String> testSecurity(){
        return ResponseEntity.ok("Secured");
    }

}
