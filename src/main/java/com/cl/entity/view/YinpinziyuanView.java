package com.cl.entity.view;

import com.cl.entity.YinpinziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 音频资源
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-01 12:12:08
 */
@TableName("yinpinziyuan")
public class YinpinziyuanView  extends YinpinziyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinpinziyuanView(){
	}
 
 	public YinpinziyuanView(YinpinziyuanEntity yinpinziyuanEntity){
 	try {
			BeanUtils.copyProperties(this, yinpinziyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
