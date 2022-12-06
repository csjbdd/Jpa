package com.example.jpa.daos;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Sqlsession 처리를 위한 DAO 클래스
 *
 * @Author : ihatelua
 * @Create : 2022년 04월 24일
 * @version 1.0
 */
@Repository
public class CommonDAOImpl implements com.example.jpa.daos.ICommonDAO{

    @Autowired
    private SqlSession sqlsession;

    /**
     * selectOne 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    @Override
    public Map<String, Object> selectOne(String statement, Map<String, Object> parameter) throws Exception {
        return sqlsession.selectOne(statement, parameter);
    }
    @Override
    public Map<String, Object> selectOne(Map<String, Object> parameter, String statement) throws Exception {
        return sqlsession.selectOne(statement, parameter);
    }
    @Override
    public Map<String, Object> selectOne(String statement) throws Exception {
        return sqlsession.selectOne(statement);
    }


    /**
     * selectString 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    @Override
    public String selectString(String statement, Map<String, Object> parameter) throws Exception {
        return sqlsession.selectOne(statement, parameter);
    }

    /**
     * selectList 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    @Override
    public List<Object> selectList(String statement, Map<String, Object> parameter) throws Exception {
        return sqlsession.selectList(statement, parameter);
    }
    @Override
    public List<Object> selectList(Map<String, Object> parameter, String statement) throws Exception {
        return sqlsession.selectList(statement, parameter);
    }
    @Override
    public List<Object> selectList(String statement) throws Exception {
        return sqlsession.selectList(statement);
    }

    /**
     * insert 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    @Override
    public int insert(String statement, Map<String, Object> parameter) throws Exception {
        return sqlsession.insert(statement, parameter);
    }
    @Override
    public int insert(Map<String, Object> parameter, String statement) throws Exception {
        return sqlsession.insert(statement, parameter);
    }

    /**
     * update 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    @Override
    public int update(String statement, Map<String, Object> parameter) throws Exception {
        return sqlsession.update(statement, parameter);
    }
    @Override
    public int update(Map<String, Object> parameter, String statement) throws Exception {
        return sqlsession.update(statement, parameter);
    }

    /**
     * delete 메서드
     * @param statement - mapper xml ID
     * @param parameter - sql binding 객체
     * @Author : ihatelua
     * @Create : 2022년 04월 24일
     */
    @Override
    public int delete(String statement, Map<String, Object> parameter) throws Exception {
        return sqlsession.delete(statement, parameter);
    }
    @Override
    public int delete(Map<String, Object> parameter, String statement) throws Exception {
        return sqlsession.delete(statement, parameter);
    }
}
