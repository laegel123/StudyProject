package com.toby.spring.notSpringCode.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
