package com.mp.springboot.jedis.config;



import com.mp.springboot.jedis.model.Programmer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

@Configuration
public class SpringConfig {


    @Value("${redis.host}")
    private String host;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.port}")
    private int port;

    @Value("${redis.jedis.pool.max-total}")
    private int maxTotal;
    @Value("${redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${redis.jedis.pool.min-idle}")
    private int minIdle;

    @Bean
    public JedisClientConfiguration getJedisClientConfiguration(){
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisPoolingClientConfigurationBuilder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration
                .builder();
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(maxTotal);
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        return jedisPoolingClientConfigurationBuilder.poolConfig(genericObjectPoolConfig).build();
    }


    @Bean
    public JedisConnectionFactory getJedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);

        if(!StringUtils.isEmpty(password))
            redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

        redisStandaloneConfiguration.setPort(port);
        return new JedisConnectionFactory(redisStandaloneConfiguration,getJedisClientConfiguration());
    }

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(getJedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer()); //If we use String as a key, use this
//   	redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//      redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//      redisTemplate.setHashValueSerializer(new StringRedisSerializer()));
        return redisTemplate;
    }

    @Bean
    @Qualifier("listOperations") //take care if the other bean with the same type exists
    public ListOperations<String, Programmer> listOperations(RedisTemplate<String, Programmer> redisTemplate){
        return redisTemplate.opsForList();
    }

    @Bean
    @Qualifier("setOperations") //take care if the other bean with the same type exists
    public SetOperations<String, Programmer> setOperations(RedisTemplate<String, Programmer> redisTemplate){
        return redisTemplate.opsForSet();
    }


    @Bean
    @Qualifier("hashOperation")
    public HashOperations<String, Integer, Programmer> hashOperations(RedisTemplate<String, Programmer> redisTemplate){
        // String is a redis key, Integer is a key for hash, Programmer is the value
        return redisTemplate.opsForHash();
    }

}
