package com.example.names;

import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Map;


@RestController
public class NamesController {
    
    @GetMapping("/names")
    public String getNames(@RequestParam("name")String name,
                           @RequestParam("dateOfBirth")
                           @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateOfBirth){
        return "getNames-page";
    }
    
    @PostMapping("/names")
    public ResponseEntity<Map<String,String>> create(@Valid @RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        /*if (form.getName()==null || form.getName().isEmpty()){
            return ResponseEntity.badRequest().body("Name is required");
        }
        if (form.getName().length()>20){
            return ResponseEntity.badRequest().body("名前を20文字以下で入力してください");
        }*/
        return ResponseEntity.created(url).body(Map.of("message","name successfully created"));
    }
    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String,String>> update(@PathVariable("id")int id,@RequestBody UpdateForm form){
        //更新処理は省略
        return ResponseEntity.ok(Map.of("message","name successfully updated"));
    }
    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String,String>> deleteName(@PathVariable("id")int id){
        return ResponseEntity.ok(Map.of("message","name successfully deleted"));
    }
}
