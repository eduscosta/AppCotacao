package com.example.escosta.cotacaoapp.model.moedas;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by escosta on 23/05/2017.
 */
public class ARS implements Parcelable {

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
        dest.writeString(this.nome);
        dest.writeFloat(this.valor);
        dest.writeInt(this.ultimaConsulta);
        dest.writeString(this.fonte);
    }

    public ARS() {
    }

    protected ARS(Parcel in) {
        this.nome = in.readString();
        this.valor = in.readFloat();
        this.ultimaConsulta = in.readInt();
        this.fonte = in.readString();
    }

    public static final Parcelable.Creator<ARS> CREATOR = new Parcelable.Creator<ARS>() {
        @Override
        public ARS createFromParcel(Parcel source) {
            return new ARS(source);
        }

        @Override
        public ARS[] newArray(int size) {
            return new ARS[size];
        }
    };
}
