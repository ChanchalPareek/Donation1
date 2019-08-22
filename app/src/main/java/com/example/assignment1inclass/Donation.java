package com.example.assignment1inclass;

import android.os.Parcel;
import android.os.Parcelable;

public class Donation implements Parcelable {

    private String name;
    private int amount;

    public Donation(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    protected Donation(Parcel in) {
        name = in.readString();
        amount = in.readInt();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(amount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
        @Override
        public Donation createFromParcel(Parcel in) {
            return new Donation(in);
        }

        @Override
        public Donation[] newArray(int size) {
            return new Donation[size];
        }
    };



    public  String getName() {
        return name;
    }

    public  int getAmount() {
        return amount;
    }

}
