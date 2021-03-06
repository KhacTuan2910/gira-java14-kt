package cyb.ot.javabackend.girajava14kt.common;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cyb.ot.javabackend.girajava14kt.common.util.ErrorUtil;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object obj, HttpStatus status) {
//		boolean hasErrors = false;
		Map<String, Object> map = new HashMap<String, Object>();
		
//		if (obj instanceof BindingResult) {
//			hasErrors = true;
//		}
//		
//		if (hasErrors) {
//			map.put("content", "");
//			map.put("errors", ErrorUtil.solveError((BindingResult) obj));
//		} else {
//			map.put("content", obj);
//			map.put("errors", "");
//		}
		
		// Contract with client
		map.put("content", obj);
		map.put("errors", "");
		map.put("hasErrors", false);
		map.put("pageIndex", 1);
		map.put("pageSize", 20);
		map.put("total", 20);
		map.put("responseTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
	
	public static ResponseEntity<Object> getErrorResponse(Object obj, HttpStatus status) {
		boolean hasErrors = false;
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (obj instanceof BindingResult) {
			map.put("errors", ErrorUtil.solveError((BindingResult) obj));
		} else {
			map.put("errors", obj);
		}
		
		// Contract with client
				map.put("content", "");
				map.put("hasErrors", true);
				map.put("pageIndex", 0);
				map.put("pageSize", 0);
				map.put("total", 0);
				map.put("responseTime", LocalDateTime.now().toLocalTime());
				map.put("httpStatus", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
}
