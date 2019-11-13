package com.se.device.controller;

import com.se.device.entity.Device;
import com.se.device.service.DeviceService;
import com.se.device.utils.JsonResult;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/*
    device的crud
    这里所有的url参照restful风格

*/

@Controller
@RequestMapping("/api")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    //获取所有的device信息
    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getAllDevices(@RequestParam int page, @RequestParam int limit){
        //I should build service, but it's late
        int begin = (page-1)*limit;
        int end = limit;
        String count = String.valueOf(deviceService.count());
        List<Device> devices = deviceService.findAllByPage(begin, end);
        JsonResult<List<Device>> jsonResult = new JsonResult(devices);
        jsonResult.setCount(count);
        jsonResult.setCode("0");
        return jsonResult;
    }


    //获取单个device
    @RequestMapping(value = "/devices/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getOneDevice(@PathVariable Integer id){
        Device device = deviceService.findOneById(id);
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", "200");
        res.put("msg", "获取成功");
        res.put("data", device);

        return res;
    }


    //删除一个device
    @RequestMapping(value = "/devices/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteOneDevice(@PathVariable Integer id){
        HashMap<String, Object> res = new HashMap<>();

        if(id > 0){
            deviceService.deleteById(id);
            res.put("code", "200");
            res.put("msg", "操作成功");
        }else{
            res.put("code", "204");       //no content
            res.put("msg", "操作失败,ID错误!");
        }
        return res;
    }

    //更新一个device
    @RequestMapping(value = "/devices/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateOneDevice(@PathVariable Integer id, @RequestBody Device device){
        return null;
    }

    //新增一个device
    @RequestMapping(value = "/devices", method = RequestMethod.POST)
    @ResponseBody
    public Object insertOneDevice(@RequestBody Device device){
        HashMap<String, Object> res = new HashMap<>();
        try {
            deviceService.save(device);
            res.put("code", "201");
            res.put("msg", "insert device successful!");
        }catch (Exception e){
            res.put("code", "500");
            res.put("msg", e.toString());
        }
        return res;
    }


}