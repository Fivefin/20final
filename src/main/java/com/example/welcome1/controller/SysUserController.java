package com.example.welcome1.controller;


import com.example.welcome1.entity.SysUser;
import com.example.welcome1.response.ResponseResult;
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
import java.util.List;
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
            map.put("state",200);
            map.put("msg","登录成功");
            map.put("sysUser",sysUserDB);
            map.put("path","/main");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",500);
            map.put("msg",e.getMessage());
            map.put("path","/404  ");
        }
        return map;
    }
    /**
     *用来处理用户注册
     */
//,String code,HttpServletRequest request
    @RequestMapping("register")
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
     * 获取个人资料
     */
    @RequestMapping("/get")
    public ResponseResult getInfo(@RequestBody SysUser sysUser){
        ResponseResult responseResult = new ResponseResult();
        try {
            SysUser sysUserDB = sysUserService.getInfo(sysUser);
            return ResponseResult.SUCCESS().setData(sysUserDB);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseResult.FAILED();
    }


    /**
     * 修改用户个人信息
     * @param sysUser
     * @return
     */
    @RequestMapping("/update")
    public ResponseResult updateInfo(@RequestBody SysUser sysUser){
        try {
            int updateDB = sysUserService.updateInfo(sysUser);
            if(updateDB != 0){
                return ResponseResult.SUCCESS("修改信息成功").setData(updateDB);
            }else{
                return ResponseResult.FAILED("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
        return ResponseResult.FAILED("修改失败");
    }


    /**
     * 根据uname修改密码
     * @param uname
     * @return
     */
    @RequestMapping("/updatePwd/{uname}")
    public ResponseResult updatePwd(@PathVariable(value = "uname")String uname){

        try {
            int updateDB = sysUserService.updatePwd(uname);
            if(updateDB != 0){
                return ResponseResult.SUCCESS("修改信息成功").setData(updateDB);
            }else{
                return ResponseResult.FAILED("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
        return ResponseResult.FAILED("修改失败");
    }

    /**
     * 根据uid冻结用户
     * @param uid
     * @return
     */
    @RequestMapping("/closeByuid/{uid}")
    public ResponseResult closeByUid(@PathVariable(value = "uid")String uid){
        try {
            int updateDB = sysUserService.closeByUid(uid);
            if(updateDB != 0){
                return ResponseResult.SUCCESS("修改成功").setData(updateDB);
            }else{
                return ResponseResult.FAILED("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseResult.FAILED("修改失败");
    }
    /**
     * 根据role查询用户
     * @param role
     * @return
     */
    @RequestMapping("/findByRole")
    public ResponseResult findByRole(@PathVariable(value = "role")String role){
        List<SysUser> users = sysUserService.listByRole(role);
        if(null==users){
            return ResponseResult.FAILED("查询用户成功");
        }else{
            return ResponseResult.SUCCESS("查询用户失败").setData(users);
        }

    }
}