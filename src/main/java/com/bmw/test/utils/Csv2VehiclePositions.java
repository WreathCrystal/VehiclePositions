package com.bmw.test.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

import com.bmw.test.model.VehiclePosition;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


/**
 * Author:  yutao.liu
 * Email:   coco8509@sina.com
 * Created on:   Nov 4, 2018
 *
 */
public class Csv2VehiclePositions {

	/** 
	 * @param file
	 * @throws IOException
	 */
	public void csv2VehiclePosition(InputStream file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
		String str = null;
		ConcurrentHashMap<String, ConcurrentHashMap<Integer, VehiclePosition>> dataMap = PositionStore.positionsMap;
		while ((str = bufferedReader.readLine()) != null) {
			if (!str.startsWith("timestamp")) {
				VehiclePosition position = string2VehiclePosition(str);
				ConcurrentHashMap dataMapByVehicle = dataMap.get(position.getVehicleId());
				if (null == dataMapByVehicle) {
					dataMapByVehicle = new ConcurrentHashMap();
				}
				dataMapByVehicle.putIfAbsent(position.getTime(), position);
				dataMap.putIfAbsent(position.getVehicleId(), dataMapByVehicle);
			}
		}
		file.close();
		bufferedReader.close();

	}

	private VehiclePosition string2VehiclePosition(String in) {
		String[] attrArray = in.split(",");
		VehiclePosition v = new VehiclePosition();
		if (attrArray.length == 6) {
			v.setTime(Long.parseLong(attrArray[0]));
			v.setVehicleId((String) attrArray[1]);
			v.setSession((String) attrArray[2]);
			v.setLat(Double.parseDouble(attrArray[3]));
			v.setLon(Double.parseDouble(attrArray[4]));
			v.setHeading(Integer.parseInt(attrArray[5]));
		}
		return v;
	}

	/**
	 * 
	 * @param jsonstr
	 */
	public void storeVehiclePositions(String jsonstr) {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray Jarray = parser.parse(jsonstr).getAsJsonArray();
		ConcurrentHashMap<String, ConcurrentHashMap<Integer, VehiclePosition>> dataMap = PositionStore.positionsMap;
		for (JsonElement obj : Jarray) {
			VehiclePosition position = gson.fromJson(obj, VehiclePosition.class);
			ConcurrentHashMap dataMapByVehicle = dataMap.get(position.getVehicleId());
			if (null == dataMapByVehicle) {
				dataMapByVehicle = new ConcurrentHashMap();
			}
			dataMapByVehicle.putIfAbsent(position.getTime(), position);
			dataMap.putIfAbsent(position.getVehicleId(), dataMapByVehicle);

		}
	}

}
