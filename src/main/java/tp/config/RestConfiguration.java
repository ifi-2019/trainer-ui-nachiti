package tp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfiguration {
    @Value("${trainer.service.username}")
    private String user;
    @Value("${trainer.service.password}")
    private String password;

    public RestConfiguration() {
    }

/*	Utilisez l’injection de dépendance pour charger le user et password de l’API Trainers*/
    @Bean
    RestTemplate trainerApiRestTemplate(){
        RestTemplate  restTemplate = new RestTemplate();

        ClientHttpRequestInterceptor interceptor=new BasicAuthenticationInterceptor("user","03496bc9-11b1-470a-9f69-3ea8f11e5264");
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(interceptor);

        restTemplate.setInterceptors(interceptors);
        return restTemplate;

    }
/*	Construisez un RestTemplate avec un intercepteur BasicAuthenticationInterceptor*/
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}