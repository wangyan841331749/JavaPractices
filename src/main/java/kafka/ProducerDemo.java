package kafka;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;
import java.util.Properties;
 
public class ProducerDemo {
 
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.put("zookeeper.connect", "192.168.1.106:2181");
        prop.put("metadata.broker.list", "192.168.1.106:9092");
        prop.put("serializer.class", StringEncoder.class.getName());
        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(prop));
        int i = 0;
        while (true) {
            producer.send(new KeyedMessage<String, String>("test", "msg:" + i++));
            System.out.println("发送消息成功！");
            Thread.sleep(1000);
        }
    }
}