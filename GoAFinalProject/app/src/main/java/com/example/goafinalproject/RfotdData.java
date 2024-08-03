package com.example.goafinalproject;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class RfotdData {

    private String rfotdtitle;
    private String rfotddescription;
    private Bitmap rfotdphoto;

    public RfotdData(String rfotdtitle, String rfotddescription, Bitmap rfotdphoto) {
        this.rfotdtitle = rfotdtitle;
        this.rfotddescription = rfotddescription;
        this.rfotdphoto = rfotdphoto;
    }

    public String getRfotdtitle() {
        return rfotdtitle;
    }

    public void setRfotdtitle(String rfotdtitle) {
        this.rfotdtitle = rfotdtitle;
    }

    public String getRfotddescription() {
        return rfotddescription;
    }

    public void setRfotddescription(String rfotddescription) {
        this.rfotddescription = rfotddescription;
    }

    public Bitmap getRfotdphoto() {
        return rfotdphoto;
    }

    public void setRfotdphoto(Bitmap rfotdphoto) {
        this.rfotdphoto = rfotdphoto;
    }

    @Override
    public String toString() {
        return "RfotdData{" +
                "rfotdtitle='" + rfotdtitle + '\'' +
                ", rfotddescription='" + rfotddescription + '\'' +
                ", rfotdphoto=" + rfotdphoto +
                '}';
    }


}
