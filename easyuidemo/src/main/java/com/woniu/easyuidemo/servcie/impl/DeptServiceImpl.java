package com.woniu.easyuidemo.servcie.impl;

import com.woniu.easyuidemo.dao.DeptMapper;
import com.woniu.easyuidemo.pojo.Dept;
import com.woniu.easyuidemo.servcie.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> queryDepts() {
        return deptMapper.queryDepts();
    }
}
