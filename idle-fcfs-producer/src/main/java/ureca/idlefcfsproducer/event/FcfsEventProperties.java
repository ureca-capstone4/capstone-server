package ureca.idlefcfsproducer.event;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "event.fcfs")
public class FcfsEventProperties {
    private String title;
    private String limit;
}
