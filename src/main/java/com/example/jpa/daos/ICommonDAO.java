package com.example.jpa.daos;

import java.util.List;
import java.util.Map;

public interface ICommonDAO {

    /**
     * selectOne 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    public Map<String, Object> selectOne(String statement, Map<String, Object> parameter) throws Exception;
    public Map<String, Object> selectOne(Map<String, Object> parameter, String statement) throws Exception;
    public Map<String, Object> selectOne(String statement) throws Exception;

    /**
     * selectString 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    public String selectString(String statement, Map<String, Object> parameter) throws Exception;

    /**
     * selectList 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    public List<Object> selectList(String statement, Map<String, Object> parameter) throws Exception;
    public List<Object> selectList(Map<String, Object> parameter, String statement) throws Exception;
    public List<Object> selectList(String statement) throws Exception;

    /**
     * insert 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    public int insert(String statement, Map<String, Object> parameter) throws Exception;
    public int insert(Map<String, Object> parameter, String statement) throws Exception;

    /**
     * update 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    public int update(String statement, Map<String, Object> parameter) throws Exception;
    public int update(Map<String, Object> parameter, String statement) throws Exception;

    /**
     * delete 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    public int delete(String statement, Map<String, Object> parameter) throws Exception;
    public int delete(Map<String, Object> parameter, String statement) throws Exception;
}
