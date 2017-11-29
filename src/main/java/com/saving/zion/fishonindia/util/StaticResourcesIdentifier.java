package com.saving.zion.fishonindia.util;

import javax.servlet.http.HttpServletRequest;

public class StaticResourcesIdentifier {

	static String[] StaticResourceSuffixList =  new String[] {
														".css",
														".js",
														".img",
														".xml",
														".gif",
														".png",
														".jpg",
														".jpeg",
														".svg",
														".eot",
														".ttf",
														".woff",
														".db",
														".htaccess",
														".pdf",
														};
														
	
	public static boolean isResourceStatic(HttpServletRequest request){
		String reqUri = request.getRequestURI();
		for(int i = 0;i<StaticResourceSuffixList.length;i++)
			if(reqUri.endsWith(StaticResourceSuffixList[i]))
				return true;
		return false;
	}
}
