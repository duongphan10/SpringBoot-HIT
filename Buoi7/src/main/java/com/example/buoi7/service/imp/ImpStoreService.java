package com.example.buoi7.service.imp;

import com.example.buoi7.dto.StoreDTO;
import com.example.buoi7.mapper.StoreMapper;
import com.example.buoi7.model.Store;
import com.example.buoi7.repo.StoreRepository;
import com.example.buoi7.service.IStoreService;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImpStoreService implements IStoreService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ModelMapper modelMapper;
    private final StoreMapper storeMapper = Mappers.getMapper(StoreMapper.class);
    @Override
    public List<Store> getAllStore() {
        return storeRepository.findAll();
    }

    @Override
    public Store createNewStore(StoreDTO storeDTO) {
//        Store store = new Store();
//        store.setNameStore(storeDTO.getNameStore());
//        store.setAddress(storeDTO.getAddress());
        Store store = modelMapper.map(storeDTO,Store.class);
        return storeRepository.save(store);
    }

    @Override
    public Store createNewStore2(StoreDTO storeDTO) {
        Store store = storeMapper.storeDTOToStore(storeDTO);
        return storeRepository.save(store);
    }
}
