package com.cl.entity.view;

import com.cl.entity.WenxianziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 文献资源
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-01 12:12:07
 */
@TableName("wenxianziyuan")
public class WenxianziyuanView  extends WenxianziyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WenxianziyuanView(){
	}
 
 	public WenxianziyuanView(WenxianziyuanEntity wenxianziyuanEntity){
 	try {
			BeanUtils.copyProperties(this, wenxianziyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
