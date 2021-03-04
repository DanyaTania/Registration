package by.gourianova.binocularvision.dao.impl;

import by.gourianova.binocularvision.bean.RegistrationInfo;
import by.gourianova.binocularvision.bean.User;
import by.gourianova.binocularvision.dao.DAOException;
import by.gourianova.binocularvision.dao.UserDAO;

import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {

	static {
		MYSQLDriverLoader.getInstance();
	}


	@Override
	public User authorization(String login, String password) throws DAOException {
		return null;
	}

	@Override
	public boolean registration(RegistrationInfo regInfo) throws DAOException {
		return false;
	}
}