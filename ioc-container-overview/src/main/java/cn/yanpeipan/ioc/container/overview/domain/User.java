package cn.yanpeipan.ioc.container.overview.domain;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private String city;
    private List<String> workCities;
    private List<String> lifeCities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getWorkCities() {
        return workCities;
    }

    public void setWorkCities(List<String> workCities) {
        this.workCities = workCities;
    }

    public List<String> getLifeCities() {
        return lifeCities;
    }

    public void setLifeCities(List<String> lifeCities) {
        this.lifeCities = lifeCities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", workCities=" + workCities +
                ", lifeCities=" + lifeCities +
                '}';
    }
}
