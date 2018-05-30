package com.controller;

import com.config.Constant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.DingTalkSignatureUtil;
import com.dingtalk.api.request.OapiServiceGetCorpTokenRequest;
import com.dingtalk.api.request.OapiSnsGetPersistentCodeRequest;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.request.OapiSnsGetuserinfoRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiServiceGetCorpTokenResponse;
import com.dingtalk.api.response.OapiSnsGetPersistentCodeResponse;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.config.URLConstant;
import com.taobao.api.ApiException;
import com.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.config.URLConstant.URL_GET_USERINFO_BY_CODE;

/**
 * Quick-Start示例代码
 * 实现了最简单的获取企业信息和个人身份验证功能
 */
@RestController
public class IndexController {
	private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

	/**
	 * 欢迎页面
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}


	/**
	 * 钉钉用户登录，显示当前登录用户基本信息
	 * @param authCode	由E应用前端JSAPI获取到的临时授权码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestParam(value = "authCode") String authCode) {
		Long start = System.currentTimeMillis();
		ServiceResult serviceResult;
		try {
			DefaultDingTalkClient  client = new DefaultDingTalkClient(URL_GET_USERINFO_BY_CODE);
			OapiSnsGetuserinfoBycodeRequest req = new OapiSnsGetuserinfoBycodeRequest();
			req.setTmpAuthCode(authCode);
			OapiSnsGetuserinfoBycodeResponse response = client.execute(req,Constant.APP_ID,Constant.APP_SECRET);
			serviceResult = ServiceResult.success(response.getUserInfo());
			return serviceResult;
		} catch (Exception e) {
			bizLogger.error("loginFailed,authCode"+authCode,e);
			serviceResult = ServiceResult.failure("-1",e.getMessage());
			//返回结果
		}

		bizLogger.info("cost:"+(System.currentTimeMillis()-start));

		return serviceResult;
	}


}


