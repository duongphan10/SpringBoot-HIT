package com.example.buoi7.controller;

import com.example.buoi7.dto.StoreDTO;
import com.example.buoi7.service.IStoreService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    @Autowired
    private IStoreService iStoreService;
    @PostMapping("/create_store")
    public ResponseEntity<?> createNewStore(@RequestBody StoreDTO storeDTO) {
//        return ResponseEntity.ok().body(iStoreService.createNewStore(storeDTO));
        return ResponseEntity.ok().body(iStoreService.createNewStore2(storeDTO));
    }
    @GetMapping("/get_all_store")
    public ResponseEntity<?> getAllStore() {
        return ResponseEntity.ok().body(iStoreService.getAllStore());
    }
}
