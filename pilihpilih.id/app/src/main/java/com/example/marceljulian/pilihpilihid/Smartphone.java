package com.example.marceljulian.pilihpilihid;

public class Smartphone {
    private String baterai;
    private String cpu;
    private String gambarHpUrl;
    private String id;
    private String kamera;
    private String layar;
    private String merk;
    private String os;
    private String ram;
    private String type;
    private String chipset;
    private String internal;
    private String kameradpn;
    private String gpu;

    public Smartphone(){

    }

    public Smartphone(String baterai, String cpu, String gambarHpUrl, String id, String kamera, String layar, String merk, String os, String ram, String type,String chipset, String internal, String kameradpn, String gpu) {
        this.baterai = baterai;
        this.cpu = cpu;
        this.setGambarHpUrl(gambarHpUrl);
        this.id = id;
        this.kamera = kamera;
        this.layar = layar;
        this.merk = merk;
        this.os = os;
        this.ram = ram;
        this.type = type;
        this.chipset = chipset;
        this.internal = internal;
        this.kameradpn = kameradpn;
        this.gpu = gpu;
    }

    public String getBaterai() {
        return baterai;
    }

    public void setBaterai(String baterai) {
        this.baterai = baterai;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKamera() {
        return kamera;
    }

    public void setKamera(String kamera) {
        this.kamera = kamera;
    }

    public String getLayar() {
        return layar;
    }

    public void setLayar(String layar) {
        this.layar = layar;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGambarHpUrl() {
        return gambarHpUrl;
    }

    public void setGambarHpUrl(String gambarHpUrl) {
        this.gambarHpUrl = gambarHpUrl;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String getKameradpn() {
        return kameradpn;
    }

    public void setKameradpn(String kameradpn) {
        this.kameradpn = kameradpn;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }
}

