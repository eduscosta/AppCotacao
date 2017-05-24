package com.example.escosta.cotacaoapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.escosta.cotacaoapp.model.moedas.ARS;
import com.example.escosta.cotacaoapp.model.moedas.BTC;
import com.example.escosta.cotacaoapp.model.moedas.EUR;
import com.example.escosta.cotacaoapp.model.moedas.GBP;
import com.example.escosta.cotacaoapp.model.moedas.USD;

/**
 * Created by escosta on 23/05/2017.
 */

public class Valores implements Parcelable {

        private USD uSD;
        private EUR eUR;
        private ARS aRS;
        private GBP gBP;
        private BTC bTC;

        public USD getUSD() {
            return uSD;
        }

        public void setUSD(USD uSD) {
            this.uSD = uSD;
        }

        public EUR getEUR() {
            return eUR;
        }

        public void setEUR(EUR eUR) {
            this.eUR = eUR;
        }

        public ARS getARS() {
            return aRS;
        }

        public void setARS(ARS aRS) {
            this.aRS = aRS;
        }

        public GBP getGBP() {
            return gBP;
        }

        public void setGBP(GBP gBP) {
            this.gBP = gBP;
        }

        public BTC getBTC() {
            return bTC;
        }

        public void setBTC(BTC bTC) {
            this.bTC = bTC;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.uSD, flags);
        dest.writeParcelable(this.eUR, flags);
        dest.writeParcelable(this.aRS, flags);
        dest.writeParcelable(this.gBP, flags);
        dest.writeParcelable(this.bTC, flags);
    }

    public Valores() {
    }

    protected Valores(Parcel in) {
        this.uSD = in.readParcelable(USD.class.getClassLoader());
        this.eUR = in.readParcelable(EUR.class.getClassLoader());
        this.aRS = in.readParcelable(ARS.class.getClassLoader());
        this.gBP = in.readParcelable(GBP.class.getClassLoader());
        this.bTC = in.readParcelable(BTC.class.getClassLoader());
    }

    public static final Parcelable.Creator<Valores> CREATOR = new Parcelable.Creator<Valores>() {
        @Override
        public Valores createFromParcel(Parcel source) {
            return new Valores(source);
        }

        @Override
        public Valores[] newArray(int size) {
            return new Valores[size];
        }
    };
}
