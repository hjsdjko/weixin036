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

import com.cl.entity.YinpinziyuanEntity;
import com.cl.entity.view.YinpinziyuanView;

import com.cl.service.YinpinziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 音频资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-01 12:12:08
 */
@RestController
@RequestMapping("/yinpinziyuan")
public class YinpinziyuanController {
    @Autowired
    private YinpinziyuanService yinpinziyuanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinpinziyuanEntity yinpinziyuan,
		HttpServletRequest request){
        EntityWrapper<YinpinziyuanEntity> ew = new EntityWrapper<YinpinziyuanEntity>();

		PageUtils page = yinpinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinpinziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinpinziyuanEntity yinpinziyuan, 
		HttpServletRequest request){
        EntityWrapper<YinpinziyuanEntity> ew = new EntityWrapper<YinpinziyuanEntity>();

		PageUtils page = yinpinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinpinziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinpinziyuanEntity yinpinziyuan){
       	EntityWrapper<YinpinziyuanEntity> ew = new EntityWrapper<YinpinziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinpinziyuan, "yinpinziyuan")); 
        return R.ok().put("data", yinpinziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinpinziyuanEntity yinpinziyuan){
        EntityWrapper< YinpinziyuanEntity> ew = new EntityWrapper< YinpinziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinpinziyuan, "yinpinziyuan")); 
		YinpinziyuanView yinpinziyuanView =  yinpinziyuanService.selectView(ew);
		return R.ok("查询音频资源成功").put("data", yinpinziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinpinziyuanEntity yinpinziyuan = yinpinziyuanService.selectById(id);
		yinpinziyuan = yinpinziyuanService.selectView(new EntityWrapper<YinpinziyuanEntity>().eq("id", id));
        return R.ok().put("data", yinpinziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinpinziyuanEntity yinpinziyuan = yinpinziyuanService.selectById(id);
		yinpinziyuan = yinpinziyuanService.selectView(new EntityWrapper<YinpinziyuanEntity>().eq("id", id));
        return R.ok().put("data", yinpinziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinpinziyuanEntity yinpinziyuan, HttpServletRequest request){
    	yinpinziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinpinziyuan);
        yinpinziyuanService.insert(yinpinziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinpinziyuanEntity yinpinziyuan, HttpServletRequest request){
    	yinpinziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinpinziyuan);
        yinpinziyuanService.insert(yinpinziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinpinziyuanEntity yinpinziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinpinziyuan);
        yinpinziyuanService.updateById(yinpinziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinpinziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
