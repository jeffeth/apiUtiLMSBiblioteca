package com.fmp.spring5.fmp.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthoritationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private InfoAdicionalToken infoAdicionalToken;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	// aqui se configuran los permisos de accesos de los endpoint que tendra angular
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//-----------
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient("bibliotecaApp")// nombre de la aplicacion que se va a conectar
		.secret(passwordEncoder.encode("123456"))// contraseña con la cual la aplicacion va a ingresar al api rest
		.scopes("read","write")
		.authorizedGrantTypes("password","refresh_token")
		.and()
		.inMemory().withClient("lmsApp")
		.secret(passwordEncoder.encode("123456"))// contraseña con la cual la aplicacion va a ingresar al api rest
		.scopes("read","write")
		.authorizedGrantTypes("password","refresh_token")
		.secret(null)
		.accessTokenValiditySeconds(7200)// 3600 segundos = 1 hora que podra estar dendro del sistema
		.refreshTokenValiditySeconds(7200);// aqui tambien se valida que sea una hora para comparar
		
	}

	// se encarga de validar e iniciar sesion y entregar tokens de validadcion
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		TokenEnhancerChain tokenEnhancer = new TokenEnhancerChain();
		tokenEnhancer.setTokenEnhancers(Arrays.asList(infoAdicionalToken,accessTokenConverter()));
		
		endpoints.authenticationManager(authenticationManager).accessTokenConverter(accessTokenConverter())
		.tokenEnhancer(tokenEnhancer);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {

		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVADA);
		jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA);
		return jwtAccessTokenConverter ;
	}
	
	
}
