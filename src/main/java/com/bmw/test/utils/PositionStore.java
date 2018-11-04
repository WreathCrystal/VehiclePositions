package com.bmw.test.utils;

import java.util.concurrent.ConcurrentHashMap;

import com.bmw.test.model.VehiclePosition;


/**
 * Author:  yutao.liu
 * Email:   coco8509@sina.com
 * Created on:   Nov 4, 2018
 *
 */
public class PositionStore {
	public static ConcurrentHashMap<String, ConcurrentHashMap<Integer,VehiclePosition>> positionsMap = new ConcurrentHashMap<String, ConcurrentHashMap<Integer, VehiclePosition>>();
}
