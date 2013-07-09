package com.archer.livequote.dao;

import java.util.List;

public interface CrudDao {

    /*
     * insert or update
     */
    <T> T save(T dbObject);

    /*
     * remove by guid..
     */
    <T> T remove(String fieldName, String fieldValue, Class<T> entityClass);

    // get
    <T> T getByField(String fieldName, String fieldValue, Class<T> t);

    <T> List<T> getByQueryString(String queryString, Class<T> t);

    <T> List<T> getAll(Class<T> t);

}
