package com.bmw.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.bmw.test.model.VehiclePosition;
import com.bmw.test.utils.PositionStore;


/**
 * Author:  yutao.liu
 * Email:   coco8509@sina.com
 * Created on:   Nov 4, 2018
 *
 */

@Component
public class VehiclePositionService {
	/**
	 * 
	 * @param vehicleId
	 * @param timestamp
	 * @return 
	 */
	public Object getVehicleSession(String vehicleId, long timestamp) {
		ConcurrentHashMap dataMap = PositionStore.positionsMap;
		Object sessions = null;
		if (null != vehicleId) {
			ConcurrentHashMap positionMap = (ConcurrentHashMap) dataMap.get(vehicleId);
			if (null == positionMap) {
				return "";
			}
			Enumeration sessionSet = positionMap.keys();
			switch (timestamp + "") {
			case 0 + "":
				/**
				 * all sessions without duplication ordered by timestamp desc
				 */
				TreeSet values = new TreeSet();
				while (sessionSet.hasMoreElements()) {
					values.add(((VehiclePosition) positionMap.get(sessionSet.nextElement())).getSession());
				}
				sessions = values;
				break;
			case 1 + "":
				/**
				 * the last position , the first record of the sessionList ordered by timestamp
				 * desc
				 */
				ArrayList<Long> sessionList = Collections.list(sessionSet);
				Collections.sort(sessionList, new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						long timestamp1 = Long.parseLong(String.valueOf(o1));
						long timestamp2 = Long.parseLong(String.valueOf(o2));
						if (timestamp1 > timestamp2) {
							return -1;
						}
						if (timestamp1 < timestamp2) {
							return 1;
						}
						return 0;
					}
				});
				if (null != sessionList && sessionList.size() > 0) {
					VehiclePosition v = (VehiclePosition) positionMap.get(sessionList.get(0));
					sessions = v.getSession();
				}
				break;
			default:
				/**
				 * a single session by querystring = timestamp && vehicleId
				 */
				VehiclePosition v = (VehiclePosition) positionMap.get(timestamp);
				sessions = v.getSession();
			}

		}
		return sessions;
	}

}
