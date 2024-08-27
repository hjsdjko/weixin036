package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JiaocaiziyuanEntity;
import com.cl.entity.view.JiaocaiziyuanView;

import com.cl.service.JiaocaiziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 教材资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-01 12:12:07
 */
@RestController
@RequestMapping("/jiaocaiziyuan")
public class JiaocaiziyuanController {
    @Autowired
    private JiaocaiziyuanService jiaocaiziyuanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaocaiziyuanEntity jiaocaiziyuan,
		HttpServletRequest request){
        EntityWrapper<JiaocaiziyuanEntity> ew = new EntityWrapper<JiaocaiziyuanEntity>();

		PageUtils page = jiaocaiziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaocaiziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaocaiziyuanEntity jiaocaiziyuan, 
		HttpServletRequest request){
        EntityWrapper<JiaocaiziyuanEntity> ew = new EntityWrapper<JiaocaiziyuanEntity>();

		PageUtils page = jiaocaiziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaocaiziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaocaiziyuanEntity jiaocaiziyuan){
       	EntityWrapper<JiaocaiziyuanEntity> ew = new EntityWrapper<JiaocaiziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaocaiziyuan, "jiaocaiziyuan")); 
        return R.ok().put("data", jiaocaiziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaocaiziyuanEntity jiaocaiziyuan){
        EntityWrapper< JiaocaiziyuanEntity> ew = new EntityWrapper< JiaocaiziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaocaiziyuan, "jiaocaiziyuan")); 
		JiaocaiziyuanView jiaocaiziyuanView =  jiaocaiziyuanService.selectView(ew);
		return R.ok("查询教材资源成功").put("data", jiaocaiziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaocaiziyuanEntity jiaocaiziyuan = jiaocaiziyuanService.selectById(id);
		jiaocaiziyuan = jiaocaiziyuanService.selectView(new EntityWrapper<JiaocaiziyuanEntity>().eq("id", id));
        return R.ok().put("data", jiaocaiziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaocaiziyuanEntity jiaocaiziyuan = jiaocaiziyuanService.selectById(id);
		jiaocaiziyuan = jiaocaiziyuanService.selectView(new EntityWrapper<JiaocaiziyuanEntity>().eq("id", id));
        return R.ok().put("data", jiaocaiziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaocaiziyuanEntity jiaocaiziyuan, HttpServletRequest request){
    	jiaocaiziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaocaiziyuan);
        jiaocaiziyuanService.insert(jiaocaiziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaocaiziyuanEntity jiaocaiziyuan, HttpServletRequest request){
    	jiaocaiziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaocaiziyuan);
        jiaocaiziyuanService.insert(jiaocaiziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaocaiziyuanEntity jiaocaiziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaocaiziyuan);
        jiaocaiziyuanService.updateById(jiaocaiziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaocaiziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
