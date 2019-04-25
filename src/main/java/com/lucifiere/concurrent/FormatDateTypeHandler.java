package com.lucifiere.concurrent;

import com.lucifiere.time.TimeUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 自动格式化时间的TypeHandler
 * 关注TypeHandlerRegistry::register
 * BaseTypeHandler用于加密、格式化、枚举转化等
 *
 * @author XD.Wang
 * @date 2019/4/18.
 */
@MappedJdbcTypes({JdbcType.DATE})
@MappedTypes({String.class})
public class FormatDateTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, s);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String col) throws SQLException {
        Date date = resultSet.getDate(col);
        return TimeUtils.simpleFormat(date);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int colIndex) throws SQLException {
        return resultSet.getString(colIndex);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int colIndex) throws SQLException {
        return callableStatement.getString(colIndex);
    }

}
