package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 文献资源
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-01 12:12:07
 */
@TableName("wenxianziyuan")
public class WenxianziyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WenxianziyuanEntity() {
		
	}
	
	public WenxianziyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 文献标题
	 */
					
	private String wenxianbiaoti;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 作者
	 */
					
	private String zuozhe;
	
	/**
	 * 文献分类
	 */
					
	private String wenxianfenlei;
	
	/**
	 * 文献详情
	 */
					
	private String wenxianxiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：文献标题
	 */
	public void setWenxianbiaoti(String wenxianbiaoti) {
		this.wenxianbiaoti = wenxianbiaoti;
	}
	/**
	 * 获取：文献标题
	 */
	public String getWenxianbiaoti() {
		return wenxianbiaoti;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：作者
	 */
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	/**
	 * 获取：作者
	 */
	public String getZuozhe() {
		return zuozhe;
	}
	/**
	 * 设置：文献分类
	 */
	public void setWenxianfenlei(String wenxianfenlei) {
		this.wenxianfenlei = wenxianfenlei;
	}
	/**
	 * 获取：文献分类
	 */
	public String getWenxianfenlei() {
		return wenxianfenlei;
	}
	/**
	 * 设置：文献详情
	 */
	public void setWenxianxiangqing(String wenxianxiangqing) {
		this.wenxianxiangqing = wenxianxiangqing;
	}
	/**
	 * 获取：文献详情
	 */
	public String getWenxianxiangqing() {
		return wenxianxiangqing;
	}

}
