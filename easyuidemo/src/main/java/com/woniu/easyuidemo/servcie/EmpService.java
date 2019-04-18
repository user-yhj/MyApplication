package com.woniu.easyuidemo.servcie;

import com.woniu.easyuidemo.pojo.Emp;
import com.woniu.easyuidemo.vo.EmpVO;

import java.util.List;

public interface EmpService {

    public List<Emp> findEmpsByCondition(Integer currentPage, Integer pageSize, EmpVO vo);

    public int updateEmp(Emp e);

    public Emp queryEmpById(Integer empon);
}
