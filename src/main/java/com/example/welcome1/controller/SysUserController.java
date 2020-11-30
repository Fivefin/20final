package com.example.welcome1.controller;


import com.example.welcome1.entity.SysUser;
import com.example.welcome1.service.SysUserService;
import com.example.welcome1.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("sysUser")
@Slf4j
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    /**
     *用来处理用户登录
     */
    @PostMapping("login")
    public Map<String,Object> login(@RequestBody SysUser sysUser){
        log.info("当前登录的信息:[{}]",sysUser.toString());
        Map<String,Object> map = new HashMap<>();
        try {
            SysUser sysUserDB = sysUserService.login(sysUser);
            map.put("state",true);
            map.put("msg","登录成功");
            map.put("sysUser",sysUserDB);
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }
    /**
     *用来处理用户注册
     */
//,String code,HttpServletRequest request
    @PostMapping("register")
    public Map<String,Object> register(@RequestBody SysUser sysUser){
//        log.info("用户信息:[{}]",sysUser.toString());
//        log.info("用户输入的验证码信息:[{}]",code);
        Map<String,Object>map = new HashMap<>();
        try {
//            String key=(String) request.getServletContext().getAttribute("code");
//            if(key.equalsIgnoreCase(code)){
            //1.调用业务方法
            sysUserService.register(sysUser);
            map.put("state",true);
            map.put("msg","提示：注册成功");
//            }else{
//                throw new RuntimeException("验证码出现错误！");
//            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示:"+e.getMessage());
        }
        return map;

    }


    /**
     * 生成验证码图片
     */
    @GetMapping("getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {
        //1.使用工具类生成验证码
        String code= VerifyCodeUtils.generateVerifyCode(4);
        //2.将验证码放入servletContext作用域
        request.getServletContext().setAttribute("code",code);
        //3.将图片转为base64
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(120,30,byteArrayOutputStream,code);
        return "data:image/png;base64,"+ Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
    }
}