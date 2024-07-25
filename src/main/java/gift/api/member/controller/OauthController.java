package gift.api.member.controller;

import gift.api.member.config.KakaoProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/oauth")
public class OauthController {

    private final KakaoProperties kakaoProperties;

    public OauthController(KakaoProperties kakaoProperties) {
        this.kakaoProperties = kakaoProperties;
    }

    @GetMapping
    public String requestLogin() {
        return "oauth";
    }

    @GetMapping("/kakao")
    public RedirectView requestAuthorizationCode() {
        return new RedirectView(
            String.format(kakaoProperties.url().requestFormat(),
                kakaoProperties.url().redirect(), kakaoProperties.clientId()));
    }
}
