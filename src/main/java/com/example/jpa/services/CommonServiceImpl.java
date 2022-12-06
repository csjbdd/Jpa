package com.example.jpa.services;

import com.example.jpa.daos.ICommonDAO;
import com.example.jpa.daos.ICommonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sqlsession 처리를 위한 서비스 클래스
 *
 * @Author : ihatelua
 * @Create : 2022년 04월 23일
 * @version 1.0
 */
@Service
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private ICommonDAO CommonDAO;


    /**
     * DB 테스트
     * 파라미터의 값을 출력해준다.
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public String test(Map<String, Object> parameter) throws Exception {
        String str;
        try{
            Map<String, Object> map = new HashMap<>();
            map = CommonDAO.selectOne("testMapper.test", parameter);
            str = map.get("a").toString();
            System.out.println(str);
        }catch (Exception e){
            throw e;
        }
        return str;
    }

    /**
     * selectOne 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public Map<String, Object> selectOne(String statement, Map<String, Object> parameter) throws Exception {
        Map<String, Object> result = new HashMap<>();
        try{
            result = CommonDAO.selectOne(statement, parameter);
        }catch (Exception e){
            throw e;
        }
        return result;
    }

    /**
     * selectList 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public List<Object> selectList(String statement, Map<String, Object> parameter) throws Exception {
        List<Object> result = null;
        try{
            result = CommonDAO.selectList(statement, parameter);
        }catch (Exception e){
            throw e;
        }
        return result;
    }
    public List<Object> selectList(String statement) throws Exception {
        List<Object> result = null;
        try{
            result = CommonDAO.selectList(statement);
        }catch (Exception e){
            throw e;
        }
        return result;
    }

    /**
     * insert 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public int insert(String statement, Map<String, Object> parameter) throws Exception {
        int result;
        try{
            result = CommonDAO.insert(statement, parameter);
        }catch (Exception e){
            throw e;
        }
        return result;
    }

    /**
     * update 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public int update(String statement, Map<String, Object> parameter) throws Exception {
        int result;
        try{
            result = CommonDAO.update(statement, parameter);
        }catch (Exception e){
            throw e;
        }
        return result;
    }

    /**
     * delete 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public int delete(String statement, Map<String, Object> parameter) throws Exception {
        int result;
        try{
            result = CommonDAO.delete(statement, parameter);
        }catch (Exception e){
            throw e;
        }
        return result;
    }


}
