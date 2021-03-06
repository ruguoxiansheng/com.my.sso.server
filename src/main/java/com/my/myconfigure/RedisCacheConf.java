package com.my.myconfigure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisCacheConf extends CachingConfigurerSupport {
	@Autowired
	private RedisTemplate redisTemplate;

	private static final Log log = LogFactory.getLog(RedisConf.class);

	/**
	 * 配置redis缓存管理对象
	 * 
	 * @return
	 */
	@Bean(name = "cacheManager")
	public CacheManager cacheManager() {
		log.info("初始化CacheManager");
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//		cacheManager.setDefaultExpiration(360);
		// Map<String, Long> expires = new HashMap<>();
		// expires.put("tokenInfo", 36000L);
		// cacheManager.setExpires(expires);
		// // 设置缓存过期时间
		// cacheManager.setDefaultExpiration(10000);
		return cacheManager;
	}
	// /**
	// * 生成key的策略
	// 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
	// *
	// * @return
	// */
	// @Bean
	// public KeyGenerator keyGenerator() {
	// return new KeyGenerator() {
	// @Override
	// public Object generate(Object target, Method method, Object... params) {
	// StringBuilder sb = new StringBuilder();
	// sb.append(target.getClass().getName());
	// sb.append(method.getName());
	// for (Object obj : params) {
	// sb.append(obj.toString());
	// }
	// return sb.toString();
	// }
	// };
	// }
}
