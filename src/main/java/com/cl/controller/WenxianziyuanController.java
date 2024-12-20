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

import com.cl.entity.WenxianziyuanEntity;
import com.cl.entity.view.WenxianziyuanView;

import com.cl.service.WenxianziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 文献资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-01 12:12:07
 */
@RestController
@RequestMapping("/wenxianziyuan")
public class WenxianziyuanController {
    @Autowired
    private WenxianziyuanService wenxianziyuanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenxianziyuanEntity wenxianziyuan,
		HttpServletRequest request){
        EntityWrapper<WenxianziyuanEntity> ew = new EntityWrapper<WenxianziyuanEntity>();

		PageUtils page = wenxianziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenxianziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenxianziyuanEntity wenxianziyuan, 
		HttpServletRequest request){
        EntityWrapper<WenxianziyuanEntity> ew = new EntityWrapper<WenxianziyuanEntity>();

		PageUtils page = wenxianziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenxianziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenxianziyuanEntity wenxianziyuan){
       	EntityWrapper<WenxianziyuanEntity> ew = new EntityWrapper<WenxianziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenxianziyuan, "wenxianziyuan")); 
        return R.ok().put("data", wenxianziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenxianziyuanEntity wenxianziyuan){
        EntityWrapper< WenxianziyuanEntity> ew = new EntityWrapper< WenxianziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenxianziyuan, "wenxianziyuan")); 
		WenxianziyuanView wenxianziyuanView =  wenxianziyuanService.selectView(ew);
		return R.ok("查询文献资源成功").put("data", wenxianziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenxianziyuanEntity wenxianziyuan = wenxianziyuanService.selectById(id);
		wenxianziyuan = wenxianziyuanService.selectView(new EntityWrapper<WenxianziyuanEntity>().eq("id", id));
        return R.ok().put("data", wenxianziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenxianziyuanEntity wenxianziyuan = wenxianziyuanService.selectById(id);
		wenxianziyuan = wenxianziyuanService.selectView(new EntityWrapper<WenxianziyuanEntity>().eq("id", id));
        return R.ok().put("data", wenxianziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenxianziyuanEntity wenxianziyuan, HttpServletRequest request){
    	wenxianziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenxianziyuan);
        wenxianziyuanService.insert(wenxianziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenxianziyuanEntity wenxianziyuan, HttpServletRequest request){
    	wenxianziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenxianziyuan);
        wenxianziyuanService.insert(wenxianziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenxianziyuanEntity wenxianziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenxianziyuan);
        wenxianziyuanService.updateById(wenxianziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenxianziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
