package cz.muni.fi.pa165;

import cz.muni.fi.pa165.currency.CurrencyConvertor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Currency;

public class MainJavaConfig {

    public static void main(String ... args) {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringJavaConfig.class);

        CurrencyConvertor currencyConvertor = applicationContext.getBean(CurrencyConvertor.class);

        System.out.println("Converted currency: " +
                currencyConvertor.convert(Currency.getInstance("EUR"), Currency.getInstance("CZK"), BigDecimal.ONE));
    }
}
