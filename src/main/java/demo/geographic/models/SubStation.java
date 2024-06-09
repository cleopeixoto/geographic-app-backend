package demo.geographic.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;

import lombok.Data;

@Data
@Document(collection = "substation")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = { "code" }) })
public class SubStation {
    @Id
    @GeneratedValue
    private String _id;

    @Column(name = "code")
    private String code;

    @Max(100)
    private String name;
    private Double latitude;
    private Double longitude;
    private LocalDateTime created;

    public SubStation(String code, String name, Double latitude, Double longitude, LocalDateTime created) {
        super();
        this.code = code;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.created = created;
    }

    public String getName() {
        return this.name;
    }
    
    public String getCode() {
        return this.code;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
