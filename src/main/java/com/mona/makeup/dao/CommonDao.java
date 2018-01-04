package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

@Repository("commonDao")
public class CommonDao extends BaseDao {

	public static Map<String, Object> BuildParameterMap(Object... keyValues){
		if(keyValues == null || keyValues.length % 2 != 0){
			throw new IllegalArgumentException("The length of parameters should be even. ");
		}
		for(int i = 0; i < keyValues.length; i += 2){
			if(!(keyValues[i] instanceof String)){
				throw new IllegalArgumentException("The type of odd parameter(key) should be String. The type of even parameter(value) is Object ");
			}
		}
		Map<String, Object> mParams = new HashMap<>();
		for(int i = 0; i < keyValues.length; i += 2){
			mParams.put((String)keyValues[i], keyValues[i+1]);
		}
		return mParams;
	}
	
	/**
	 * Query database, cast the result to the type specified by clazz.
	 * If the clazz is null or Object, the type of result will be List<Object[]>
	 * @param jql The JQL to query database
	 * @param clazz The entity class
	 * @param isNative Indicate if it is the native query
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameters for sql
	 * @return the result list of clazz
	 */
	@SuppressWarnings("unchecked")
	private <T> List<T> query(String jql, Class<T> clazz, boolean isNative, int offset, int size, Object params) {
		Query oQuery;
		try{
			oQuery = createQuery(jql, clazz, isNative, offset, size, params);
			if(clazz != null && clazz != Object.class){
				return (List<T>) oQuery.getResultList();
			}else{
				return oQuery.getResultList();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Create a Query object
	 * @param jql The JQL to query database
	 * @param clazz The entity class
	 * @param isNative Indicate if it is the native query
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameters for sql
	 * @return New query object
	 */
	@SuppressWarnings("unchecked")
	private Query createQuery(String jql, Class<?> clazz, boolean isNative, int offset, int size, Object params){
		if(StringUtils.isBlank(jql) && (clazz == null || clazz == Object.class)){
			throw new IllegalArgumentException("Incorrect argument");
		}
		if (StringUtils.isBlank(jql)) {
			jql = "from " + clazz.getName();
		}
		
		Query oQuery;
		if (isNative) {
			if(clazz != null && clazz != Object.class){
				oQuery = em.createNativeQuery(jql, clazz);
			}else{
				oQuery = em.createNativeQuery(jql);
			}
		} else {
			oQuery = em.createQuery(jql);
		}
		
		if (params != null) {
			if(params instanceof Map<?, ?>){
				Map<String, Object> oParams = (Map<String, Object>)params;
				for (String key : oParams.keySet()) {
					oQuery.setParameter(key, oParams.get(key));
				}
			}else{
				Object[] oParams = (Object[])params;
				for(int i = 0; i < oParams.length; i++){
					oQuery.setParameter(i, oParams[i]);
				}
			}
		}
		
		if(offset > 0 || size > 0){
			oQuery.setFirstResult(offset);
			oQuery.setMaxResults(size);
		}
		
		return oQuery;
	}

	/**
	 * Query database with pagination
	 * @param jql The sql to query database
	 * @param clazz The type of the result.
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public <T> List<T> query(String jql, Class<T> clazz, int offset, int size, Map<String, Object> params) {
		return query(jql, clazz, false, offset, size, params);
	}

	/**
	 * Query database with pagination
	 * @param jql The sql to query database
	 * @param clazz The type of the result.
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public <T> List<T> query(String jql, Class<T> clazz, int offset, int size, Object... params) {
		return query(jql, clazz, false, offset, size, params);
	}

	/**
	 * Query database with pagination
	 * @param The entity and type of the result.
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public <T> List<T> query(Class<T> clazz, int offset, int size, Map<String, Object> params) {
		return query(null, clazz, offset, size, params);
	}

	/**
	 * Query database with pagination
	 * @param clazz The type of the result.
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public <T> List<T> query(Class<T> clazz, int offset, int size, Object... params) {
		return query(null, clazz, offset, size, params);
	}

	/**
	 * Query database with pagination
	 * @param jql The sql to query database
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public List<?> query(String jql, int offset, int size, Map<String, Object> params) {
		return query(jql, Object.class, offset, size, params);
	}

	/**
	 * Query database with pagination
	 * @param jql The sql to query database
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public List<?> query(String jql, int offset, int size, Object... params) {
		return query(jql, Object.class, offset, size, params);
	}

	/**
	 * Query database with pagination
	 * @param jql The sql to query database
	 * @param offset The first result
	 * @param size The page size
	 * @return The query result
	 */
	public List<?> query(String jql, int offset, int size) {
		return query(jql, offset, size, new Object[0]);
	}

	/**
	 * Query database with pagination
	 * @param clazz The entity and type of the result.
	 * @param offset The first result
	 * @param size The page size
	 * @return The query result
	 */
	public <T> List<T> query(Class<T> clazz, int offset, int size) {
		return query(clazz, offset, size, new Object[0]);
	}

	/**
	 * Query database
	 * @param jql The sql to query database
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public <T> List<T> query(String jql, Class<T> clazz, Map<String, Object> params) {
		return query(jql, clazz, 0, 0, params);
	}

	/**
	 * Query database
	 * @param jql The sql to query database
	 * @param clazz The type of the result.
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public <T> List<T> query(String jql, Class<T> clazz, Object... params) {
		return query(jql, clazz, 0, 0, params);
	}

	/**
	 * Query database
	 * @param jql The sql to query database
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public List<?> query(String jql, Map<String, Object> params){
		return query(jql, Object.class, params);
	}

	/**
	 * Query database
	 * @param jql The sql to query database
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public List<?> query(String jql, Object... params) {
		return query(jql, Object.class, params);
	}

	/**
	 * Query database
	 * @param jql The sql to query database
	 * @return The query result
	 */
	public List<?> query(String jql){
		return query(jql, new Object[0]);
	}

	/**
	 * Query database
	 * @param clazz The entity and type of the result.
	 * @return The query result
	 */
	public <T> List<T> query(Class<T> clazz) {
		return this.query(null, clazz);
	}

	/**
	 * Query database with pagination by native query
	 * @param jql The sql to query database
	 * @param clazz The type of the result.
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public <T> List<T> queryByNative(String jql, Class<T> clazz, int offset, int size, Map<String, Object> params) {
		return query(jql, clazz, true, offset, size, params);
	}

	/**
	 * Query database with pagination by native query
	 * @param jql The sql to query database
	 * @param clazz The type of the result.
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public <T> List<T> queryByNative(String jql, Class<T> clazz, int offset, int size, Object... params) {
		return query(jql, clazz, true, offset, size, params);
	}

	/**
	 * Query database with pagination by native query
	 * @param jql The sql to query database
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public List<?> queryByNative(String jql, int offset, int size, Map<String, Object> params) {
		return queryByNative(jql, Object.class, offset, size, params);
	}

	/**
	 * Query database with pagination by native query
	 * @param jql The sql to query database
	 * @param offset The first result
	 * @param size The page size
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public List<?> queryByNative(String jql, int offset, int size, Object... params) {
		return queryByNative(jql, Object.class, offset, size, params);
	}

	/**
	 * Query database with pagination by native query
	 * @param jql The sql to query database
	 * @param offset The first result
	 * @param size The page size
	 * @return The query result
	 */
	public List<?> queryByNative(String jql, int offset, int size) {
		return queryByNative(jql, Object.class, offset, size, new Object[0]);
	}

	/**
	 * Query database by native query
	 * @param jql The sql to query database
	 * @param clazz The type of the result.
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public <T> List<T> queryByNative(String jql, Class<T> clazz, Map<String, Object> params) {
		return queryByNative(jql, clazz, 0, 0, params);
	}

	/**
	 * Query database by native query
	 * @param clazz The entity and type of the result.
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public <T> List<T> queryByNative(String jql, Class<T> clazz, Object... params) {
		return queryByNative(jql, clazz, 0, 0, params);
	}

	/**
	 * Query database by native query
	 * @param jql The sql to query database
	 * @param params The parameter to query database. It support named parameters.
	 * @return The query result
	 */
	public List<?> queryByNative(String jql, Map<String, Object> params){
		return queryByNative(jql, Object.class, params);
	}

	/**
	 * Query database by native query
	 * @param jql The sql to query database
	 * @param params The parameter to query database. It support un-named parameters, like ?.
	 * @return The query result
	 */
	public List<?> queryByNative(String jql, Object... params) {
		return queryByNative(jql, Object.class, params);
	}

	/**
	 * Query database by native query
	 * @param jql The sql to query database
	 * @return The query result
	 */
	public List<?> queryByNative(String jql){
		return queryByNative(jql, new Object[0]);
	}
	
	/**
	 * Execute the sql to update, insert, delete records. 
	 * The execution will be by native
	 * @param sql
	 * @param params
	 * @return The result code
	 */
	public int execRawSql(String sql, Map<String, Object> params){
		return execRawSqlPrivate(sql, false, params);
	}

	/**
	 * Execute the sql to update, insert, delete records. 
	 * The execution will be by native
	 * @param sql
	 * @param params
	 * @return The result code
	 */
	public int execRawSql(String sql, Object... params) {
		return execRawSqlPrivate(sql, false, params);
	}

	/**
	 * Execute the sql to update, insert, delete records. 
	 * The execution will be by native
	 * @param sql
	 * @return The result code
	 */
	public int execRawSql(String sql) {
		return execRawSql(sql, new Object[0]);
	}
	
	/**
	 * Execute the sql by native to update, insert, delete records. 
	 * The execution will be by native
	 * @param sql
	 * @param params
	 * @return The result code
	 */
	public int execRawSqlByNative(String sql, Map<String, Object> params){
		return execRawSqlPrivate(sql, true, params);
	}

	/**
	 * Execute the sql by native to update, insert, delete records. 
	 * The execution will be by native
	 * @param sql
	 * @param params
	 * @return The result code
	 */
	public int execRawSqlByNative(String sql, Object... params) {
		return execRawSqlPrivate(sql, true, params);
	}

	/**
	 * Execute the sql by native to update, insert, delete records. 
	 * The execution will be by native
	 * @param sql
	 * @return The result code
	 */
	public int execRawSqlByNative(String sql) {
		return execRawSqlByNative(sql, new Object[0]);
	}


	/**
	 * Execute the sql to update, insert, delete records. 
	 * The execution will be by native
	 * @param sql
	 * @param isNative
	 * @param params
	 * @return The result code
	 */
	private int execRawSqlPrivate(String sql, boolean isNative, Object params) {
		Query query = createQuery(sql, null, isNative, 0, 0, params);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}
}
