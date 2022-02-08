package com.ifood.iFood.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenProvider {

//        // Using anonymous user principal as its S2S authentication
//        public static final Authentication ANONYMOUS_USER_AUTHENTICATION =
//                new AnonymousAuthenticationToken(
//                        "key", "anonymous", AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));
//
//        private final OAuth2AuthorizedClientManager authorizedClientManager;
//
//        public String getAuthenticationToken(final String authZServerName) {
//            final OAuth2AuthorizeRequest request =
//                    OAuth2AuthorizeRequest.withClientRegistrationId(authZServerName)
//                            .principal(ANONYMOUS_USER_AUTHENTICATION)
//                            .build();
//            return "Bearer " + authorizedClientManager.authorize(request).getAccessToken().getTokenValue();
//        }
//    }

}
