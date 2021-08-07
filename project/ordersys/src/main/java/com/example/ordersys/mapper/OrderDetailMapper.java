package com.example.ordersys.mapper;

import com.example.ordersys.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

@Mapper
public interface OrderDetailMapper {
    public int add(int oid,String[] dids);

    public List<OrderDetail> getList(int oid);

}
