package ru.gruzimsumom.erp.ordertracker.billing;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ru.gruzimsumom.erp.ordertracker.billing.Order;

// планирую импортировать пакет с обертками
//import gruzimsumom.wrapper_package 

public class OrderMapper implements RowMapper<Order> {

    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setRegDate(rs.getDate("regDate"));
        order.setAddressStart(rs.getString("addressStart"));
        order.setAddressEnd(rs.getString("addressEnd"));

        order.setOrderInfoID(rs.getLong("orderInfoID"));
        order.setIsClosed(rs.getInt("isClosed"));

        return order;
    }

}

