package com.example.escosta.cotacaoapp.model.moedas;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by escosta on 23/05/2017.
 */
public class BTC implements Parcelable {

    private String nome;
    private int valor;
    private int ultimaConsulta;
    private String fonte;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return String.valueOf("R$ " + valor);
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getUltimaConsulta() {
        Date dateTime = new Date((long)ultimaConsulta*1000);
        return String.valueOf(dateTime.getHours()+":"+dateTime.getMinutes());
    }

    public void setUltimaConsulta(int ultimaConsulta) {
        this.ultimaConsulta = ultimaConsulta;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeInt(this.valor);
        dest.writeInt(this.ultimaConsulta);
        dest.writeString(this.fonte);
    }

    public BTC() {
    }

    protected BTC(Parcel in) {
        this.nome = in.readString();
        this.valor = in.readInt();
        this.ultimaConsulta = in.readInt();
        this.fonte = in.readString();
    }

    public static final Parcelable.Creator<BTC> CREATOR = new Parcelable.Creator<BTC>() {
        @Override
        public BTC createFromParcel(Parcel source) {
            return new BTC(source);
        }

        @Override
        public BTC[] newArray(int size) {
            return new BTC[size];
        }
    };
}
