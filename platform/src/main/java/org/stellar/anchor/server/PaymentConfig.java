package org.stellar.anchor.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.stellar.anchor.paymentservice.PaymentGateway;
import org.stellar.anchor.paymentservice.circle.CirclePaymentService;
import org.stellar.anchor.paymentservice.circle.config.CirclePaymentConfig;
import org.stellar.anchor.paymentservice.circle.config.StellarPaymentConfig;

/** Payment gateway configurations. */
@Configuration
public class PaymentConfig {
  @Bean
  PaymentGateway paymentGateway(
      CirclePaymentConfig circlePaymentConfig, StellarPaymentConfig stellarPaymentConfig) {
    PaymentGateway.Builder builder = new PaymentGateway.Builder();
    if (circlePaymentConfig.isEnabled()) {
      builder.add(new CirclePaymentService(circlePaymentConfig));
    }

    //        TODO: Te be added when StellarPaymentService is implemented.
    //        if (stellarPaymentConfig.isEnabled()) {
    //            builder.add(new StellarPaymentService(stellarPaymentConfig));
    //        }

    return builder.build();
  }
}
