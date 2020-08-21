package com.consumer.project.result;

/**
 * 返回给前台的成功提示
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:05:22
 */
public class SuccessTip extends Tip {
	
	public SuccessTip(){
		super.code = 200;
		super.msg = "操作成功";
		super.data = null;
	}
	public SuccessTip(int code, String msg, Object data){
		super.code = code;
		super.msg = msg;
		super.data = data;
	}
	public SuccessTip(Object data){
		super.code = 200;
		super.msg = "OK";
		super.data = data;
	}
}
