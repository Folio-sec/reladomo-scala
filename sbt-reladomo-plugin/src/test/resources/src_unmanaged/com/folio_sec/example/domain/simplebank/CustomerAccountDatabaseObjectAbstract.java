package com.folio_sec.example.domain.simplebank;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.*;
import com.gs.fw.common.mithra.util.*;
import com.gs.fw.common.mithra.notification.*;
import com.gs.fw.common.mithra.notification.listener.*;
import com.gs.fw.common.mithra.list.cursor.Cursor;
import com.gs.fw.common.mithra.bulkloader.*;
import java.util.*;
import java.sql.*;
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.update.AttributeUpdateWrapper;
import com.gs.fw.common.mithra.bulkloader.BulkLoader;
import com.gs.fw.common.mithra.bulkloader.BulkLoaderException;
import com.gs.fw.common.mithra.cache.*;
import com.gs.fw.common.mithra.cache.offheap.*;
import com.gs.fw.common.mithra.connectionmanager.*;
import com.gs.fw.common.mithra.database.*;
import com.gs.fw.common.mithra.databasetype.*;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.finder.orderby.OrderBy;
import com.gs.fw.common.mithra.finder.integer.IntegerResultSetParser;
import com.gs.fw.common.mithra.querycache.CachedQuery;
import com.gs.fw.common.mithra.remote.RemoteMithraService;
import com.gs.fw.common.mithra.transaction.BatchUpdateOperation;
import com.gs.fw.common.mithra.transaction.UpdateOperation;
/**
* This file was automatically generated using Mithra 17.0.2. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public abstract class CustomerAccountDatabaseObjectAbstract extends MithraAbstractTransactionalDatabaseObject implements MithraTransactionalDatabaseObject, MithraObjectFactory
{
	private SourcelessConnectionManager connectionManager;
	private SchemaManager schemaManager;
	private TablePartitionManager tablePartitionManager;
	private static final String COL_LIST_WITHOUT_PK = "CUSTOMER_ID,ACCOUNT_NAME,ACCOUNT_TYPE,AREA_ID,BALANCE";
	private static final String COL_LIST_WITHOUT_PK_WITH_ALIAS = "t0.CUSTOMER_ID,t0.ACCOUNT_NAME,t0.ACCOUNT_TYPE,t0.AREA_ID,t0.BALANCE";
	private static final String PK_WITH_ALIAS = "t0.ACCOUNT_ID = ?";
	private static final String PK_INDEX_COLS = "ACCOUNT_ID";
	protected CustomerAccountDatabaseObjectAbstract()
	{
		super("CustomerAccount", "com.folio_sec.example.domain.simplebank.CustomerAccountFinder",
			6, 6,
			COL_LIST_WITHOUT_PK, COL_LIST_WITHOUT_PK_WITH_ALIAS,
			false, false, false,
			PK_WITH_ALIAS,
			PK_INDEX_COLS);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return CustomerAccountFinder.getMithraObjectPortal();
	}

	public RelatedFinder getFinder()
	{
		return CustomerAccountFinder.getFinderInstance();
	}

	public static CustomerAccountData allocateOnHeapData()
	{
		return new CustomerAccountData();
	}

	public static CustomerAccountData allocateOffHeapData()
	{
		throw new RuntimeException("no off heap implementation");
	}

	public MithraDataObject deserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		MithraDataObject data = new CustomerAccountData();
		data.zDeserializeFullData(in);
		return data;
	}

	public MithraObject deserializeForRefresh(ObjectInput in) throws IOException, ClassNotFoundException
	{
		CustomerAccountData data = new CustomerAccountData();
		data.zDeserializePrimaryKey(in);
		return this.createObject(data);
	}

	public Cache instantiateFullCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new FullNonDatedTransactionalCache(CustomerAccountFinder.getPrimaryKeyAttributes(), this, CustomerAccountFinder.getImmutableAttributes());
		}
		else
		{
			result = new FullNonDatedCache(CustomerAccountFinder.getPrimaryKeyAttributes(), this, CustomerAccountFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter());
		}

		initPortal(result, config);
		return result;
	}

	public Cache instantiatePartialCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new PartialNonDatedTransactionalCache(CustomerAccountFinder.getPrimaryKeyAttributes(), this, CustomerAccountFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}
		else
		{
			result = new PartialNonDatedCache(CustomerAccountFinder.getPrimaryKeyAttributes(), this, CustomerAccountFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}

		initPortal(result, config);
		return result;
	}

	private void initPortal(Cache cache, MithraConfigurationManager.Config config)
	{
		if (config.isThreeTierClient())
		{
			CustomerAccountFinder.initializeClientPortal(this, cache, config);
		}
		else
		{
			CustomerAccountFinder.initializePortal(this, cache, config);
		}

		if (config.isParticipatingInTx())
		{
			CustomerAccount.zConfigFullTx();
		}
		else
		{
			CustomerAccount.zConfigNonTx();
		}
	}

	public List getSimulatedSequenceInitValues()
	{
		ArrayList simulatedSequenceInitValues = new ArrayList(1);
		Attribute[] primaryKeyAttributes = CustomerAccountFinder.getPrimaryKeyAttributes();
		SimulatedSequenceInitValues initValues = null;
		return simulatedSequenceInitValues;
	}

	public Object getSourceAttributeValueForSelectedObjectGeneric(SqlQuery query, int queryNumber)
	{
		return null;
	}

	public Object getSourceAttributeValueFromObjectGeneric(MithraDataObject object)
	{
		return null;
	}

	public Object getSourceAttributeValueGeneric(SqlQuery query, MapperStackImpl mapperStack, int queryNumber)
	{
		return null;
	}

	public String getDatabaseIdentifierGenericSource (Object source)
	{
		return connectionManager.getDatabaseIdentifier();
	}

	public DatabaseType getDatabaseTypeGenericSource(Object source)
	{
		return connectionManager.getDatabaseType();
	}

	public TimeZone getDatabaseTimeZoneGenericSource(Object source)
	{
		return getDatabaseTimeZone();
	}

	public Connection getConnectionGenericSource(Object source)
	{
		return connectionManagerWrapper.getConnection();
	}

	public BulkLoader createBulkLoaderGenericSource(Object source) throws BulkLoaderException 
	{
		return connectionManager.createBulkLoader();
	}

	public MithraDataObject inflateDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateCustomerAccountData(rs, dt);
	}

	public void inflateNonPkDataGenericSource(MithraDataObject data, ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		inflateNonPkCustomerAccountData(1, (CustomerAccountData) data, rs, dt);
	}

	public MithraDataObject inflatePkDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateCustomerAccountPkData(rs, dt);
	}

	public String getSchemaGenericSource(Object source)
	{
		if (this.schemaManager != null)
		{
			return this.schemaManager.getSchema(this.getDefaultSchema());
		}

		return this.getDefaultSchema();
	}

	public String getTableNameGenericSource(Object source) throws MithraDatabaseException
	{
		return getCustomerAccountTableName();
	}

	public String getCustomerAccountTableName() throws MithraDatabaseException
	{
		if (this.tablePartitionManager != null)
		{
			return this.tablePartitionManager.getTableName(this.getDefaultTableName());
		}

		return this.getDefaultTableName();
	}

	public void setPrimaryKeyAttributes(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		CustomerAccountData data = (CustomerAccountData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getAccountId());
	}

	public int setPrimaryKeyAttributesWithoutOptimistic(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		this.setPrimaryKeyAttributes(stm, pos, dataObj, databaseTimeZone, dt);
		return -1;
	}

	public String getPrimaryKeyWhereSql()
	{
		return "ACCOUNT_ID = ?";
	}

	public String getPrimaryKeyWhereSqlWithNullableAttribute(MithraDataObject dataObj)
	{
		return "";
	}

	public String getPrimaryKeyWhereSqlWithNullableAttributeWithDefaultAlias(MithraDataObject dataObj)
	{
		return "";
	}

	public String getColumnListWithPk(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.ACCOUNT_ID,t0.CUSTOMER_ID,t0.ACCOUNT_NAME,t0.ACCOUNT_TYPE,t0.AREA_ID,t0.BALANCE";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*6);
		result.append(databaseAlias).append(".").append("ACCOUNT_ID");
		result.append(",").append(databaseAlias).append(".").append("CUSTOMER_ID");
		result.append(",").append(databaseAlias).append(".").append("ACCOUNT_NAME");
		result.append(",").append(databaseAlias).append(".").append("ACCOUNT_TYPE");
		result.append(",").append(databaseAlias).append(".").append("AREA_ID");
		result.append(",").append(databaseAlias).append(".").append("BALANCE");
		return result.toString();
	}

	public Object getConnectionManager()
	{
		return connectionManager;
	}

	public void setConnectionManager(Object connectionManager, ConnectionManagerWrapper wrapper)
	{
		this.connectionManager = (SourcelessConnectionManager)connectionManager;
		this.connectionManagerWrapper = wrapper;
	}

	public CustomerAccountData inflateCustomerAccountData(ResultSet rs, DatabaseType dt)
	throws SQLException
	{
		CustomerAccountData data = inflateCustomerAccountPkData(rs, dt);
		inflateNonPkCustomerAccountData(2, data, rs, dt);
		return data;
	}

	public CustomerAccountData inflateCustomerAccountPkData(ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		CustomerAccountData _data = new CustomerAccountData();
		int _pos = 1;
		_data.setAccountId(_rs.getInt(_pos++));
		checkNullPrimitive(_rs, _data, "accountId");
		return _data;
	}

	public void inflateNonPkCustomerAccountData(int _pos, CustomerAccountData _datax, ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		{
			CustomerAccountData _data = _datax;
			_data.setCustomerId(_rs.getInt(_pos++));
			checkNullPrimitive(_rs, _data, "customerId");
			_data.setAccountName(trimString(_rs.getString(_pos++)));
			_data.setAccountType(trimString(_rs.getString(_pos++)));
			_data.setAreaId(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setAreaIdNull();
			}

			_data.setBalance(_rs.getDouble(_pos++));
			if (_rs.wasNull())
			{
				_data.setBalanceNull();
			}
		}
	}

	public DatabaseType getDatabaseType()
	{
		return connectionManager.getDatabaseType();
	}

	public TimeZone getDatabaseTimeZone()
	{
		return connectionManager.getDatabaseTimeZone();
	}

	protected String getSchema()
	{
		return this.getSchemaGenericSource(null);
	}

	public void setSchemaManager(Object schemaManager)
	{
		if( schemaManager instanceof SchemaManager )
		{
			this.schemaManager = (SchemaManager) schemaManager;
		}
		else
		{
			throw new IllegalArgumentException( "Schema manager class " + schemaManager.getClass().getName()
			+ " does not implement SchemaManager.class" );
		}
	}

	public void setTablePartitionManager(Object tablePartitionManager)
	{
		if( tablePartitionManager instanceof TablePartitionManager )
		{
			this.tablePartitionManager = (TablePartitionManager) tablePartitionManager;
		}
		else
		{
			throw new IllegalArgumentException( "Table partition manager class " + tablePartitionManager.getClass().getName()
			+ " does not implement TablePartitionManager.class" );
		}
	}

	public String getTableName()
	{
		return this.getDefaultTableName();
	}

	public String getDefaultTableName()
	{
		return "CUSTOMER_ACCOUNT";
	}

	public void setInsertAttributes(PreparedStatement stm, MithraDataObject dataObj,
		TimeZone databaseTimeZone, int pos, DatabaseType dt) throws SQLException
	{
		CustomerAccountData data = (CustomerAccountData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getAccountId());
		stm.setInt(pos++, data.getCustomerId());
		if(data.isAccountNameNull())
		{
			throwNullAttribute("accountName");
		}

		stm.setString(pos++, data.getAccountName());
		if(data.isAccountTypeNull())
		{
			throwNullAttribute("accountType");
		}

		stm.setString(pos++, data.getAccountType());
		if (data.isAreaIdNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getAreaId());
		}

		if (data.isBalanceNull())
		{
			stm.setNull(pos++, java.sql.Types.DOUBLE);
		}
		else
		{
			stm.setDouble(pos++, data.getBalance());
		}
	}

	public String getInsertFields()
	{
		return "ACCOUNT_ID,CUSTOMER_ID,ACCOUNT_NAME,ACCOUNT_TYPE,AREA_ID,BALANCE";
	}

	public String getInsertQuestionMarks()
	{
		return "?,?,?,?,?,?";
	}

	public String getOptimisticLockingWhereSql()
	{
		return "";
	}

	public MithraObject createObject(MithraDataObject newData)
	{
		CustomerAccount newObject = new CustomerAccount();
		newObject.zSetFromCustomerAccountData((CustomerAccountData) newData);
		return newObject;
	}

	public String getPkColumnList(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.ACCOUNT_ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*6);
		result.append(databaseAlias);
		result.append(".");
		result.append("ACCOUNT_ID");
		return result.toString();
	}
}
