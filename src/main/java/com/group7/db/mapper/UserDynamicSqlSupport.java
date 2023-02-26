package com.group7.db.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T17:09:19.536+08:00", comments="Source Table: User")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T17:09:19.537+08:00", comments="Source field: User.id")
    public static final SqlColumn<String> id = user.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T17:09:19.537+08:00", comments="Source field: User.name")
    public static final SqlColumn<String> name = user.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T17:09:19.537+08:00", comments="Source field: User.password")
    public static final SqlColumn<String> password = user.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T17:09:19.537+08:00", comments="Source field: User.open_id")
    public static final SqlColumn<String> openId = user.openId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T17:09:19.538+08:00", comments="Source field: User.gmt_create")
    public static final SqlColumn<String> gmtCreate = user.gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T17:09:19.538+08:00", comments="Source field: User.gmt_modified")
    public static final SqlColumn<String> gmtModified = user.gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T17:09:19.536+08:00", comments="Source Table: User")
    public static final class User extends SqlTable {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> openId = column("open_id", JDBCType.VARCHAR);

        public final SqlColumn<String> gmtCreate = column("gmt_create", JDBCType.VARCHAR);

        public final SqlColumn<String> gmtModified = column("gmt_modified", JDBCType.VARCHAR);

        public User() {
            super("User");
        }
    }
}