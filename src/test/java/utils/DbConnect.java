package utils;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import baseFile.BaseFile;

public class DbConnect extends BaseFile {

	private static DataSource DATASOURCE;
	private static JdbcTemplate JDBC_TEMPLATE;
	private static TransactionTemplate TXN_TEMPLATE;
	private static final String PG_DRIVER = config_
			.getProperty("Database_Driver");
	private static Logger LOGGER = Logger.getLogger(DbConnect.class);
	private static final PasswordEncoder PW_ENCODER = new StandardPasswordEncoder();

	static {
		try {
			Class.forName(PG_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(
					"Failed to load SQL driver class: " + PG_DRIVER);
		}

		DATASOURCE = new DriverManagerDataSource(
				config_.getProperty("Database_url"),
				config_.getProperty("Database_username"),
				config_.getProperty("Database_password"));

		DataSourceTransactionManager txnMgr = new DataSourceTransactionManager(
				DATASOURCE);
		JDBC_TEMPLATE = new JdbcTemplate(txnMgr.getDataSource());
		TXN_TEMPLATE = new TransactionTemplate(txnMgr);
	}

	private static final String[] REMOVE_USERGROUP = {
			"delete from t_asset_group where usergroup_id  in (select id from t_usergroup where name =?);",
			"delete from t_usergroup where id=(select id from t_usergroup where name = ?);" };

	
	
}
