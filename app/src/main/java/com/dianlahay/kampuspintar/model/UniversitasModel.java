package com.dianlahay.kampuspintar.model;

public class UniversitasModel {
    private int Id;
    private String namaUniversitas;
    private String akreditas;
    private String status;
    private String jenis;
    private String alamat;
    private String kota;
    private String provinsi;
    private String website;



    public UniversitasModel(int universitasID, String namaUniversitas, String akreditas, String status) {
        this.Id = universitasID;
        this.namaUniversitas = namaUniversitas;
        this.akreditas = akreditas;
        this.status = status;
        this.jenis = jenis;
        this.alamat = alamat;
        this.kota = kota;
        this.provinsi = provinsi;
        this.website = website;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }

    public String getNamaUniversitas() {
        return namaUniversitas;
    }
    public void setNamaUniversitas(String namaUniversitas) {
        this.namaUniversitas = namaUniversitas;
    }

    public String getAkreditas() {
        return akreditas;
    }
    public void setAkreditas(String akreditas) {
        this.akreditas = akreditas;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }
    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

}
