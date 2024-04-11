package api.privatBankApi;

import api.privatBankApi.pbResponseDto.CurrencyDto;
import api.privatBankApi.pbResponseDto.ExchangeRatesDto;

public class PBTestData {
    private static final String DATE = "01.12.2014";
    private static final String BANK = "PB";
    private static final int UAH_CODE = 980;
    private static final String UAH = "UAH";

    private static final CurrencyDto[] CURRENCIES = {
            new CurrencyDto(UAH, "AUD"),
            new CurrencyDto(UAH, "CAD"),
            new CurrencyDto(UAH, "CZK"),
            new CurrencyDto(UAH, "DKK"),
            new CurrencyDto(UAH, "HUF"),
            new CurrencyDto(UAH, "ILS"),
            new CurrencyDto(UAH, "JPY"),
            new CurrencyDto(UAH, "LVL"),
            new CurrencyDto(UAH, "LTL"),
            new CurrencyDto(UAH, "NOK"),
            new CurrencyDto(UAH, "SKK"),
            new CurrencyDto(UAH, "SEK"),
            new CurrencyDto(UAH, "CHF"),
            new CurrencyDto(UAH, "GBP"),
            new CurrencyDto(UAH, "USD"),
            new CurrencyDto(UAH, "BYR"),
            new CurrencyDto(UAH, "EUR"),
            new CurrencyDto(UAH, "GEL"),
            new CurrencyDto(UAH, "PLZ")
    };

    private static final ExchangeRatesDto exchangeRatesDto = new ExchangeRatesDto(DATE, BANK, UAH_CODE, UAH, CURRENCIES);

    public static ExchangeRatesDto getExchangeRatesDto() {
        return exchangeRatesDto;
    }
}
