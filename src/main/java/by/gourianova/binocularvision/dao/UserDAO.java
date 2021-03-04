package by.gourianova.binocularvision.dao;

import by.gourianova.binocularvision.bean.RegistrationInfo;
import by.gourianova.binocularvision.bean.User;


import by.gourianova.binocularvision.connectpool.ConnectionPool;
import  by.gourianova.binocularvision.resources.SqlManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//	User authorization (String login, String password) throws DAOException;
//			boolean	registration(RegistrationInfo regInfo) throws DAOException;

public interface UserDAO {

		  UserDAO instance = null;
		   String COLUMN_NAME_LOGIN = "login";
		  String COLUMN_NAME_PASSWORD = "password";
		  String COLUMN_NAME_ACCESS_LEVEL = "role";



 	User authorization (String login, String password) throws DAOException;
			boolean	registration(RegistrationInfo regInfo) throws DAOException;

		  ConnectionPool poolInstance=ConnectionPool.getInstance();

		/*public static UserDAO getInstance() {
				instance = new UserDAO();

			return instance;
		}*/

		/**
		 *
		 * This method finds the user in the database with the correct username and password
		 * @param login login user
		 * @param password password user
		 * @return user
		 * @throws SQLException
		 * SQLException
		 */

		public static User getUser(String login, String password) throws SQLException {
			User user = null;
			Connection connection = poolInstance.getConnection();
			PreparedStatement ps = null;
			String query = SqlManager.getProperty("sql.get.user");
			ps = poolInstance.getConnection().prepareStatement(query);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				user = new User();
				user.setLogin(result.getString(COLUMN_NAME_LOGIN));
				user.setPassword(result.getString(COLUMN_NAME_PASSWORD));
				user. setRoleId(result.getInt(COLUMN_NAME_ACCESS_LEVEL));
			}
			poolInstance.freeConnection(connection);
			return user;
		}

		/**
		 * This method check user with login
		 * @param login login
		 * @return true or false
		 * @throws SQLException
		 * SQLException
		 */
		public static boolean checkLogin(String login) throws SQLException {
			Connection connection = poolInstance.getConnection();
			PreparedStatement ps = null;
			String query = SqlManager.getProperty("sql.check.login");
			ps = poolInstance.getConnection().prepareStatement(query);
			ps.setString(1, login);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				poolInstance.freeConnection(connection);
				return false;
			} else
				poolInstance.freeConnection(connection);
			return true;
		}

		/**
		 * This method registered user into database
		 * @param user
		 * User
		 * @throws SQLException
		 * SQLException
		 */
		public static void register(User user) throws SQLException {
			Connection connection = poolInstance.getConnection();
			String query = SqlManager.getProperty("sql.register.user");
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.executeUpdate();
			poolInstance.freeConnection(connection);
		}
	}


