package api.privatBankApi.pbResponseDto;

import java.util.Arrays;

public class ExchangeRatesDto {
    String date;
    String bank;
    int baseCurrency;
    String baseCurrencyLit;
    CurrencyDto[] exchangeRate;

    public ExchangeRatesDto(String date, String bank, int baseCurrency, String baseCurrencyLit, CurrencyDto[] exchangeRate) {
        this.date = date;
        this.bank = bank;
        this.baseCurrency = baseCurrency;
        this.baseCurrencyLit = baseCurrencyLit;
        this.exchangeRate = exchangeRate;
    }

    public ExchangeRatesDto() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(int baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public CurrencyDto[] getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(CurrencyDto[] exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "ExchangeRatesDto{" +
                "date='" + date + '\'' +
                ", bank='" + bank + '\'' +
                ", baseCurrency=" + baseCurrency +
                ", baseCurrencyLit='" + baseCurrencyLit + '\'' +
                ", exchangeRate=" + Arrays.toString(exchangeRate) +
                '}';
    }
}
