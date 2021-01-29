package com.zdww.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author luohuiqi
 * @Description:
 * @Date: 2021/1/21 15:31
 */
public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.err.println(exchange.getIn());
        String originalFileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
        System.err.println(exchange.getIn().getBody(String.class));
        System.err.println(exchange.getIn().getExchange().getPattern());
        String changedFileName = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + originalFileName;
        exchange.getIn().setHeader(Exchange.FILE_NAME, changedFileName);
    }

//    /**
//     * 从stream中分析字符串内容
//     * @param bodyStream
//     * @return
//     */
//    private String analysisMessage(InputStream bodyStream) throws IOException {
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        byte[] contextBytes = new byte[4096];
//        int realLen;
//        while((realLen = bodyStream.read(contextBytes , 0 ,4096)) != -1) {
//            outStream.write(contextBytes, 0, realLen);
//        }
//
//        // 返回从Stream中读取的字串
//        try {
//            return new String(outStream.toByteArray() , "UTF-8");
//        } finally {
//            outStream.close();
//        }
//    }
}
