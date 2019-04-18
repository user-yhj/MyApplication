package com.woniu.easyuidemo.servcie.impl;

import com.woniu.easyuidemo.dao.EmpMapper;
import com.woniu.easyuidemo.pojo.Emp;
import com.woniu.easyuidemo.servcie.EmpService;
import com.woniu.easyuidemo.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Emp> findEmpsByCondition(Integer currentPage, Integer pageSize, EmpVO vo) {
        return empMapper.queryEmpsByPage(currentPage,pageSize,vo);
    }

    @Override
    public int updateEmp(Emp e) {
        return empMapper.updateByPrimaryKeySelective(e);
    }

    @Override
    public Emp queryEmpById(Integer empon) {
        return empMapper.selectByPrimaryKey(empon);
    }
}
