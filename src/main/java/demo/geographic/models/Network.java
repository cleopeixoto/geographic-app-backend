package demo.geographic.models;
 
import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Network {
    @Id
    @GeneratedValue
    private String _id;

    @Id
    @NotNull
    private String subStationId;

    @Column(unique = true)
    @Max(3)
    private String code;

    @Max(100)
    private String name;

    private Float tension; // Not being used (?)
    private LocalDateTime created;

    public Network(String subStationId, String name, Float tension, LocalDateTime created) {
        super();
        this.subStationId = subStationId;
        this.name = name;
        this.tension = tension;
        this.created = created;
    }

    public String getSubStationId() {
        return this.subStationId;
    }

    public String getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }

    public Float getTension() {
        return this.tension;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTension(Float tension) {
        this.tension = tension;
    }
}
