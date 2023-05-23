import com.soumen.dataProcessor.DataProcessor;
import com.soumen.dataProcessor.OrderDataProcessorImpl;
import com.soumen.dataReader.CSVDataReaderImpl;
import com.soumen.dataReader.DataReader;
import com.soumen.logger.OrderLogger;
import com.soumen.orderParser.CSVDataParserImpl;
import com.soumen.orderParser.OrderParser;
import com.soumen.orderPersister.OrderDataPersister;
import com.soumen.orderSplitter.OrderDataSplitter;

public class OrderProcessorApplication {
    public static void main(String[] args) {
        OrderParser orderParser = new CSVDataParserImpl();
        DataReader dataReader = new CSVDataReaderImpl("orders.csv", orderParser);
        OrderDataSplitter orderDataSplitter = new OrderDataSplitter();
        OrderDataPersister orderDataPersister = new OrderDataPersister();
        OrderLogger OrderLogger = com.soumen.logger.OrderLogger.getInstance();

        DataProcessor orderDataProcessor = new OrderDataProcessorImpl(dataReader, orderDataSplitter, orderDataPersister, OrderLogger);
        orderDataProcessor.processDataOrders();
    }
}
