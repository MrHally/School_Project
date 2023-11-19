import { Component } from '@angular/core';
import { Currency } from 'src/currency';

interface ExchangeRates {
  VND: number;
  USD: number;
  CAD: number;
  CNY: number;
  WON: number;
  YEN: number;
  EURO: number;
  ESP: number;
  SEK: number;
  RUP: number;
  SGD: number;
  BTC: number;
  ETH: number;
  USDT: number;
  BNB: number;
}

interface ConversionResult {
  result: number;
  amount: number;
  tocurrent: string;
  fromcurrent: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  readonly Url = 'BaoCao/ChuyenDoiTienTe/image/currency';
  Currencys: Currency[] = [
    {
      name: 'VND',
      exchangerate: 1,
      icon: 'vietnam.png',
      variable: 'đ'
    },
    {
      name: 'USD',
      exchangerate: 0.000043,
      icon: 'united-states.png',
      variable: '$'
    },
    {
      name: 'CAD',
      exchangerate: 0.000054,
      icon: 'canada.png',
      variable: '$'
    },
    {
      name: 'CNY',
      exchangerate: 0.00028,
      icon: 'china.png',
      variable: '¥'
    },
    {
      name: 'WON',
      exchangerate: 0.048,
      icon: 'soth-korea.png',
      variable: '₩'
    },
    {
      name: 'YEN',
      exchangerate: 0.00039,
      icon: 'japan.png',
      variable: '¥'
    },
    {
      name: 'EURO',
      exchangerate: 0.000038,
      icon: 'european-union.png',
      variable: '€'
    },
    {
      name: 'ESP',
      exchangerate: 0.000047,
      icon: 'spain.png',
      variable: '€'
    },
    {
      name: 'MYR',
      exchangerate: 0.00019,
      icon: 'malaysia.png',
      variable: 'RM'
    },
    {
      name: 'RUP',
      exchangerate: 0.00058,
      icon: 'russia.png',
      variable: '₨'
    },
    {
      name: 'SGD',
      exchangerate: 0.000032,
      icon: 'singapore.png',
      variable: '$'
    },
    {
      name: 'BTC',
      exchangerate: 65000,
      icon: 'bitcoin.png',
      variable: '₿'
    },
    {
      name: 'ETH',
      exchangerate: 4000,
      icon: 'ethereum.png',
      variable: '⧫'
    },
    {
      name: 'USDT',
      exchangerate: 1,
      icon: 'tether.png',
      variable: '₮'
    },
    {
      name: 'BNB',
      exchangerate: 500,
      icon: 'binance.png',
      variable: '$'
    }
  ];
  amount: number = 0;
  private baseAmount: number = 0;
  result: number = 0;
  fromCurrency: number = 1;
  toCurrency: number = 1;

  constructor() {
    const savedAmount = localStorage.getItem('amount');
    const savedFromCurrency = localStorage.getItem('fromCurrency');
    const savedToCurrency = localStorage.getItem('toCurrency');

    this.amount = savedAmount ? parseFloat(savedAmount) : 1;
    this.fromCurrency = savedFromCurrency ? parseFloat(savedFromCurrency) : 1;
    this.toCurrency = savedToCurrency ? parseFloat(savedToCurrency) : 1;
  }

  convertCurrency(): ConversionResult  {
    this.baseAmount = this.amount / this.fromCurrency;
    this.result = this.baseAmount * this.toCurrency;

    localStorage.setItem('amount', this.amount.toString());
    localStorage.setItem('fromCurrency', this.fromCurrency.toString());
    localStorage.setItem('toCurrency', this.toCurrency.toString());

    // Find the selected currency object
    const fromCurrencyObject = this.Currencys.find(currency => currency.exchangerate === this.fromCurrency);
    const toCurrencyObject = this.Currencys.find(currency => currency.exchangerate === this.toCurrency);

    return {result : this.result, amount: this.amount, tocurrent : (toCurrencyObject ? toCurrencyObject.variable : ''), fromcurrent: (fromCurrencyObject ? fromCurrencyObject.variable : '')};
  }

  setFromCurrency(fromCurrency: number): void {
    this.fromCurrency = fromCurrency;
  }

  setToCurrency(toCurrency: number): void {
    this.toCurrency = toCurrency;
  }

  onCurrencyChange(): void {
    location.reload();
  }

  switch(): void {
    [this.fromCurrency, this.toCurrency] = [this.toCurrency, this.fromCurrency];

    window.location.reload();
  }

}
