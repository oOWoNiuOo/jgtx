package com.liujianhome.helper;

import com.liujianhome.utils.PropsUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/20.
 */
public class DatabaseHelper {

    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private static final Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static Connection conn;

    static {
        Properties config = PropsUtils.loadProps("config.properties");
        String s = (String) config.get("jdbc.driver");
        DRIVER = config.getProperty("jdbc.driver");
        URL = config.getProperty("jdbc.url");
        USERNAME = config.getProperty("jdbc.username");
        PASSWORD = config.getProperty("jdbc.password");

//        jdbc.driver=co
//        jdbc.url=jdbc:
//        jdbc.username=
//                jdbc.password=

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 建立数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        conn = CONNECTION_HOLDER.get();
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                logger.error("创建连接失败!", e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        conn = CONNECTION_HOLDER.get();
        if (conn != null) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("关闭连接失败!", e);
                } finally {
                    CONNECTION_HOLDER.remove();
                }
            }
        }

    }

    /**
     * 获取所有数据!
     *
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        List<T> entityList = null;
        try {
            Connection conn = getConnection();
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            logger.error("查询List失败!", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection(conn);
        }
        return entityList;
    }

    /**
     * 查询单个实体！
     *
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
        T entity = null;
        Connection conn = getConnection();
        try {
            entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            logger.error("查询单个实体失败!", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection(conn);
        }
        return entity;
    }

    /**
     * 获取所有数据，得到List<map>
     *
     * @param sql
     * @param params
     * @return
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object... params) {
        List<Map<String, Object>> list;
        Connection conn = getConnection();
        try {
            list = QUERY_RUNNER.query(conn, sql, new MapListHandler(), params);
        } catch (SQLException e) {
            logger.error("执行executeQuery方法失败!", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection(conn);
        }
        return list;
    }

    /**
     * 执行更新语句(包括update, insert, delete)
     *
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Object... params) {
        int rows = 0;
        Connection conn = getConnection();
        try {
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            logger.error("执行executeUpdate方法异常!", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection(conn);
        }
        return rows;
    }

//    public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> fieldMap) {
//        getT
//
//    }
}
