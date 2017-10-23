package br.com.zedrax.services.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Mapper {

    @Autowired
    private static ModelMapper modelMapper;

    @SuppressWarnings("unchecked")
    public static <T> T convertEntityToDto(T object, Class<?> clazz) {
        
        return (T) modelMapper.map(object, clazz);
    }
}