package com.restapiSiswa.restapi.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
@Entity
@Table(name = "siswa")
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer point;

    public Siswa(){}
    public Siswa(Long id, Integer point, String nik, String nis, String nama, String email, String noHp, String password, String jk, Date ttl, String prov, String kab, String alamat, String namaAyah, String namaIbu, String pekAyah, String pekIbu, String namaWali, String pekWali, String pengOrtu, String noTelp, Integer thnMsk, String sekolahAsal, String kelas, String imgSiswa, String imgKk, String imgIjazah, String imgKtp, Integer idPend, Integer idMajors, Integer idKelas, Integer status, Date dateCreated, Integer roleId, Long kelasId, Long tingkatId, Long ppdbId, Date updatedAt) {
        this.id = id;
        this.point = point;
        this.nik = nik;
        this.nis = nis;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.password = password;
        this.jk = jk;
        this.ttl = ttl;
        this.prov = prov;
        this.kab = kab;
        this.alamat = alamat;
        this.namaAyah = namaAyah;
        this.namaIbu = namaIbu;
        this.pekAyah = pekAyah;
        this.pekIbu = pekIbu;
        this.namaWali = namaWali;
        this.pekWali = pekWali;
        this.pengOrtu = pengOrtu;
        this.noTelp = noTelp;
        this.thnMsk = thnMsk;
        this.sekolahAsal = sekolahAsal;
        this.kelas = kelas;
        this.imgSiswa = imgSiswa;
        this.imgKk = imgKk;
        this.imgIjazah = imgIjazah;
        this.imgKtp = imgKtp;
        this.idPend = idPend;
        this.idMajors = idMajors;
        this.idKelas = idKelas;
        this.status = status;
        this.dateCreated = dateCreated;
        this.roleId = roleId;
        this.kelasId = kelasId;
        this.tingkatId = tingkatId;
        this.ppdbId = ppdbId;
        this.updatedAt = updatedAt;
    }

    private String nik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public Date getTtl() {
        return ttl;
    }

    public void setTtl(Date ttl) {
        this.ttl = ttl;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getPekAyah() {
        return pekAyah;
    }

    public void setPekAyah(String pekAyah) {
        this.pekAyah = pekAyah;
    }

    public String getPekIbu() {
        return pekIbu;
    }

    public void setPekIbu(String pekIbu) {
        this.pekIbu = pekIbu;
    }

    public String getNamaWali() {
        return namaWali;
    }

    public void setNamaWali(String namaWali) {
        this.namaWali = namaWali;
    }

    public String getPekWali() {
        return pekWali;
    }

    public void setPekWali(String pekWali) {
        this.pekWali = pekWali;
    }

    public String getPengOrtu() {
        return pengOrtu;
    }

    public void setPengOrtu(String pengOrtu) {
        this.pengOrtu = pengOrtu;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public Integer getThnMsk() {
        return thnMsk;
    }

    public void setThnMsk(Integer thnMsk) {
        this.thnMsk = thnMsk;
    }

    public String getSekolahAsal() {
        return sekolahAsal;
    }

    public void setSekolahAsal(String sekolahAsal) {
        this.sekolahAsal = sekolahAsal;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getImgSiswa() {
        return imgSiswa;
    }

    public void setImgSiswa(String imgSiswa) {
        this.imgSiswa = imgSiswa;
    }

    public String getImgKk() {
        return imgKk;
    }

    public void setImgKk(String imgKk) {
        this.imgKk = imgKk;
    }

    public String getImgIjazah() {
        return imgIjazah;
    }

    public void setImgIjazah(String imgIjazah) {
        this.imgIjazah = imgIjazah;
    }

    public String getImgKtp() {
        return imgKtp;
    }

    public void setImgKtp(String imgKtp) {
        this.imgKtp = imgKtp;
    }

    public Integer getIdPend() {
        return idPend;
    }

    public void setIdPend(Integer idPend) {
        this.idPend = idPend;
    }

    public Integer getIdMajors() {
        return idMajors;
    }

    public void setIdMajors(Integer idMajors) {
        this.idMajors = idMajors;
    }

    public Integer getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Integer idKelas) {
        this.idKelas = idKelas;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getKelasId() {
        return kelasId;
    }

    public void setKelasId(Long kelasId) {
        this.kelasId = kelasId;
    }

    public Long getTingkatId() {
        return tingkatId;
    }

    public void setTingkatId(Long tingkatId) {
        this.tingkatId = tingkatId;
    }

    public Long getPpdbId() {
        return ppdbId;
    }

    public void setPpdbId(Long ppdbId) {
        this.ppdbId = ppdbId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @NotNull(message="Wajib di isi")

    private String nis;

    @NotNull(message="Wajib di isi")
    private String nama;

    @NotNull(message="Wajib di isi")
    private String email;

    @Column(name = "no_hp")
    private String noHp;

    private String password;

    private String jk;

    private Date ttl;

    private String prov;

    private String kab;

    private String alamat;

    @Column(name = "nama_ayah")
    private String namaAyah;

    @Column(name = "nama_ibu")
    private String namaIbu;

    @Column(name = "pek_ayah")
    private String pekAyah;

    @Column(name = "pek_ibu")
    private String pekIbu;

    @Column(name = "nama_wali")
    private String namaWali;

    @Column(name = "pek_wali")
    private String pekWali;

    @Column(name = "peng_ortu")
    private String pengOrtu;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "thn_msk")
    private Integer thnMsk;

    @Column(name = "sekolah_asal")
    private String sekolahAsal;

    private String kelas;

    @Column(name = "img_siswa")
    private String imgSiswa;

    @Column(name = "img_kk")
    private String imgKk;

    @Column(name = "img_ijazah")
    private String imgIjazah;

    @Column(name = "img_ktp")
    private String imgKtp;

    @Column(name = "id_pend")
    private Integer idPend;

    @Column(name = "id_majors")
    private Integer idMajors;

    @Column(name = "id_kelas")
    private Integer idKelas;

    private Integer status;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "kelas_id")
    private Long kelasId;

    @Column(name = "tingkat_id")
    private Long tingkatId;

    @Column(name = "ppdb_id")
    private Long ppdbId;

    @Column(name = "updated_at")
    private Date updatedAt;

    // Getter dan Setter
}
