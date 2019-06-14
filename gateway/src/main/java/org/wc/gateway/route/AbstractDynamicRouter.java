package org.wc.gateway.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WenChen on 2019/6/13.
 */
public abstract class AbstractDynamicRouter extends SimpleRouteLocator implements RefreshableRouteLocator {

    private Logger logger = LoggerFactory.getLogger(AbstractDynamicRouter.class);

    public AbstractDynamicRouter(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    public void refresh() {
        doRefresh();
        logger.info("Dynamic Route Has Refresh.");
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String,ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
        routes.putAll(super.locateRoutes());
        List<ZuulProperties.ZuulRoute> results = readRoutes();
        results.forEach(route->routes.put(route.getPath(),route));
        logger.info("Dynamic Route Load Success.");
        return routes;
    }

    protected abstract List<ZuulProperties.ZuulRoute> readRoutes();
}
