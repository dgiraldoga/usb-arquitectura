import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.KafkaException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class Consumer {

    private KafkaConsumer<String, String> kafkaConsumer;

    private Consumer() {
        try {
            var conf = new Properties();
            conf.load(new FileReader("src/main/resources/consumer.properties"));
            this.kafkaConsumer = new KafkaConsumer(conf);
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }

    public void start() {
        var count = 0;
        do {
            try {
                kafkaConsumer.subscribe(List.of(TOPIC));
                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(20));
                records.forEach(r -> {
                    var msg = String.format(
                            "offset %s, partition %s, key %s, value %s", r.offset(), r.partition(), r.key(), r.value()
                    );
                    log.info(msg);
                });

            } catch (KafkaException e) {
                log.error(e.getMessage());
                this.close();
            }
            count ++;
        } while (count <= 100);
    }

    public void close() {
        this.kafkaConsumer.close();;
    }

    public static Consumer getInstance() {
        return (Objects.nonNull(consumer)) ? consumer : new Consumer();
    }

    private static Consumer consumer;
    private static final String TOPIC = "debuggeando-ideas";
    private static final Logger log = LogManager.getLogger(Consumer.class);
}
