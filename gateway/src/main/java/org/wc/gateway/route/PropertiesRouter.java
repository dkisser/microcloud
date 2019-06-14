package org.wc.gateway.route;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.wc.gateway.Constants;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by WenChen on 2019/6/13.
 */
public class PropertiesRouter extends AbstractDynamicRouter {

    private Logger logger = LoggerFactory.getLogger(PropertiesRouter.class);

    public PropertiesRouter(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    protected List<ZuulProperties.ZuulRoute> readRoutes() {
        List<ZuulProperties.ZuulRoute> routes = Lists.newArrayListWithCapacity(5);
        Properties prop = new Properties();
        try {
            prop.load(
                PropertiesRouter.class.getClassLoader().getResourceAsStream(Constants.DYNAMIC_ROUTE_FILE_PATH)
            );
        } catch (IOException e) {
            logger.error("load properties error,{}",e);
        }
        Map<String,String> map = new HashMap<>((Map)prop);
        List<String> ids=map.keySet().stream()
                .map(str->str.substring(str.indexOf(".",Constants.ROUTE_PREFIX.length())+1,str.lastIndexOf(".")))
                .distinct().collect(Collectors.toList());
        ids.forEach(id ->{
            String path,serviceId,url,retryAble,stripPrefix;
            ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
            path = map.get(String.join(".",Constants.ROUTE_PREFIX,id,"path"));
            path=path.startsWith("/") ? path : "/"+path;
            serviceId = map.getOrDefault(String.join(".",Constants.ROUTE_PREFIX,id,"serviceId"),null);
            url = map.getOrDefault(String.join(".",Constants.ROUTE_PREFIX,id,"url"),null);
            retryAble = map.getOrDefault(String.join(".",Constants.ROUTE_PREFIX,id,"retry-able"),"false");
            stripPrefix = map.getOrDefault(String.join(".",Constants.ROUTE_PREFIX,id,"strip-prefix"),"false");
            route.setId(id);
            route.setPath(path);
            route.setUrl(url);
            route.setServiceId(StringUtils.isBlank(url)&&StringUtils.isBlank(serviceId)?id:serviceId);
            route.setRetryable(Boolean.parseBoolean(retryAble));
            route.setStripPrefix(Boolean.parseBoolean(stripPrefix));
            routes.add(route);
        });
        return routes;
    }

}
