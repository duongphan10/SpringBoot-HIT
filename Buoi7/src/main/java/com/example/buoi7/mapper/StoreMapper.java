package com.example.buoi7.mapper;

import com.example.buoi7.dto.StoreDTO;
import com.example.buoi7.model.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StoreMapper {
//    @Mappings({
//            @Mapping(target = "nameStore",source = "storeDTO.nameStore"),
//            @Mapping(target = "address", source = "storeDTO.address")
//    })
    Store storeDTOToStore(StoreDTO storeDTO);
}
