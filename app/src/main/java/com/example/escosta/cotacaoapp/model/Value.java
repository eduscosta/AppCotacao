package com.example.escosta.cotacaoapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by escosta on 23/05/2017.
 */

public class Value implements Parcelable {

        private boolean status;
        private Valores valores;

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public Valores getValores() {
            return valores;
        }

        public void setValores(Valores valores) {
            this.valores = valores;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.status ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.valores, flags);
    }

    public Value() {
    }

    protected Value(Parcel in) {
        this.status = in.readByte() != 0;
        this.valores = in.readParcelable(Valores.class.getClassLoader());
    }

    public static final Parcelable.Creator<Value> CREATOR = new Parcelable.Creator<Value>() {
        @Override
        public Value createFromParcel(Parcel source) {
            return new Value(source);
        }

        @Override
        public Value[] newArray(int size) {
            return new Value[size];
        }
    };
}