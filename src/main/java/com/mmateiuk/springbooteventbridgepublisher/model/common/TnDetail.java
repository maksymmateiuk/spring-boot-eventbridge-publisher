package com.mmateiuk.springbooteventbridgepublisher.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class TnDetail {

    @JsonProperty("tn")
    private String tn;

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TnDetail tnDetail = (TnDetail) o;
        return Objects.equals(tn, tnDetail.tn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tn);
    }

    @Override
    public String toString() {
        return "TnDetail{" +
                "tn='" + tn + '\'' +
                '}';
    }
}
