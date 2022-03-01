package org.stellar.anchor.platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.stellar.anchor.config.*;
import org.stellar.anchor.config.AppConfig;
import org.stellar.anchor.config.Sep10Config;
import org.stellar.anchor.config.Sep1Config;
import org.stellar.anchor.filter.Sep10TokenFilter;
import org.stellar.anchor.horizon.Horizon;
import org.stellar.anchor.integration.customer.CustomerIntegration;
import org.stellar.anchor.sep1.Sep1Service;
import org.stellar.anchor.sep10.JwtService;
import org.stellar.anchor.sep10.Sep10Service;
import org.stellar.anchor.sep12.Sep12Service;

/** SEP configurations */
@Configuration
public class SepConfig {
  public SepConfig() {}

  /**
   * Register sep-10 token filter.
   *
   * @return Spring Filter Registration Bean
   */
  @Bean
  public FilterRegistrationBean<Sep10TokenFilter> sep10TokenFilter(
      @Autowired Sep10Config sep10Config, @Autowired JwtService jwtService) {
    FilterRegistrationBean<Sep10TokenFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(new Sep10TokenFilter(sep10Config, jwtService));
    registrationBean.addUrlPatterns("/sep12/*");
    return registrationBean;
  }

  @Bean
  public JwtService jwtService(AppConfig appConfig) {
    return new JwtService(appConfig);
  }

  @Bean
  public Horizon horizon(AppConfig appConfig) {
    return new Horizon(appConfig);
  }

  @Bean
  Sep1Service sep1Service(Sep1Config sep1Config) {
    return new Sep1Service(sep1Config);
  }

  @Bean
  Sep10Service sep10Service(
      AppConfig appConfig, Sep10Config sep10Config, Horizon horizon, JwtService jwtService) {
    return new Sep10Service(appConfig, sep10Config, horizon, jwtService);
  }

  @Bean
  Sep12Service sep12Service(
      AppConfig appConfig,
      Sep12Config sep12Config,
      JwtService jwtService,
      CustomerIntegration customerIntegration) {
    return new Sep12Service(appConfig, sep12Config, jwtService, customerIntegration);
  }
}