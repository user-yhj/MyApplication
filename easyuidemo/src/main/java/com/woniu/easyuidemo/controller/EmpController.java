package com.woniu.easyuidemo.controller;

import com.github.pagehelper.PageInfo;
import com.woniu.easyuidemo.pojo.Dept;
import com.woniu.easyuidemo.pojo.Emp;
import com.woniu.easyuidemo.servcie.DeptService;
import com.woniu.easyuidemo.servcie.EmpService;
import com.woniu.easyuidemo.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "page",defaultValue = "1",
            required = false)Integer currentPage, @RequestParam(value = "rows",required = false,
    defaultValue = "5") Integer pageSize, EmpVO vo){
        List<Emp> list = empService.findEmpsByCondition(currentPage,pageSize,vo);
        PageInfo pageInfo = new PageInfo(list);


        Map result = new HashMap();
        result.put("total",pageInfo.getTotal());
        result.put("rows",list);
        return result;
    }

    @RequestMapping("/edit/{empno}")
    public ModelAndView edit(@PathVariable(value = "empno") Integer empno){
        Emp emp = empService.queryEmpById(empno);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("emp",emp);
        List<Dept> deptList = deptService.queryDepts();
        modelAndView.addObject("deptList",deptList);
        return modelAndView;
    }


    @RequestMapping("/update")
    public String update(Emp emp){
        int code = empService.updateEmp(emp);
        if(code > 0){
            return "redirect:/list";
        }else{
            return "forward:/edit/"+emp.getEmpno();
        }
    }









}
