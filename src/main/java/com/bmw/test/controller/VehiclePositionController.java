package com.bmw.test.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bmw.test.model.VehiclePosition;
import com.bmw.test.service.VehiclePositionService;
import com.bmw.test.utils.Csv2VehiclePositions;


/**
 * Author:  yutao.liu
 * Email:   coco8509@sina.com
 * Created on:   Nov 4, 2018
 *
 */
@RestController
@RequestMapping("/vehicle")
public class VehiclePositionController {

	@Autowired
	private VehiclePositionService postionService;
		

	/**
	 * insert the json data 
 	 * @param s
	 */
	@PostMapping("/add")
	public void get(@RequestBody String jsonstr) {		
		Csv2VehiclePositions json2map = new Csv2VehiclePositions();
		json2map.storeVehiclePositions(jsonstr);		
	}

	/**
	 * 
	 * @param vehicleId
	 * @return
	 */
	@RequestMapping("/getAllSessions/{vehicleId}")
	public Object get1(@PathVariable String vehicleId) {
		Object res = postionService.getVehicleSession(vehicleId, 0);
		return res;
	}
	
	
	/**
	 * 
	 * @param vehicleId
	 * @param timestamp
	 * @return
	 */
	@RequestMapping("/getSingleSession/{vehicleId}/{timestamp}")
	public Object get2(@PathVariable String vehicleId, @PathVariable long timestamp) {
		Object res = postionService.getVehicleSession(vehicleId, timestamp);
		return res;
	}
	
	
	/**
	 * 
	 * @param vehicleId
	 * @return
	 */
	@RequestMapping("/getLastPosition/{vehicleId}")
	public Object get3(@PathVariable String vehicleId) {
		Object res = postionService.getVehicleSession(vehicleId, 1);
		return res;
	}
	
    /**
     * 
     * @param file
     * @return
     * @throws IOException
     */
	@PostMapping(value = "/fileUpload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		String fileName = null;
		Csv2VehiclePositions csv2map = new Csv2VehiclePositions();
		csv2map.csv2VehiclePostion(file.getInputStream());
		return "upload successfully!";
	}
}
