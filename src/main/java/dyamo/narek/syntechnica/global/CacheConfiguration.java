package dyamo.narek.syntechnica.global;

import com.github.benmanes.caffeine.cache.Caffeine;
import dyamo.narek.syntechnica.security.auth.tokens.access.AccessTokenConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration {

	@Bean
	public CacheManager accessTokenMetadataCacheManager(AccessTokenConfigurationProperties accessTokenProperties) {
		var caffeine = Caffeine.newBuilder()
				.expireAfterWrite(accessTokenProperties.getExpirationTime());

		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(caffeine);

		return cacheManager;
	}

}