package demo.geographic.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "substation")
public class SubStation {
    @Id
    @GeneratedValue
    private String _id;

    @Indexed(unique = true)
    private String code;

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
    
    public String getCode() {
        return code;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
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
