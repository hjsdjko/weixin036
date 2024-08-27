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

import com.cl.entity.ShipinziyuanEntity;
import com.cl.entity.view.ShipinziyuanView;

import com.cl.service.ShipinziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 视频资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-01 12:12:08
 */
@RestController
@RequestMapping("/shipinziyuan")
public class ShipinziyuanController {
    @Autowired
    private ShipinziyuanService shipinziyuanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipinziyuanEntity shipinziyuan,
		HttpServletRequest request){
        EntityWrapper<ShipinziyuanEntity> ew = new EntityWrapper<ShipinziyuanEntity>();

		PageUtils page = shipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipinziyuanEntity shipinziyuan, 
		HttpServletRequest request){
        EntityWrapper<ShipinziyuanEntity> ew = new EntityWrapper<ShipinziyuanEntity>();

		PageUtils page = shipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipinziyuanEntity shipinziyuan){
       	EntityWrapper<ShipinziyuanEntity> ew = new EntityWrapper<ShipinziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipinziyuan, "shipinziyuan")); 
        return R.ok().put("data", shipinziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipinziyuanEntity shipinziyuan){
        EntityWrapper< ShipinziyuanEntity> ew = new EntityWrapper< ShipinziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipinziyuan, "shipinziyuan")); 
		ShipinziyuanView shipinziyuanView =  shipinziyuanService.selectView(ew);
		return R.ok("查询视频资源成功").put("data", shipinziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipinziyuanEntity shipinziyuan = shipinziyuanService.selectById(id);
		shipinziyuan = shipinziyuanService.selectView(new EntityWrapper<ShipinziyuanEntity>().eq("id", id));
        return R.ok().put("data", shipinziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipinziyuanEntity shipinziyuan = shipinziyuanService.selectById(id);
		shipinziyuan = shipinziyuanService.selectView(new EntityWrapper<ShipinziyuanEntity>().eq("id", id));
        return R.ok().put("data", shipinziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShipinziyuanEntity shipinziyuan, HttpServletRequest request){
    	shipinziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinziyuan);
        shipinziyuanService.insert(shipinziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShipinziyuanEntity shipinziyuan, HttpServletRequest request){
    	shipinziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinziyuan);
        shipinziyuanService.insert(shipinziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShipinziyuanEntity shipinziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinziyuan);
        shipinziyuanService.updateById(shipinziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shipinziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
