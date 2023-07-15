package com.example.buoi7.service;

import com.example.buoi7.dto.StoreDTO;
import com.example.buoi7.model.Store;

import java.util.List;

public interface IStoreService {
    List<Store> getAllStore();
    Store createNewStore(StoreDTO storeDTO);
    Store createNewStore2(StoreDTO storeDTO);
}
