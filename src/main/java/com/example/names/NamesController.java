package com.example.names;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
public class NamesController {
    
    @GetMapping("/names")
    public List<String> getNames(){
        return List.of("yamada","hanako");
    }
    
    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }
    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String,String>> update(@PathVariable("id")int id,@RequestBody UpdateForm form){
        //更新処理は省略
        return ResponseEntity.ok(Map.of("message","name successfully updated"));
    }
}
