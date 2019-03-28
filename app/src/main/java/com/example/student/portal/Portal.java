package com.example.student.portal;

import android.os.Parcel;
import android.os.Parcelable;

public class Portal implements Parcelable {
    private String portalURL;
    private String portalTitle;

    public Portal(String portalURL, String portalTitle) {
        this.portalURL = portalURL;
        this.portalTitle = portalTitle;
    }

    public String getPortalURL() {
        return portalURL;
    }

    public String getPortalTitle() {
        return portalTitle;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.portalURL);
        dest.writeString(this.portalTitle);
    }

    protected Portal(Parcel in) {
        this.portalURL = in.readString();
        this.portalTitle = in.readString();
    }

    public static final Creator<Portal> CREATOR = new Creator<Portal>() {
        @Override
        public Portal createFromParcel(Parcel source) {
            return new Portal(source);
        }

        @Override
        public Portal[] newArray(int size) {
            return new Portal[size];
        }
    };
}