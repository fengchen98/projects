package com.example.ordersys.mapper;

import com.example.ordersys.model.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {
    public List<Dish> getList();

}
