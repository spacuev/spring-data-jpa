package com.sepa.training.spring.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Country() {
    }

    public Country(long id, String code, String shortName, String officialName, String capital, int population) {
        this.id = id;
        this.code = code;
        this.shortName = shortName;
        this.officialName = officialName;
        this.capital = capital;
        this.population = population;
    }

    private String code;

    private String shortName;

    private String officialName;

    private String capital;

    private int population;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", shortName='" + shortName + '\'' +
                ", officialName='" + officialName + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                '}';
    }
}
