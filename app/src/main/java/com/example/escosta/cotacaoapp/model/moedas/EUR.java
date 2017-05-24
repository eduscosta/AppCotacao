package com.example.escosta.cotacaoapp.model.moedas;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by escosta on 23/05/2017.
 */

public class EUR implements Parcelable {

    private String nome;
    private float valor;
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

    public void setValor(float valor) {
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
        dest.writeString(this.fonte);
        dest.writeFloat(this.valor);
        dest.writeInt(this.ultimaConsulta);
        dest.writeString(this.nome);
    }

    public EUR() {
    }

    protected EUR(Parcel in) {
        this.fonte = in.readString();
        this.valor = in.readFloat();
        this.ultimaConsulta = in.readInt();
        this.nome = in.readString();
    }

    public static final Parcelable.Creator<EUR> CREATOR = new Parcelable.Creator<EUR>() {
        @Override
        public EUR createFromParcel(Parcel source) {
            return new EUR(source);
        }

        @Override
        public EUR[] newArray(int size) {
            return new EUR[size];
        }
    };
}
