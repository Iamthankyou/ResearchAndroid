package com.example.lequangduy_181203460;

public class Taxi_LeQuangDuy {
    private int id;
    private String soXe;
    private Double quangDuong;
    private int donGia, khuyenMai;

    public Taxi_LeQuangDuy(int id, String soXe, Double quangDuong, int donGia, int khuyenMai) {
        this.id = id;
        this.soXe = soXe;
        this.quangDuong = quangDuong;
        this.donGia = donGia;
        this.khuyenMai = khuyenMai;
    }

    public Taxi_LeQuangDuy(String soXe, Double quangDuong, int donGia, int khuyenMai) {
        this.soXe = soXe;
        this.quangDuong = quangDuong;
        this.donGia = donGia;
        this.khuyenMai = khuyenMai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    public Double getQuangDuong() {
        return quangDuong;
    }

    public void setQuangDuong(Double quangDuong) {
        this.quangDuong = quangDuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(int khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
}
