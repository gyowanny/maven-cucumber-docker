package com.thequizz.api.model;

public class Coordinate {

    private Double altitude;

    private Double longitude;

    public Coordinate(Double altitude, Double longitude) {
        this.altitude = altitude;
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (altitude != null ? !altitude.equals(that.altitude) : that.altitude != null) return false;
        return longitude != null ? longitude.equals(that.longitude) : that.longitude == null;

    }

    @Override
    public int hashCode() {
        int result = altitude != null ? altitude.hashCode() : 0;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "altitude=" + altitude +
                ", longitude=" + longitude +
                '}';
    }
}
