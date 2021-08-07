package com.example.ordersys.mapper;

import com.example.ordersys.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderInfoMapper {

    public int add(OrderInfo orderInfo);

    public List<OrderInfo> getList(int uid);
}
