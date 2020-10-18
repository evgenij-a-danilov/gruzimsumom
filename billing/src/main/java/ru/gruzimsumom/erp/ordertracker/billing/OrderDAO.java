package ru.gruzimsumom.erp.ordertracker.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

import ru.gruzimsumom.erp.ordertracker.billing.Order;

@Repository
@Transactional
public class OrderDAO extends JdbcDaoSupport {

    @Autowired
    public OrderDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    List<Order> orderMap = new ArrayList<Order>();

    public List<Order> getOrders() {
        String queryString = "SELECT id," +
                " reg_date as regDate," +
                " address_start as addressStart," +
                " address_end as addressEnd," +
                " order_info_id as orderInfoId," +
                " is_closed as isClosed" +
                " FROM public.orders ";  //order by TypeId, Id, ParentId
        //locMap = this.getJdbcTemplate().query("Select l.GLOBALID as Id, l.GLOBALID as Name, l.Code as TypeId, cast(l.GEOGRAPHY_ID_Code as decimal) as ParentId From mdm.CL_GEOGRAPHY_CONTENT as l order by l.Id", new LocationMapExtractor());}
        orderMap = this.getJdbcTemplate().query(queryString, new OrderMapper());
        System.out.print("getOrders!!!!   ");
        //Map<Long, List<Location>> locMap = this.getJdbcTemplate().query("Select l.Id, l.Name, l.TypeId, l.ParentId From dbo.ADDR_LOCATION as l where l.Id between 2 and 50 order by l.Id", new LocationMapExtractor());
        return orderMap;
    }



    public String getOrderByID(String s) {

        String sql = "SELECT max(ID) FROM public.orders where id > '"+s+"'";
        String lastCreatedId = getJdbcTemplate().queryForObject(sql, String.class);

        System.out.print("lastCreatedId:   "+lastCreatedId);
        return lastCreatedId;
    }

    public List<Order> getAllOrderRowMapper(){

        return getJdbcTemplate().query("select * from public.orders",new OrderMapper());
    }


    //public String createOrder(Order order) {



    //    String sql = " INSERT INTO public.orders(id, reg_date, address_start, address_end, order_info_id, is_closed)\n" +
    //            "\tVALUES ("+id+", "+regDate+", "+address_start+", "+address_end+", "+order_info_id+", "+is_closed+");";
    //    String lastCreatedId = getJdbcTemplate().queryForObject(sql, String.class);

    //    System.out.print("lastCreatedId:   "+lastCreatedId);
    //    return lastCreatedId;
    //}
}
