package com.fmp.spring5.fmp.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.fmp.spring5.fmp.models.entity.Usuario;
import com.fmp.spring5.fmp.models.services.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer {
	
	@Autowired
	private IUsuarioService userService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Usuario usuario = userService.findByCorreo(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("usuario", "".concat(authentication.getName()));
		
		info.put("nombre_usuario",  usuario.getNombre());
		info.put("usuario_id", usuario.getId());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
	

}
