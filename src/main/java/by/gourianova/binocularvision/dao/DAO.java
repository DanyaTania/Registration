package by.gourianova.binocularvision.dao;

import by.gourianova.binocularvision.connectpool.ConnectionPool;


public abstract class DAO {
	protected static ConnectionPool poolInstance;

	protected DAO() {
		poolInstance = ConnectionPool.getInstance();

	}
}
