package kafka;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringEncoder;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
 
public class ConsumerDemo {
               static final String topic = "test";
               public static void main(String[] args) {
                 Properties prop = new Properties();
                 prop.put("zookeeper.connect", "192.168.1.106:2181");
                 prop.put("metadata.broker.list", "192.168.1.106:9092");
                 prop.put("serializer.class", StringEncoder.class.getName());
                 prop.put("group.id", "group1");
                 // 这里添加超时时间，因为之前默认时间会显示超时错误
                 prop.put("zookeeper.session.timeout.ms", "15000");
                 ConsumerConnector consumer = Consumer.createJavaConsumerConnector(new ConsumerConfig(prop));
                 Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
                 topicCountMap.put(topic, 1);
                 Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
                 final KafkaStream<byte[], byte[]> kafkaStream = messageStreams.get(topic).get(0);
                 ConsumerIterator<byte[], byte[]> iterator = kafkaStream.iterator();
                 while (iterator.hasNext()) {
                      String msg = new String(iterator.next().message());
                      System.out.println("收到消息："+msg);
                 }
           }
 
}