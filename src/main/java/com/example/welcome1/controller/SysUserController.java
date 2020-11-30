package com.example.welcome1.controller;


import com.example.welcome1.entity.SysUser;
import com.example.welcome1.service.SysUserService;
import com.example.welcome1.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        //log.info("当前登录的信息:[{}]",sysUser.toString());
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

    /**
     * 个人资料
     */
    @GetMapping("/getInfo")
    public Map<String,Object> getInfo(@RequestBody SysUser sysUser){
        Map<String,Object> map = new HashMap<>();
        try {
            SysUser sysUserDB = sysUserService.getInfo(sysUser);
            map.put("uid",sysUserDB.getUid());
            map.put("uname",sysUserDB.getUname());
            map.put("birthday",sysUserDB.getBirthday());
            map.put("email",sysUserDB.getEmail());
            map.put("phone",sysUserDB.getPhone());
            map.put("role",sysUserDB.getRole());
            map.put("state",sysUserDB.getState());
            map.put("LLT",sysUserDB.getLastLoginTime());
            map.put("upwd",sysUserDB.getUpwd());
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }


    @PostMapping("/updateInfo")
    public Map<String,Object> updateInfo(@RequestBody SysUser sysUser){
        Map<String,Object>map = new HashMap<>();
        try {
            Integer updateDB = sysUserService.updateInfo(sysUser);
            if(updateDB != 0){
                map.put("state",true);
                map.put("msg","提示：修改信息成功");
            }else{
                map.put("state",false);
                map.put("msg","提示：修改信息失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示:"+e.getMessage());
        }
        return map;
    }


    /**
     * Put请求可以直接与对象类绑定，但需要参数名一致
     * @param uname
     * @return
     */
    @GetMapping("/update/{uname}")
    public String updatePwd(@PathVariable(value = "uname")String uname){
        Integer update = sysUserService.updatePwd(uname);
        if(update != 0){
            return "提示：修改密码成功";
        }else{
            return "提示：修改密码失败";
        }
    }


}