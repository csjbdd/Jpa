
package com.example.jpa.services;

import java.util.List;
import java.util.Map;

/**
 * Sqlsession 처리를 위한 서비스 클래스
 *
 * @Author : ihatelua
 * @Create : 2022년 04월 23일
 * @version 1.0
 */
public interface ICommonService {
    /**
     * DB 테스트
     * 파라미터의 값을 출력해준다.
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public String test(Map<String, Object> map) throws Exception;

    /**
     * selectOne 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public Map<String, Object> selectOne(String statement, Map<String, Object> map) throws Exception;

    /**
     * selectList 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public List<Object> selectList(String statement, Map<String, Object> map) throws Exception;
    public List<Object> selectList(String statement) throws Exception;
    /**
     * insert 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public int insert(String statement, Map<String, Object> map) throws Exception;

    /**
     * update 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public int update(String statement, Map<String, Object> map) throws Exception;

    /**
     * delete 메서드
     *
     * @Author : ihatelua
     * @Create : 2022년 04월 23일
     */
    public int delete(String statement, Map<String, Object> map) throws Exception;
}
